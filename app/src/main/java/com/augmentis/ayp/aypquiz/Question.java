package com.augmentis.ayp.aypquiz;

/**
 * Created by Amita on 7/14/2016.
 */
public class Question {
    private int questionId;
    private boolean answer;
    private boolean cheated;

    public Question(int questionId, boolean answer) {
        this.questionId = questionId;
        this.answer = answer;
        this.cheated = false;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public boolean getAnswer() {
        return answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setCheated(boolean cheated) {
        this.cheated = cheated;
    }

    public boolean isCheated() {
        return cheated;
    }
}
