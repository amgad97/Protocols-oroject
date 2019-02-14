package com.example.mythermonitor;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<DataItem> {
    Context context;
    int layoutId;
    List<DataItem> data = null;

    public CustomAdapter(Context context, int resource, List<DataItem> objects) {
        super(context, resource, objects);
        this.layoutId = resource;
        this.context = context;
        this.data = objects;

    }

    static class DataHolder {
        ImageView ivpic;
        TextView tvlanguage;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView=inflater.inflate(layoutId,null);
            holder=new DataHolder();
            holder.ivpic=(ImageView)convertView.findViewById(R.id.ivLanguage);
            holder.tvlanguage=(TextView)convertView.findViewById(R.id.tvLanguage);
            convertView.setTag(holder);

        }
        else{
            holder=(DataHolder)convertView.getTag();
        }
        DataItem dataItem=data.get(position);
        holder.tvlanguage.setText(dataItem.language);
        holder.ivpic.setImageResource(dataItem.res);
        return convertView;
    }
}
