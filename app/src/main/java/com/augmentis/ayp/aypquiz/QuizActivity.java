package com.augmentis.ayp.aypquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    Button trueButton;
    Button falseButton;
    Button nextButton;
    Button previousButton;

    TextView questionText;

    Question[] questions = new Question[]{
            new Question(R.string.question_1_nile, true),
            new Question(R.string.question_2_rawin, true),
            new Question(R.string.question_3_math, false),
            new Question(R.string.question_4_mars, false)
    };

    int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        nextButton = (Button) findViewById(R.id.next_button);
        previousButton = (Button) findViewById(R.id.previous_button);
        questionText = (TextView) findViewById(R.id.text_question);

        currentIndex = 0;
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
                if (currentIndex == 0) currentIndex = 4;
                currentIndex--;
                updateQuestion();
            }
        });
    }

    public void updateQuestion(){

        questionText.setText(questions[currentIndex].getQuestionId());
    }

    public void checkAnswer(boolean answer) {

        boolean correctAnswer = questions[currentIndex].getAnswer();
        int result = (answer == correctAnswer) ? R.string.correct_text : R.string.incorrect_text;
        Toast.makeText(QuizActivity.this, result, Toast.LENGTH_SHORT).show();

        /*if (answer == correctAnswer) {
            //click True
            result = R.string.correct_text;
            Toast.makeText(QuizActivity.this, result, Toast.LENGTH_SHORT).show();
        } else {
            //click False
            result = R.string.incorrect_text;
            Toast.makeText(QuizActivity.this, result, Toast.LENGTH_SHORT).show();
        }*/
    }
}
