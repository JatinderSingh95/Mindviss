package com.example.administrator.mindvis;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import okhttp3.Response;

import static android.R.attr.id;

public class module extends AppCompatActivity {

    ImageView imageView;
    TextView textView1,textView,textView2;;
    ImageLoader imageLoader;
    public static final String SERVER_URL ="http://fame.mindvis.in/api/pod/courses";
    ArrayList<String>arrayname;
    ArrayList<String>arraycon;
    ArrayList<String>arrayprev;
    ArrayList<String>arrayimg;
//    int[] imageId = {};

    GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
        textView=(TextView)findViewById(R.id.txt1);
        textView1=(TextView)findViewById(R.id.prev);
        textView2=(TextView)findViewById(R.id.txtcon);
        imageView=(ImageView)findViewById(R.id.img1);
        arrayname=new ArrayList<>();
        arraycon=new ArrayList<>();
        arrayimg=new ArrayList<>();
        arrayprev=new ArrayList<>();
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(getApplicationContext()));

        ShowProgressDialog.showProgressDialog(module.this, "Log in");
        LoginService service = new LoginService( new AsyncTaskResponse() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void response(Object o) {

                ShowProgressDialog.hideProgressDialog();
                try {
                    JSONObject result_object = new JSONObject((String) o);
                    JSONArray jsonArray =result_object.getJSONArray("courses");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject c = jsonArray.getJSONObject(i);

                        String id =c.getString("id");
                        if (Coarse_start.info==0&& Objects.equals(id, "dignissimos-ipsa-voluptatum-molestiaehkdih")){
                            String pre = c.getString("preview");
                            String name = c.getString("title");
                            String img = c.getString("image_url");
                            String con = c.getString("content");
                            arrayprev.add(pre);
                            arrayname.add(name);
                            arrayimg.add(img);
                            arraycon.add(con);
                            textView.setText(" "+arrayname);
                            textView1.setText(""+arrayprev);
                            textView2.setText("Content:-"+arraycon);
                            imageLoader.displayImage(arrayimg.get(0), imageView);
                            System.out.println(" "+textView);
                        }
                        if (Coarse_start.info==1&& Objects.equals(id, "officia-magnam-pariaturstrmt")){
                            String pre = c.getString("preview");
                            String name = c.getString("title");
                            String img = c.getString("image_url");
                            String con = c.getString("content");
                            arrayprev.add(pre);
                            arrayname.add(name);
                            arrayimg.add(img);
                            arraycon.add(con);
                            textView.setText(" "+arrayname);
                            textView1.setText(""+arrayprev);
                            textView2.setText("Content:-"+arraycon);
                            imageLoader.displayImage(arrayimg.get(0), imageView);
                            System.out.println(" "+textView);
                        }
                        if (Coarse_start.info==2&& Objects.equals(id, "quia-sit-quibusdam-beataezbzic")){
                            String pre = c.getString("preview");
                            String name = c.getString("title");
                            String img = c.getString("image_url");
                            String con = c.getString("content");
                            arrayprev.add(pre);
                            arrayname.add(name);
                            arrayimg.add(img);
                            arraycon.add(con);
                            textView.setText(" "+arrayname);
                            textView1.setText(""+arrayprev);
                            textView2.setText("Content:-"+arraycon);
                            imageLoader.displayImage(arrayimg.get(0), imageView);
                            System.out.println(" "+textView);
                        }
                        if (Coarse_start.info==3&& Objects.equals(id, "explicabo-ex-molestias-occaecati-adipisciebtil")){
                            String pre = c.getString("preview");
                            String name = c.getString("title");
                            String img = c.getString("image_url");
                            String con = c.getString("content");
                            arrayprev.add(pre);
                            arrayname.add(name);
                            arrayimg.add(img);
                            arraycon.add(con);
                            textView.setText(" "+arrayname);
                            textView1.setText(""+arrayprev);
                            textView2.setText("Content:-"+arraycon);
                            imageLoader.displayImage(arrayimg.get(0), imageView);
                            System.out.println(" "+textView);
                        }
                        if (Coarse_start.info==4&& Objects.equals(id, "magni-nihil-voluptatumklgma")){
                            String pre = c.getString("preview");
                            String name = c.getString("title");
                            String img = c.getString("image_url");
                            String con = c.getString("content");
                            arrayprev.add(pre);
                            arrayname.add(name);
                            arrayimg.add(img);
                            arraycon.add(con);
                            textView.setText(" "+arrayname);
                            textView1.setText(""+arrayprev);
                            textView2.setText("Content:-"+arraycon);
                            imageLoader.displayImage(arrayimg.get(0), imageView);
                            System.out.println(" "+textView);
                        }
                        if (Coarse_start.info==5&& Objects.equals(id, "aliquid-a-totam-deleniti-excepturi-sapiente-dignissimosussns")){
                            String pre = c.getString("preview");
                            String name = c.getString("title");
                            String img = c.getString("image_url");
                            String con = c.getString("content");
                            arrayprev.add(pre);
                            arrayname.add(name);
                            arrayimg.add(img);
                            arraycon.add(con);
                            textView.setText(" "+arrayname);
                            textView1.setText(""+arrayprev);
                            textView2.setText("Content:-"+arraycon);
                            imageLoader.displayImage(arrayimg.get(0), imageView);
                            System.out.println(" "+textView);
                        }
                        if (Coarse_start.info==6&& Objects.equals(id, "harum-amet-itaque-sapiente-consequaturuyzcn")){
                            String pre = c.getString("preview");
                            String name = c.getString("title");
                            String img = c.getString("image_url");
                            String con = c.getString("content");
                            arrayprev.add(pre);
                            arrayname.add(name);
                            arrayimg.add(img);
                            arraycon.add(con);
                            textView.setText(" "+arrayname);
                            textView1.setText(""+arrayprev);
                            textView2.setText("Content:-"+arraycon);
                            imageLoader.displayImage(arrayimg.get(0), imageView);
                            System.out.println(" "+textView);
                        }
                        if (Coarse_start.info==7&& Objects.equals(id, "aperiam-inventore-odio-nisi-eumynqsb")){
                            String pre = c.getString("preview");
                            String name = c.getString("title");
                            String img = c.getString("image_url");
                            String con = c.getString("content");
                            arrayprev.add(pre);
                            arrayname.add(name);
                            arrayimg.add(img);
                            arraycon.add(con);
                            textView.setText(" "+arrayname);
                            textView1.setText(""+arrayprev);
                            textView2.setText("Content:-"+arraycon);
                            imageLoader.displayImage(arrayimg.get(0), imageView);
                            System.out.println(" "+textView);
                        }
                        if (Coarse_start.info==8&& Objects.equals(id, "magni-soluta-cumque-rem-assumenda-quis-rerum-quijnbnw")){
                            String pre = c.getString("preview");
                            String name = c.getString("title");
                            String img = c.getString("image_url");
                            String con = c.getString("content");
                            arrayprev.add(pre);
                            arrayname.add(name);
                            arrayimg.add(img);
                            arraycon.add(con);
                            textView.setText(" "+arrayname);
                            textView1.setText(""+arrayprev);
                            textView2.setText("Content:-"+arraycon);
                            imageLoader.displayImage(arrayimg.get(0), imageView);
                            System.out.println(" "+textView);
                        }
                        if (Coarse_start.info==9&& Objects.equals(id, "non-sit-fugiatexwlt")){
                            String pre = c.getString("preview");
                            String name = c.getString("title");
                            String img = c.getString("image_url");
                            String con = c.getString("content");
                            arrayprev.add(pre);
                            arrayname.add(name);
                            arrayimg.add(img);
                            arraycon.add(con);
                            textView.setText(" "+arrayname);
                            textView1.setText(""+arrayprev);
                            textView2.setText("Content:-"+arraycon);
                            imageLoader.displayImage(arrayimg.get(0), imageView);
                            System.out.println(" "+textView);
                        }

                        if (Coarse_start.info==10&& Objects.equals(id, "quibusdam-nam-dolorem-nequeistsz")){
                            String pre = c.getString("preview");
                            String name = c.getString("title");
                            String img = c.getString("image_url");
                            String con = c.getString("content");
                            arrayprev.add(pre);
                            arrayname.add(name);
                            arrayimg.add(img);
                            arraycon.add(con);
                            textView.setText(" "+arrayname);
                            textView1.setText(""+arrayprev);
                            textView2.setText("Content:-"+arraycon);
                            imageLoader.displayImage(arrayimg.get(0), imageView);
                            System.out.println(" "+textView);
                        }
                        if (Coarse_start.info==11&& Objects.equals(id, "pariatur-nobis-reiciendis-maioresrovez")){
                            String pre = c.getString("preview");
                            String name = c.getString("title");
                            String img = c.getString("image_url");
                            String con = c.getString("content");
                            arrayprev.add(pre);
                            arrayname.add(name);
                            arrayimg.add(img);
                            arraycon.add(con);
                            textView.setText(" "+arrayname);
                            textView1.setText(""+arrayprev);
                            textView2.setText("Content:-"+arraycon);
                            imageLoader.displayImage(arrayimg.get(0), imageView);
                            System.out.println(" "+textView);
                        }


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

