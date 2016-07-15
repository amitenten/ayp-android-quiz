package com.augmentis.ayp.aypquiz;

/**
 * Created by Amita on 7/14/2016.
 */
public class Question {
    private int questionId;
    private boolean answer;
    private boolean cheated;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public boolean isCheated() {
        return cheated;
    }

    public void setCheated(boolean cheated) {
        this.cheated = cheated;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public Question(int questionId, boolean answer) {
        this.questionId = questionId;
        this.answer = answer;
        this.cheated = false;
    }

    public boolean getAnswer() {
        return answer;
    }
}
