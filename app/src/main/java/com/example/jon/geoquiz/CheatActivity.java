package com.example.jon.geoquiz;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends ActionBarActivity {

    private boolean mAnswerIsTrue;
    private boolean mAnswerShown;
    private TextView mAnswerTextView;
    private Button mShowAnswer;

    public static final String EXTRA_ANSWER_IS_TRUE = "com.example.jon.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.example.jon.geoquiz.answer_shown";
    private static final String TAG = "CheatActivity";
    private static final String KEY_CHEATER = "cheater";

    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);


        if (savedInstanceState != null) {
            mAnswerShown = savedInstanceState.getBoolean(KEY_CHEATER, false);
            setAnswerShownResult(mAnswerShown);
        }
        else {
            setAnswerShownResult(false);
            mAnswerShown = false;
        }

        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue)
                {
                    mAnswerTextView.setText(R.string.true_button);
                }
                else
                {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
                mAnswerShown = true;
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putBoolean(KEY_CHEATER, mAnswerShown);
    }
}
