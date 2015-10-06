package wyz.android.com.demo_okhttp;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by wangyuzhe on 10/3/15.
 */
public class AsygetContent extends AsyncTask<List<URL>,Integer,String[]> {
    private Interface<String[]> callback;
    private Context context;
    private String[] finalResult;

    public AsygetContent(Context context, Interface<String[]> callback)
    {
        this.context = context;
        this.callback = callback;
    }

    @Override
    protected String[] doInBackground(List<URL>... params) {
        String[] a = new String[params[0].size()];
        for(int i=0;i<params[0].size();i++)
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
//        List<Model> list_1 = new ArrayList<>();
//        for(int i=0;i<s.length;i++)
//        {
//            Gson gson_1 = new Gson();
//            Model model = gson_1.fromJson(s[i],Model.class);
//            list_1.add(model);
//        }
        callback.onTaskComplete(s);
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
