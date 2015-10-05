package wyz.android.com.demo_okhttp;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import wyz.android.com.model.Model;

/**
 * Created by wangyuzhe on 10/3/15.
 */
public class AsygetContent extends AsyncTask<List<URL>,Integer,String[]> {
    private Interface<List<Model>> callback;
    private Context context;
    private String[] finalResult;

    public AsygetContent(Context context, Interface<List<Model>> callback)
    {
        this.context = context;
        this.callback = callback;
    }

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
        callback.onTaskComplete(list_1);
//        MyAdapter adapter_1 = new MyAdapter(list_1,MainActivity.this);
//        mRecycler.setAdapter(adapter_1);
//        mProgressDialog.cancel();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
//        mProgressDialog.setProgress(values[0]);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        mProgressDialog.show();
    }
}
