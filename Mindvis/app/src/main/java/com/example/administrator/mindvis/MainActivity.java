package com.example.administrator.mindvis;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.administrator.mindvis.Constants.JSON;




public class MainActivity extends AppCompatActivity {

    EditText txt_email, txt_password;
    Button bt_login,btnc;
    public static final String SERVER_URL ="http://fame.mindvis.in/api/pitch";
    UserModel userModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_email = (EditText)findViewById(R.id.edtuname);
        txt_password = (EditText)findViewById(R.id.edtpswd);
        bt_login = (Button)findViewById(R.id.btnsignin);
        btnc = (Button)findViewById(R.id.btncoarse);
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(MainActivity.this, Coarse_start.class);
                startActivity(i);

            }
        });
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendLoginRequest();
            }
        });
    }
    public void sendLoginRequest(){
        if(VerificationUtils.isEmptyText(txt_email) || VerificationUtils.isEmptyText(txt_password))
            return;
        if(VerificationUtils.isValidEmail(txt_email.getText().toString()) == false){
            txt_email.setError("invalid email address");
            return;
        }
        try {
            ShowProgressDialog.showProgressDialog(MainActivity.this, "Log in");
            LoginService service = new LoginService(createJsonObject(txt_email.getText().toString(), txt_password.getText().toString()), new AsyncTaskResponse() {
                @Override
                public void response(Object o) {

                    ShowProgressDialog.hideProgressDialog();
                    try {
                        JSONObject result_object = new JSONObject((String) o);
                        if(result_object.getInt("success") == 1){
                            String token = result_object.getString("token");
                            System.out.println("token"+token);
                            TokenManage.setToken(MainActivity.this.getApplicationContext(), token);
                            userModel = new UserModel(result_object.getJSONObject("user"));
                            gotoNextScreen();
                        }
                        else{
                            new AlertDialog.Builder(MainActivity.this).setMessage(result_object.getString("message")).setTitle("Error")
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.dismiss();
                                        }
                                    }).show();
                        }
                    }catch (Exception e){
                        Toast.makeText(MainActivity.this,"Wrong Credential",
                                Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                }
            });
            service.execute();
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    private void gotoNextScreen(){
        Intent i  = new Intent(MainActivity.this, Main_Screen.class);
        i.putExtra("user",userModel);
        startActivity(i);
        finish();
    }

    private JSONObject createJsonObject(String email, String password) throws JSONException{
        JSONObject request_content = new JSONObject();
        JSONObject request_data = new JSONObject();
        request_content.put("email", email);
        request_content.put("password", password);
        request_data.put("pitch", "login");
        request_data.put("data", request_content);
        return request_data;
    }

    public class LoginService extends AsyncTask{
        AsyncTaskResponse response;
        JSONObject request_object;
        OkHttpClient okhttp;
        public LoginService(JSONObject request_object, AsyncTaskResponse response){
            this.response = response;
            this.request_object = request_object;
            okhttp = new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).connectTimeout(10, TimeUnit.SECONDS).build();
        }

        @Override
        protected Object doInBackground(Object[] objects) {

            RequestBody body = RequestBody.create(JSON, request_object.toString());
            Request request = new Request.Builder()
                    .addHeader("Content-Type","application/json")
                    .addHeader("Accept","application/json")
                    .url(SERVER_URL)
                    .post(body)
                    .build();
            try {
                Response response = okhttp.newCall(request).execute();
                return
                        response.body().string();
            }catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            response.response(o);
        }
    }
}

