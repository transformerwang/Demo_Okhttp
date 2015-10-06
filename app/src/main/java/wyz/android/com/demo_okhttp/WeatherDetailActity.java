package wyz.android.com.demo_okhttp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.gson.Gson;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import wyz.android.com.model.WeatherWhole;

/**
 * Created by wangyuzhe on 10/4/15.
 */
public class WeatherDetailActity extends AppCompatActivity implements Interface<String[]>{

    private List<URL> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent =getIntent();
        //Toast.makeText(this, intent.getStringExtra("name"),Toast.LENGTH_SHORT).show();
        intent.getStringExtra("name");
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?q="+intent.getStringExtra("name"));
            list.add(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        launchTask(list);
    }

    @Override
    public void onTaskComplete(String[] result) {
        Gson gson = new Gson();
        WeatherWhole ww = gson.fromJson(result[0],WeatherWhole.class);
        Toast.makeText(this,ww.getCnt(),Toast.LENGTH_LONG).show();
    }

    public void launchTask(List<URL> list)
    {
        AsygetContent asy = new AsygetContent(this,this);
        asy.execute(list);
    }
}
