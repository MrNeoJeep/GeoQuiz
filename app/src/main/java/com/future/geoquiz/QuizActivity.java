package com.future.geoquiz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    public static final String EXTRA_ANSWER = "cheat_answer";
    public static final int REQ_CHEAT = 0;
    private Button mBtnTrue;
    private Button mBtnFalse;
    private Button mBtnCheat;
    private TextView mTvQuestion;
    private Question[] mQustionBank = new Question[]{
            new Question(R.string.question1,true),
            new Question(R.string.question2,false),
            new Question(R.string.question3,false),
            new Question(R.string.question4,false)

    };
    private int curIdx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("my activity","onCreate");
        setContentView(R.layout.activity_quiz);
        if(savedInstanceState != null){
            curIdx = savedInstanceState.getInt("IDX");
        }else{
            curIdx = 0;
        }
        mBtnTrue = findViewById(R.id.btn_true);
        mBtnFalse = findViewById(R.id.btn_false);
        mBtnCheat = findViewById(R.id.btn_cheat);
        mTvQuestion = findViewById(R.id.tv_question);


        mBtnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                updateQuestion();
            }
        });

        mBtnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                updateQuestion();

            }
        });

        mBtnCheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizActivity.this,CheckActivity.class);
                //跳转页面的时候，传递参数
                intent.putExtra(EXTRA_ANSWER,mQustionBank[curIdx].ismAnswerTrue());

                //单向传递数据
                //startActivity(intent);
                startActivityForResult(intent,REQ_CHEAT);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode != Activity.RESULT_OK){
            return;
        }
        if(requestCode == REQ_CHEAT){
            if(data != null){
                Toast.makeText(QuizActivity.this,
                        "使用了提示答案",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void updateQuestion(){
        curIdx = (curIdx + 1) % mQustionBank.length;
        mTvQuestion.setText(mQustionBank[curIdx].getmTestResID());
    }

    private void checkAnswer(boolean userPress){
        boolean curAns = mQustionBank[curIdx].ismAnswerTrue();
        if(userPress == curAns){
            Toast.makeText(QuizActivity.this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(QuizActivity.this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        Log.d("my activity","onStart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("my activity","onStart");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("my activity","onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("my activity","onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("my activity","onDestroy");

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }
}