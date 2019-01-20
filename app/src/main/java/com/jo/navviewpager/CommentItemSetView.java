package com.jo.navviewpager;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class CommentItemSetView extends LinearLayout{

    TextView idTextView;
    RatingBar ratingBar;
    ImageView proFileImage;
    TextView commentText;


    public CommentItemSetView(Context context) {
        super(context);
        init(context);
    }

    public CommentItemSetView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.comment_item, this, true);

        idTextView = findViewById(R.id.textview_id);
        ratingBar = findViewById(R.id.ratingBar);
        proFileImage = findViewById(R.id.imageView_proFile);
        commentText = findViewById(R.id.textview_commenttext);
    }

    public void setId(String idtext) {
        idTextView.setText(idtext);
    }
    public void setRatingBar(float rating){
        ratingBar.setRating(rating);
    }
    public void setProFileImage(int redId) {
        proFileImage.setImageResource(redId);
    }
    public void setComment(String comment) {
        commentText.setText(comment);
    }
}

