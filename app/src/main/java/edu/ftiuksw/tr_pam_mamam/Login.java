package edu.ftiuksw.tr_pam_mamam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText memail,mpassword;
    Button mLoginbtn;
    TextView mregister,mforgot;
    ProgressBar mprogressbar;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        memail = findViewById(R.id.Email_Insert);
        mpassword = findViewById(R.id.Passowrd_Insert_login);
        mregister = findViewById(R.id.ready_register);
        mLoginbtn = findViewById(R.id.Btn_Login);
        mprogressbar = findViewById(R.id.progressBar_Login);
        firebaseAuth = FirebaseAuth.getInstance();
        mforgot = findViewById(R.id.btn_forgot_pass_login);

        mLoginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    memail.setError("Email Required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mpassword.setError("Password Required");
                    return;
                }
                if (password.length()<6){
                    mpassword.setError("Password must be More 6 characters");
                    return;
                }
                mprogressbar.setVisibility(View.VISIBLE);

                //auth user

                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                   if (task.isSuccessful()){
                       Intent intent = new Intent(Login.this,HomeActivity.class);
                       intent.putExtra("email",email);
                       startActivity(intent);
                       mprogressbar.setVisibility(View.INVISIBLE);
                   }else{
                       Toast.makeText(Login.this,"Error! "+task.getException().getMessage(),
                               Toast.LENGTH_LONG).show();
                       mprogressbar.setVisibility(View.INVISIBLE);
                         }
                    }
                });
            }
        });
        mregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
                mprogressbar.setVisibility(View.VISIBLE);
            }
        });

        mforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText email = new EditText(v.getContext());
                final AlertDialog.Builder resetpassword = new AlertDialog.Builder(v.getContext());
                resetpassword.setTitle("Password Reset Request");
                resetpassword.setMessage("enter your email");
                resetpassword.setView(email);

                resetpassword.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mail = email.getText().toString();
                        firebaseAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Login.this,"Check Your Email for Reset Password",Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this, "Error, We Couldn't find Your Email !"+e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
               resetpassword.setNegativeButton("No", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               });
               resetpassword.create().show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}
