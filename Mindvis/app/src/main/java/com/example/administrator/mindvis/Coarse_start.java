package com.example.administrator.mindvis;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import okhttp3.Response;
public class Coarse_start extends AppCompatActivity {


    public static final String SERVER_URL ="http://fame.mindvis.in/api/pod/courses";
    ArrayList<String>arrayname;
    ArrayList<String>arrayimg;
//    int[] imageId = {};

    GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coarse_start);
           arrayname=new ArrayList<>();
           arrayimg=new ArrayList<>();
        final CustomGrid adapter = new CustomGrid(Coarse_start.this, arrayname, arrayimg);
        grid=(GridView)findViewById(R.id.grid_view);

        ShowProgressDialog.showProgressDialog(Coarse_start.this, "Log in");
        LoginService service = new LoginService( new AsyncTaskResponse() {
            @Override
            public void response(Object o) {

                ShowProgressDialog.hideProgressDialog();
                try {
                    JSONObject result_object = new JSONObject((String) o);
                    JSONArray jsonArray =result_object.getJSONArray("courses");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject c = jsonArray.getJSONObject(i);


                        String name = c.getString("title");
                        String img = c.getString("image_url");

                        arrayname.add(name);
                        arrayimg.add(img);
                        grid.setAdapter(adapter);

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        service.execute();
    }





    public class LoginService extends AsyncTask{
        AsyncTaskResponse response;

        OkHttpClient okhttp;
        public LoginService( AsyncTaskResponse response){
            this.response = response;
            okhttp = new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).connectTimeout(10, TimeUnit.SECONDS).build();
        }

        @Override
        protected Object doInBackground(Object[] objects) {


            Request request = new Request.Builder()
                    .addHeader("Content-Type","application/json")
                    .addHeader("Accept","application/json")
                    .url(SERVER_URL)
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
            System.out.println("Mindvis"+o);
        }
    }
}

