package com.example.codequizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView textView_question;
    private TextView textView_score;
    private TextView textView_question_count;
    private TextView textView_countdown;
    private RadioGroup radio_group;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Button button_confirm_next;

    private ArrayList<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textView_question = findViewById(R.id.textView_question);
        textView_score = findViewById(R.id.textView_score);
        textView_question_count = findViewById(R.id.textView_question_count);
        textView_countdown = findViewById(R.id.textView_countdown);
        radio_group = findViewById(R.id.radio_group);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        button_confirm_next = findViewById(R.id.button_confirm_next);

        ArrayList<Question> questionList = new ArrayList<>();
         Question.getAllQuestions(QuizActivity.this);

    }
}