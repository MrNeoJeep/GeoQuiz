package com.future.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckActivity extends AppCompatActivity {

    private TextView mTvAnswer;
    private Button mBtnShowAnswer;
    private Boolean mAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        Intent intent = getIntent();
        mAnswer = intent.getBooleanExtra(QuizActivity.EXTRA_ANSWER,false);

        mTvAnswer = findViewById(R.id.tv_answer);
        mBtnShowAnswer = findViewById(R.id.btn_show_answer);
        mBtnShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取当前问题的答案
                if(mAnswer){
                    mTvAnswer.setText("True");
                }else{
                    mTvAnswer.setText("False");
                }
                Intent data = new Intent();
                data.putExtra("USED_SHOW_ANSWER",true);
                setResult(RESULT_OK,data);


            }
        });

    }
}