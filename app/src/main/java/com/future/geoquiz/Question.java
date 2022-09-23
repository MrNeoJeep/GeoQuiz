package com.future.geoquiz;

public class Question {
    private int mTestResID;
    private boolean mAnswerTrue;

    public Question(int mTestResID, boolean mAnswerTrue) {
        this.mTestResID = mTestResID;
        this.mAnswerTrue = mAnswerTrue;
    }

    public int getmTestResID() {
        return mTestResID;
    }

    public void setmTestResID(int mTestResID) {
        this.mTestResID = mTestResID;
    }

    public boolean ismAnswerTrue() {
        return mAnswerTrue;
    }

    public void setmAnswerTrue(boolean mAnswerTrue) {
        this.mAnswerTrue = mAnswerTrue;
    }
}
