package com.example.jon.geoquiz;

/**
 * Created by Jon on 1/22/2015.
 */
public class TrueFalse {
    private int mQuestion;

    private boolean mTruequestion;

    public TrueFalse(int question, boolean trueQuestion){
        mQuestion = question;
        mTruequestion = trueQuestion;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public boolean isTrueQuestion() {
        return mTruequestion;
    }

    public void setQuestion(int question) {
        this.mQuestion = question;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        this.mTruequestion = mTruequestion;
    }
}
