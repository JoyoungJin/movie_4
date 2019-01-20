package com.jo.navviewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class CommentWriteActivity extends AppCompatActivity {
    public static final int REQUEST_COMMENT_WRITE = 102;
    EditText commentText;
    RatingBar ratingBar;
    Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commentwrite_activity);

        commentText = findViewById(R.id.edit_Text_comment);
        ratingBar = findViewById(R.id.write_ratingbar);
        saveButton = findViewById(R.id.saveButton);
        Button exitButton = findViewById(R.id.exitButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = commentText.getText().toString();
                Log.d("commenttext" , comment);
                float rating = ratingBar.getRating();
                int requestcode = REQUEST_COMMENT_WRITE;
                    Intent intent = getIntent();
                    intent.putExtra("comment", comment);
                    intent.putExtra("rating", rating);
                    setResult(RESULT_OK, intent);
                    finish();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
