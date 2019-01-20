package com.jo.navviewpager;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CommentAdapter extends BaseAdapter {
    final ArrayList<CommentItems> items;

    CommentAdapter(ArrayList<CommentItems> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommentItemSetView view = new CommentItemSetView(parent.getContext());
        CommentItems item = items.get(position);

        view.setComment(item.getComment());
        view.setId(item.getId());
        view.setProFileImage(item.redId);
        view.setRatingBar(item.rating);

        return view;
    }
}
