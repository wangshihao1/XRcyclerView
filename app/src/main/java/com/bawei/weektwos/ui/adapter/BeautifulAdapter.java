package com.bawei.weektwos.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.weektwos.R;
import com.bawei.weektwos.data.bean.BeautifulBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;

public class BeautifulAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private List<BeautifulBean.ResultsBean> mlists;



    public void setMlists(Context context,List<BeautifulBean.ResultsBean> mlists) {
        this.context = context;
        this.mlists = mlists;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_resultsbeanlist, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
       MyHolder holder = (MyHolder) viewHolder;
       holder.tv_info.setText(mlists.get(i).getCreatedAt());
       holder.simple.setImageURI(Uri.parse(mlists.get(i).getUrl()));
    }

    @Override
    public int getItemCount() {
        return mlists.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView simple;
        private TextView tv_info;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.simple);
            tv_info = itemView.findViewById(R.id.tv_info);

        }
    }
}
