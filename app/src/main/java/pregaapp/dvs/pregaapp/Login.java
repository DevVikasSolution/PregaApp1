package pregaapp.dvs.pregaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import org.w3c.dom.Text;

import java.security.AccessController;

import static java.security.AccessController.*;
import static java.security.AccessController.getContext;

public class Login extends AppCompatActivity {
    Toolbar toolbar;
    EditText mobilenum, etpassword;
    Button loginbtn;
    TextView textView;
    String phonenumber = "";
    String Password = "";


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mobilenum =  findViewById(R.id.mobilenumber);
        etpassword =  findViewById(R.id.Password);
        loginbtn =  findViewById(R.id.login);
        textView = findViewById(R.id.text);
        toolbar =  findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp); // Set the icon


        // Icon click listener
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumber = mobilenum.getText().toString();
                Password = etpassword.getText().toString();
                boolean isValid = true;
                if (TextUtils.isEmpty(Password)) {
                    etpassword.setError("Password cannot be Empty");
                    isValid = false;
                    return;
                }
                String regexStr = "^\\+[0-9]{10,13}$";
                if (phonenumber.length() < 10 || phonenumber.length() > 13 || phonenumber.matches(regexStr)) {
                    mobilenum.setError("mobile number is not valid");
                    isValid = false;
                    return;
                }
                if (isValid == true) {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);

                }
            }
        });

    }


}







