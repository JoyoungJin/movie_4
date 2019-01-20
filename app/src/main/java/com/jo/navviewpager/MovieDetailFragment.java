package com.jo.navviewpager;

import android.content.Context;
import android.content.Intent;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class MovieDetailFragment extends Fragment {
    public static final int REQUEST_SHOWALL = 101;
    public static final int REQUEST_COMMENT_WRITE = 102;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    ImageView likeButton;
    TextView likeCountView;
    ImageView hateButton;
    TextView hateCountView;
    Button allViewButton;

    int likeCount = 1;
    int hateCount = 1;

    boolean likeState = false;
    boolean hateState = false;
    ArrayList<CommentItems> items;

    Bundle bundle;
    CommentAdapter adapter;

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.movie_detail_fragment, container, false);


        items = new ArrayList<CommentItems>();

        ListView listView = rootView.findViewById(R.id.listView);
        items.add(new CommentItems("kim78**", 5, "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1));
        items.add(new CommentItems("kim78**", 5, "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1));
        items.add(new CommentItems("kim78**", 5, "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1));
        items.add(new CommentItems("kim78**", 5, "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1));
        items.add(new CommentItems("kim78**", 5, "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1));
        items.add(new CommentItems("kim78**", 5, "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1));
        items.add(new CommentItems("kim78**", 5, "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1));
        adapter = new CommentAdapter(items);
        listView.setAdapter(adapter);


        likeButton = rootView.findViewById(R.id.likeButton);
        likeCountView = rootView.findViewById(R.id.likeCountView);
        hateButton = rootView.findViewById(R.id.hateButton);
        hateCountView = rootView.findViewById(R.id.hateCountView);
        TextView writeButton = rootView.findViewById(R.id.button_write);
        allViewButton = rootView.findViewById(R.id.button_allView);


        //모두보기 버튼
        allViewButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AllCommentActivity.class);
                intent.putExtra("items", items);
                startActivityForResult(intent, REQUEST_SHOWALL);
            }
        });

        //작성하기 버튼
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CommentWriteActivity.class);
                startActivityForResult(intent, REQUEST_COMMENT_WRITE);
            }
        });


        //좋아요 버튼
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hateState == true) {
                    Toast.makeText(getContext(), "1개의 버튼만 선택 가능합니다.", Toast.LENGTH_SHORT).show();
                } else {
                    if (likeState) {
                        decrLikeCount();
                    } else {
                        incrLikeCount();
                    }

                    likeState = !likeState;
                }
            }
        });
        //싫어요 버튼
        hateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (likeState == true) {
                    Toast.makeText(getContext(), "1개의 버튼만 선택 가능합니다.", Toast.LENGTH_SHORT).show();
                } else {
                    if (hateState) {
                        decrHateCount();
                    } else {
                        incrHateCount();
                    }

                    hateState = !hateState;
                }
            }

        });


        return rootView;
    }

    public void incrHateCount() {
        hateCount = Integer.parseInt(hateCountView.getText().toString());
        hateCount = hateCount + 1;
        hateCountView.setText(String.valueOf(hateCount));
        hateButton.setImageResource(R.drawable.ic_thumb_down_selected);
    }

    public void decrHateCount() {
        hateCount -= 1;
        hateCountView.setText(String.valueOf(hateCount));
        hateButton.setImageResource(R.drawable.thumbs_down_selector);
    }

    public void incrLikeCount() {
        likeCount = Integer.parseInt(likeCountView.getText().toString());
        likeCount += 1;
        likeCountView.setText(String.valueOf(likeCount));
        likeButton.setImageResource(R.drawable.ic_thumb_up_selected);
    }

    public void decrLikeCount() {
        likeCount -= 1;
        likeCountView.setText(String.valueOf(likeCount));
        likeButton.setImageResource(R.drawable.thumbs_up_selector);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int requestcode = data.getExtras().getInt("requestcode");
            Log.d("requestcode", String.valueOf(requestcode));

            String comment = data.getStringExtra("comment");
            float rating = Math.round(data.getFloatExtra("rating", 0.0f));

            items.add(new CommentItems("kim78**", rating, comment, R.drawable.user1));
            adapter.notifyDataSetChanged();

        }
    }
}

