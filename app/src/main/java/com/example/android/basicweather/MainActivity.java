package com.example.android.basicweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnTodoCheckedChangeListener {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mImagesContent = new ArrayList<>();
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToast = null;
        Log.d(TAG, "onCreate: started.");

        initImageBitMaps();
    }

    private void initImageBitMaps(){

        Log.d(TAG, "initImageBitmaps: preparing bitmaps");

        mImageUrls.add("https://www.shareicon.net/data/2016/08/02/805630_sun_512x512.png");
        mNames.add("Thursday January 23 - Sunny and Warm - 75F");
        mImagesContent.add("Cloudless and generally warm, with a high of 75F and a low of 57F.  Some high clouds late in the day.");

        mImageUrls.add("http://cdn.onlinewebfonts.com/svg/img_541796.png");
        mNames.add("Friday January 24 - Mostly Cloudy - 56F");
        mImagesContent.add("Chilly and cold , with a high of 60 F and a low of 56F.  Mostly cloud during the day.");

        mImageUrls.add("https://cdn3.iconfinder.com/data/icons/weather-emojis/513/emoji-emoticon-weather-face-smiley-happy_15-512.png");
        mNames.add("Saturday January 25 - Rain - 54F");
        mImagesContent.add("Cold and rainy , with a high of 55 F and a low of 54F.  Rain throughout the day.");

        mImageUrls.add("https://www.pinclipart.com/picdir/middle/5-52873_rain-clipart-file-folder-emojis-clip-art-png.png");
        mNames.add("Monday January 26 - Shower Rain - 50F");
        mImagesContent.add("Shower rain , with a high of 54 F and a low of 50F.  Rain throughout the day.");

        mImageUrls.add("https://www.shareicon.net/data/2016/08/02/805630_sun_512x512.png");
        mNames.add("5 Wed April 12 - Sunny and Warm - 75F");

        mImageUrls.add("https://www.shareicon.net/data/2016/08/02/805630_sun_512x512.png");
        mNames.add("6 Wed April 12 - Sunny and Warm - 75F");

        mImageUrls.add("https://www.shareicon.net/data/2016/08/02/805630_sun_512x512.png");
        mNames.add("7 Wed April 12 - Sunny and Warm - 75F");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerview = findViewById(R.id.rv_weather_info);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this , mNames, mImageUrls,mImagesContent,this, mToast);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onTodoCheckedChanged(String imageContent, boolean isChecked) {
        if (mToast != null) {
            mToast.cancel();
        }
    //    String completed = isChecked ? "COMPLETED" : "MARKED INCOMPLETE";
     //   String toastText = completed + ": " + todoText;
      //  mToast = Toast.makeText(this, toastText, Toast.LENGTH_LONG);
       // mToast.show();
    }

}
