package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signuppage extends AppCompatActivity {

    TextView textView,signup;
    Button button;
    TextInputEditText emailedit,passwordedit1,passwordedit2;
    TextInputLayout usernamelayout,emaillayout,passwordlayout1,passwordlayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);

        textView=findViewById(R.id.login);
        button=findViewById(R.id.signupbutton);
        emailedit=findViewById(R.id.emailedittext);
        emaillayout=findViewById(R.id.signupoutlinedTextField1);
        passwordedit1=findViewById(R.id.signuppassword1);
        passwordlayout1=findViewById(R.id.signupoutlinedTextField2);
        passwordedit2=findViewById(R.id.signuppassword2);
        passwordlayout2=findViewById(R.id.signupoutlinedTextField3);
        signup=findViewById(R.id.signupusername);
        usernamelayout=findViewById(R.id.signupoutlinedTextField);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(signuppage.this,loginpage.class);
                startActivity(i);
                finish();
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String regex="^(.+)@(.+)$";
                Pattern pattern=Pattern.compile(regex);
                String checkemail=emailedit.getText().toString();
                String checkusername=signup.getText().toString();
                if(checkemail.matches(""))
                {
                    emaillayout.setError("Enter Email");
                }
                Matcher matcher=pattern.matcher(checkemail);
                if(checkusername.isEmpty())
                {
                    usernamelayout.setError("Enter username");
                }
                if(!(checkusername.isEmpty()))
                {
                    usernamelayout.setError(null);
                }

                if(!(matcher.matches()))
                {
                    emaillayout.setError("Enter Valid Email Id");
                }
                if((matcher.matches()))
                {
                    emaillayout.setError(null);
                }
                if(passwordedit1.length()==0)
                {
                    passwordlayout1.setError("Enter password");
                }
                if(!(passwordedit1.length()==0))
                {
                    passwordlayout1.setError(null);
                }

                if(passwordedit2.length()==0)
                {
                    passwordlayout2.setError("Enter password");
                }
                if(!(passwordedit2.length()==0))
                {
                    passwordlayout2.setError(null);
                }
                String pass1=passwordedit1.getText().toString();
                String pass2=passwordedit2.getText().toString();

                if (pass1.equals(pass2)) {
                        passwordlayout1.setError(null);
                        passwordlayout2.setError(null);
                }
                if (pass1 != pass2) {
                        passwordlayout1.setError("Password Mismatch");
                        passwordlayout2.setError("Password Mismatch");
                }
               // postRequest();
            }
        });
    }
    /*private void postRequest()
    {
        RequestQueue requestQueue= Volley.newRequestQueue(signuppage.this);
        String url="http://localhost:3000/register";
        StringRequest stringRequest=new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast t=Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT);
                t.show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast t=Toast.makeText(getApplicationContext(),"Fail",Toast.LENGTH_SHORT);
                t.show();
            }
        }){
            @Override
            protected Map<String,String> getParams()
            {
                Map<String,String> params=new HashMap<String, String>();
                params.put("username","joe");
                params.put("password","password");
                params.put("email","joe@gmail.com");
                return params;
            }
            @Override
            public Map<String,String > getHeaders() throws AuthFailureError{
                Map<String,String> params=new HashMap<String, String>();
                params.put("Content-Type","application/json");
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }*/
}