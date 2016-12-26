package com.nico.ngram;

import  android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nico.ngram.view.ContainerActivity;
import com.nico.ngram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        final TextInputEditText etEmail = (TextInputEditText) findViewById(R.id.username);
        final TextInputEditText etPassword = (TextInputEditText) findViewById(R.id.password);

        Button btnLogin = (Button) findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etEmail.getContext().toString().trim();
                String password = etPassword.getContext().toString().trim();

                if(email.equals("")){
                    Toast.makeText(LoginActivity.this, "Ingrese un nombre de usuario válido", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(password.equals("")){
                    Toast.makeText(LoginActivity.this, "Ingrese una contraseña de usuario válida", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                FirebaseUser user = task.getResult().getUser();
                                SharedPreferences.Editor sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE).edit();
                                sharedPreferences.putString("email", user.getEmail());
                                sharedPreferences.commit();

                                if(!task.isSuccessful()){
                                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_LONG).show();
                                }else {
                                    goHome();
                                }
                            }
                        });
            }
        });


    }



    public void goCreateAccount(View v) {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void goHome(){
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }
}
