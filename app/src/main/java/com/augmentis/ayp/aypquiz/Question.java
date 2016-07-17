package com.augmentis.ayp.aypquiz;

/**
 * Created by Amita on 7/14/2016.
 */
public class Question {
    private int questionId;
    private boolean answer;
    private boolean Cheated;

    public Question() {}

    public boolean getCheated() {
        return Cheated;
    }

    public void setCheated(boolean cheated) {
        Cheated = cheated;
        cheated = true;
        return;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }


    public Question(int questionId, boolean answer , boolean Cheated) {
        this.questionId = questionId;
        this.answer = answer;
        this.Cheated = Cheated;
    }

    public boolean getAnswer() {
        return answer;
    }
}
