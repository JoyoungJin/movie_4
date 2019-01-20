package com.jo.navviewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AllCommentActivity extends AppCompatActivity {
    public static final int REQUEST_SHOWALL_WRITE = 103;

    Intent intent;
    ArrayList<CommentItems> items;
    CommentAdapter adapter;


    TextView allViewWriteButton;
    int requestCode;

    String comment;
    float rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allcomment_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intent = getIntent();
        items = (ArrayList<CommentItems>) intent.getSerializableExtra("items");
        ListView allViewListView = findViewById(R.id.allview_listview);
        adapter = new CommentAdapter(items);
        allViewListView.setAdapter(adapter);



        allViewWriteButton = findViewById(R.id.allviewwrite_button);
        allViewWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CommentWriteActivity.class);
                requestCode = REQUEST_SHOWALL_WRITE;
                startActivityForResult(intent, REQUEST_SHOWALL_WRITE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SHOWALL_WRITE) {
            if (resultCode == RESULT_OK) {
                String comment = data.getStringExtra("comment");
                float rating = data.getFloatExtra("rating", 0.0f);
                int requestcode = 101;
                if (comment != null) {
                    Intent intent = getIntent();
                    intent.putExtra("comment", comment);
                    intent.putExtra("rating", rating);
                    setResult(RESULT_OK, intent);

                    items.add(new CommentItems("kim78**", rating, comment, R.drawable.user1));
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }
    //actionbar backbutton 처리
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
