package com.example.mdsuhelrana.transitionactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<DataResponse>responselist;

    public DataAdapter(Context context, ArrayList<DataResponse> responselist) {
        this.context = context;
        this.responselist = responselist;
    }
    @Override
    public int getCount() {
        return responselist.size();
    }

    @Override
    public Object getItem(int i) {
        return responselist.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    private class CustomViewHolder{
         TextView tvTitle;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CustomViewHolder customViewHolder;
        if(view==null) {
            customViewHolder=new CustomViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.single_row, viewGroup, false);
            customViewHolder.tvTitle=view.findViewById(R.id.tv_title_Id);
            view.setTag(customViewHolder);
        }else {
            customViewHolder= (CustomViewHolder) view.getTag();
        }
        customViewHolder.tvTitle.setText(responselist.get(i).getTitle());
        return view;
    }
}

