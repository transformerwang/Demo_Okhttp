package wyz.android.com.demo_okhttp;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import wyz.android.com.adapter.MyAdapter;
import wyz.android.com.model.Model;

public class MainActivity extends AppCompatActivity implements Interface<String[]> {

    private URL url;
    private URL url_1;
    private ProgressDialog mProgressDialog;
    private RecyclerView mRecycler;
    private RecyclerView.LayoutManager lg;
    private List<URL> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setCancelable(false);


        mRecycler = (RecyclerView)findViewById(R.id.recycler_view);//RecyclerView
        mRecycler.setHasFixedSize(true);

        lg = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(lg);

        
        //getContent get = new getContent();
        try {
            url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Beijing");
            url_1 = new URL("http://api.openweathermap.org/data/2.5/weather?q=London");
            list.add(url);
            list.add(url_1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        launchTask(list);
        //MyAdapter adapter = new MyAdapter(asygetContent.getModel(),MainActivity.this);
        //mRecycler.setAdapter(adapter);
        //get.execute(list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTaskComplete(String[] result) {
        //Toast.makeText(MainActivity.this,result.get(0).getName(),Toast.LENGTH_LONG).show();
        List<Model> list_1 = new ArrayList<>();
        for(int i=0;i<result.length;i++)
        {
            Gson gson_1 = new Gson();
            Model model = gson_1.fromJson(result[i],Model.class);
            list_1.add(model);
        }
        MyAdapter adapter_1 = new MyAdapter(list_1,MainActivity.this);
        mRecycler.setAdapter(adapter_1);
    }

    public void launchTask(List<URL> list)
    {
        AsygetContent asy = new AsygetContent(this,this);
        asy.execute(list);
    }
/*
    public class getContent extends AsyncTask<List<URL>,Integer,String[]>
    {

        @Override
        protected String[] doInBackground(List<URL>... params) {
            String[] a = new String[2];
            for(int i=0;i<2;i++)
            {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(params[0].get(i)).build();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    a[i]= response.body().string();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            return a;
        }

        @Override
        protected void onPostExecute(String[] s) {
            super.onPostExecute(s);
            List<Model> list_1 = new ArrayList<>();
            for(int i=0;i<2;i++)
            {
                Gson gson_1 = new Gson();
                Model model = gson_1.fromJson(s[i],Model.class);
                list_1.add(model);
            }

            MyAdapter adapter_1 = new MyAdapter(list_1,MainActivity.this);
            mRecycler.setAdapter(adapter_1);
            mProgressDialog.cancel();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mProgressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog.show();
        }
    }
*/
}
