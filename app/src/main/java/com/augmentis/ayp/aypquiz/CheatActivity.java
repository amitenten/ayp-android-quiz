package com.augmentis.ayp.aypquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    boolean answer;
    boolean isCheated;

    TextView answerText;
    Button confirmButton;

    private static final String CHEATED_EXTRA_KEY = ("CHEATED");

    public static boolean wasCheated(Intent intent){
        return intent.getExtras().getBoolean("CHEATED");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        isCheated = false;
        answer = getIntent().getExtras().getBoolean("ANSWER");

        confirmButton = (Button) findViewById(R.id.confirm_button);
        answerText = (TextView) findViewById(R.id.text_answer);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer){
                    answerText.setText(R.string.answer_is_true);
                } else {
                    answerText.setText(R.string.answer_is_false);
                }

                isCheated = true;

                returnResult();
            }
        });
    }

    private void returnResult() {
        Intent newIntent = new Intent();
        newIntent.putExtra(CHEATED_EXTRA_KEY, isCheated);
        setResult(RESULT_OK, newIntent);
    }
}
