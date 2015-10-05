package wyz.android.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import wyz.android.com.demo_okhttp.R;
import wyz.android.com.demo_okhttp.WeatherDetailActity;
import wyz.android.com.model.Model;

/**
 * Created by wangyuzhe on 10/3/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.DataViewHolder> {

    private List<Model> list;
    private Context context;

    public MyAdapter(List<Model> list,Context context)
    {
        this.list= list;
        this.context = context;
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public TextView textView_1;
        public CardView cardview;

        public DataViewHolder(View v)
        {
            super(v);
            textView = (TextView)v.findViewById(R.id.tx);
            textView_1 = (TextView)v.findViewById(R.id.tx_1);
            cardview = (CardView)v.findViewById(R.id.card_view);
        }
    }

    @Override
    public void onBindViewHolder(DataViewHolder dataViewHolder, final int i) {
        dataViewHolder.textView.setText(list.get(i).getId());
        dataViewHolder.textView_1.setText(list.get(i).getName());
        dataViewHolder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,String.valueOf(i),Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.putExtra("name",list.get(i).getName());
                intent.setClass(context, WeatherDetailActity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_layout,viewGroup,false);
        ((CardView)v).setCardBackgroundColor(R.color.yellow);
        return new DataViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
