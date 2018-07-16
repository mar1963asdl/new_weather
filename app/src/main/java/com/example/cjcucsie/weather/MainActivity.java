package com.example.cjcucsie.weather;

import android.Manifest;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        int permission = ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.INTERNET);

        new Thread(new Runnable() {
            public void run() {
                try {
                    String result = runData("https://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=b6907d289e10d714a6e88b30761fae22");
                    System.out.println("result " + result);
                    final Book book=new Book(result);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TextView textView=findViewById(R.id.tempTextView);
                            textView.setText(book.temp.toString());
                            TextView textView1=findViewById(R.id.pressureTextView);
                            textView1.setText(book.pressure.toString());
                            TextView textView2=findViewById(R.id.humidityTextView);
                            textView2.setText(book.humidity.toString());
                            TextView textView3=findViewById(R.id.temp_maxTextView);
                            textView3.setText(book.temp_max.toString());
                            TextView textView4=findViewById(R.id.temp_minTextView);
                            textView4.setText(book.temp_min.toString());
                            TextView textView5=findViewById(R.id.sea_levelTextView);
                            textView5.setText(book.sea_level.toString());
                            TextView textView6=findViewById(R.id.grnd_levelTextView);
                            textView6.setText(book.grnd_level.toString());



                        }
                    });


//                    try {
//                        JSONObject jsonObject = new JSONObject(result);
//                        JSONObject mainJsonObject = jsonObject.getJSONObject("main");
//                        Double temp = mainJsonObject.getDouble("temp");
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
                    Log.d("Ma", " dsjkfklsd");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    String runData(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

//    String result_xml = "";
//    String path = "https://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=b6907d289e10d714a6e88b30761fae22";
//
//    Runnable task = new Runnable(){
//        @Override
//        public void run() {
//            parseXml(result_xml);
//        }
//    };
}
