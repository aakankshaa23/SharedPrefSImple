package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText email, password;
    CheckBox remember;
    Button Login;
    private SharedPreferences mshared;
    private SharedPreferences.Editor meditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email_user);
        password = findViewById(R.id.password_user);
        remember = findViewById(R.id.remember_user);
        Login = findViewById(R.id.login_user);
        mshared = PreferenceManager.getDefaultSharedPreferences(this);
        meditor = mshared.edit();
        checkSharedPref();
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(remember.isChecked()){
                    meditor.putString("checkbox","True");
                    meditor.commit();
                    meditor.putString("email",email.getText().toString().trim());
                    meditor.commit();
                    meditor.putString("password",password.getText().toString().trim());

                }
                else{
                    meditor.putString("checkbox","False");
                    meditor.commit();
                    meditor.putString("email"," ");
                    meditor.commit();
                    meditor.putString("password"," ");
                    meditor.commit();

                }
            }
        });

    }
    public void checkSharedPref(){
        String checkbox=mshared.getString("checkbox","False");
        String name=mshared.getString("email","");
        String password_shared=mshared.getString("password","");
        email.setText(name);
        password.setText(password_shared);
        if(checkbox.equals("True")){
            remember.setChecked(true);
        }
        else
            remember.setChecked(false);

    }
}
