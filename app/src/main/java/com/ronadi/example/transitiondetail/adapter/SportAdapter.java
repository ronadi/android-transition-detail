package com.ronadi.example.transitiondetail.adapter;
/*
 * Created by ronadi on 5/23/17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ronadi.example.transitiondetail.R;
import com.ronadi.example.transitiondetail.model.Sport;

import java.util.List;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.ViewHolder> {
    private List<Sport> mDataset;

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTxtTitle;
        private SimpleDraweeView headerImage;
        private ViewHolder(View v) {
            super(v);
            mTxtTitle =(TextView) v.findViewById(R.id.txtTitle);
            headerImage = (SimpleDraweeView) v.findViewById(R.id.thumbnail);
        }
    }

    public SportAdapter(List<Sport> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public SportAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.card_sport, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTxtTitle.setText(mDataset.get(position).getTitle());
        holder.headerImage.setImageURI(mDataset.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public Sport getItemData(int index){
        return mDataset.get(index);
    }
}




