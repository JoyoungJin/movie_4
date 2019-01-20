package com.jo.navviewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MoviePageItemFragment extends Fragment{
    ViewGroup rootView;
    OnClickMovieListener listener;
    int position;

    public static Fragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt("position",position);
        Fragment fragment = new MoviePageItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnClickMovieListener) {
            listener = (OnClickMovieListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("position");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.moviepageritem_fragment, container, false);
        Log.d("position", String.valueOf(position));


        TextView pagerMovieName = rootView.findViewById(R.id.viewpager1_title);
        TextView pagerMovieInfo = rootView.findViewById(R.id.viewpager_info);
        ImageView imageView = rootView.findViewById(R.id.viewpager1_image);
        switch (position) {
            case 0 :
                pagerMovieName.setText(R.string.pagerMovieName1);
                pagerMovieInfo.setText(R.string.pagerMovieInfo1);
                imageView.setImageResource(R.drawable.image1);

                break;
            case 1:
                pagerMovieName.setText(R.string.pagerMovieName2);
                pagerMovieInfo.setText(R.string.pagerMovieInfo2);
                imageView.setImageResource(R.drawable.image2);

                break;
            case 2:
                pagerMovieName.setText(R.string.pagerMovieName3);
                pagerMovieInfo.setText(R.string.pagerMovieInfo3);
                imageView.setImageResource(R.drawable.image3);

                break;
            case 3:
                pagerMovieName.setText(R.string.pagerMovieName4);
                pagerMovieInfo.setText(R.string.pagerMovieInfo4);
                imageView.setImageResource(R.drawable.image4);

                break;
            case 4:
                pagerMovieName.setText(R.string.pagerMovieName5);
                pagerMovieInfo.setText(R.string.pagerMovieInfo5);
                imageView.setImageResource(R.drawable.image5);

                break;
        }



        Button button = rootView.findViewById(R.id.viewpager1_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onClickMovie(0);
                }
            }
        });

        return rootView;
    }
}

