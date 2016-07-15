package com.augmentis.ayp.aypquiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final int REQUEST_CHEAT = 137;
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private Button previousButton;
    private Button cheatButton;

    TextView questionText;

    Question[] questions = new Question[]{
            new Question(R.string.question_1_nile, true),
            new Question(R.string.question_2_rawin, true),
            new Question(R.string.question_3_math, false),
            new Question(R.string.question_4_mars, false)
    };

    int currentIndex;

    private static final String TAG = "AYPQUIZ";
    private static final String INDEX = "INDEX";
    private boolean isCheater;

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "On pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "On resume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "On start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "On stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "On destroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "State is saving");
        outState.putInt(INDEX,currentIndex);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "On create");
        setContentView(R.layout.activity_quiz);
        resetCheater();
        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        nextButton = (Button) findViewById(R.id.next_button);
        previousButton = (Button) findViewById(R.id.previous_button);
        cheatButton = (Button) findViewById(R.id.cheat_button);
        questionText = (TextView) findViewById(R.id.text_question);

        if (savedInstanceState != null){
            currentIndex = savedInstanceState.getInt(INDEX, 0);
        }else {
        currentIndex = 0;
        }

        updateQuestion();

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCheater();
//                if (currentIndex >= questions.length){
//                    currentIndex=0;
//                }
//                currentIndex = (currentIndex + 1) % questions.length;
                currentIndex++;
                if (currentIndex == questions.length) currentIndex = 0;

                updateQuestion();
            }
        });
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCheater();
                if (currentIndex == 0) currentIndex = 4;
                currentIndex--;

                updateQuestion();
            }
        });

        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                Intent intent = new Intent(QuizActivity.this, CheatActivity.class);
                intent.putExtra("ANSWER",questions[currentIndex].getAnswer());

                startActivityForResult(intent, REQUEST_CHEAT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dataIntent) {
      if (resultCode != Activity.RESULT_OK){
            return;
        }
        if (requestCode == REQUEST_CHEAT){
            if (dataIntent == null){
                return;
            }
            isCheater = CheatActivity.wasCheated(dataIntent);
        }
    }

    private void resetCheater(){
        isCheater = false;
    }

    public void updateQuestion(){
        questionText.setText(questions[currentIndex].getQuestionId());
    }

    public void checkAnswer(boolean answer) {

        boolean correctAnswer = questions[currentIndex].getAnswer();
        int result;
        if (isCheater){
            result = R.string.cheater_text;
        }else {
            if (answer == correctAnswer) {
                //click True
                result = R.string.correct_text;
            } else {
                //click False
                result = R.string.incorrect_text;
            }
        }Toast.makeText(QuizActivity.this, result, Toast.LENGTH_SHORT).show();
    }
}
