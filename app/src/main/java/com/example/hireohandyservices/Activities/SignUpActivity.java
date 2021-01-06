package com.example.hireohandyservices.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hireohandyservices.Constants;
import com.example.hireohandyservices.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    TextInputLayout email,password,third;
    Button signUp;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up);

        connectViews();
        signUp();

    }

    private void signUp() {
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(SignUpActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                progressDialog.setCancelable(false);
                if (!validateEmail() || !validatePassword() || !validateThird()){
                    return;
                }else{
                    dataToServerForSignUp();
                }
            }
        });
    }
    private void dataToServerForSignUp() {
        StringRequest request = new StringRequest(Request.Method.POST, Constants.url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(SignUpActivity.this, ""+ response.toString(), Toast.LENGTH_SHORT).show();
                if (response.equals("User is Successfully Added")){
                    progressDialog.dismiss();
                    Intent intent1 = new Intent(SignUpActivity.this, LoginActivity.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent1);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SignUpActivity.this, "" + error.toString(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> sendData = new HashMap<String, String>();
                sendData.put("email",email.getEditText().getText().toString());
                sendData.put("password",password.getEditText().getText().toString());
                sendData.put("third",third.getEditText().getText().toString());
                return sendData;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(0,0,DefaultRetryPolicy.DEFAULT_TIMEOUT_MS));
        RequestQueue requestQueue = Volley.newRequestQueue(SignUpActivity.this);
        requestQueue.add(request);
    }

    private void connectViews() {
        email = findViewById(R.id.signUp_email);
        password = findViewById(R.id.signUp_password);
        third = findViewById(R.id.signUp_third);
        signUp = findViewById(R.id.signUp);
    }

    private Boolean validateEmail(){
        if (getText(email).isEmpty()){
            email.setError("Required!");
            email.requestFocus();
            return false;
        }else{
            email.setError(null);
            return true;
        }
    }
    private Boolean validatePassword(){
        if (getText(password).isEmpty()){
            password.setError("Required!");
            password.requestFocus();
            return false;
        }else{
            password.setError(null);
            return true;
        }
    }
    private Boolean validateThird(){
        if (getText(third).isEmpty()){
            third.setError("Required!");
            third.requestFocus();
            return false;
        }else{
            third.setError(null);
            return true;
        }
    }


    private String getText(TextInputLayout textInputLayout){
        return textInputLayout.getEditText().getText().toString();
    }


}