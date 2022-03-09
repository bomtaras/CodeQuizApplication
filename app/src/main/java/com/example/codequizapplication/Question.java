package com.example.codequizapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
   // private SQLiteDatabase database;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answerNr;

    public Question(){}

    public Question(String question, String option1, String option2, String option3, String option4, int answerNr) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerNr = answerNr;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    @SuppressLint("Range")
    public static ArrayList<Question> getAllQuestions(Context context){
        ArrayList<Question> questionList = new ArrayList<>();
        SQLiteHelper helper = new SQLiteHelper(context);
        SQLiteDatabase database = helper.getReadableDatabase();
       // database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + QuizContract.QuestionsTable.TABLE_NAME, null);
        if (cursor.moveToFirst());{
            do {Question question = new Question();
                question.setQuestion(cursor.getString(cursor.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(cursor.getString(cursor.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(cursor.getString(cursor.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(cursor.getString(cursor.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(cursor.getString(cursor.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(cursor.getInt(cursor.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);

            }while (cursor.moveToNext());
            Collections.shuffle(questionList);
        }
        //String[]selectionArgs = new String[]{QuestionsTable.TABLE_NAME };
        // Cursor cursor = database.query("quiz_questions" ,"id=?",new String[]{"id","question","option1","option2","option3","option4","answer_nr"},null,null,null, "RANDOM() " ,"8");

        //Cursor cursor = database.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME ,new String[]{"ORDER BY " + "RANDOM()" + LIMIT 8+ });
        cursor.close();
        return questionList;
    }
    
}
