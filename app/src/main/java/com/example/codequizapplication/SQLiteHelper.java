package com.example.codequizapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TableRow;

import  com.example.codequizapplication.QuizContract.*;

import androidx.annotation.Nullable;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quiz_db";
    private static final int  DATABASE_VERSION = 1;

    private SQLiteDatabase database;

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        Log.d("SQL_CREATE", SQL_CREATE_QUESTIONS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_QUESTIONS_TABLE);


        final String SQL_CREATE_HIGH_SCORES_TABLE = "CREATE TABLE " +
                HighScoresTable.TABLE_NAME + " ( " +
                HighScoresTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                HighScoresTable.COLUMN_NAME + " TEXT, " +
                HighScoresTable.COLUMN_SCORE + " TEXT" +
                ")";

        sqLiteDatabase.execSQL(SQL_CREATE_HIGH_SCORES_TABLE);

        this.fillQuestionsTable(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       /* sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(sqLiteDatabase);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + HighScoresTable.TABLE_NAME);
        onCreate(sqLiteDatabase);*/
    }
    private void fillQuestionsTable(SQLiteDatabase sqLiteDatabase){
        Question question1 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question1);
        Question question2 = new Question("B is correct", "A", "B", "C", "D", 2);
        addQuestion(sqLiteDatabase, question2);
        Question question3 = new Question("C is correct", "A", "B", "C", "D", 3);
        addQuestion(sqLiteDatabase, question3);
        Question question4 = new Question("D is correct", "A", "B", "C", "D", 4);
        addQuestion(sqLiteDatabase, question4);
        Question question5 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question5);
        Question question6 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question6);
        Question question7 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question7);
        Question question8 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question8);
        Question question9 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question9);
        Question question10 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question10);
        Question question11 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question11);
        Question question12 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question12);
        Question question13 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question13);
        Question question14 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question14);
        Question question15 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question15);
        Question question16 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question16);
        Question question17 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question17);
        Question question18 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question18);
        Question question19 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question19);
        Question question20 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(sqLiteDatabase, question20);

    }
    private void addQuestion(SQLiteDatabase sqLiteDatabase, Question question){
        ContentValues contentValues = new ContentValues();
        contentValues.put(QuestionsTable.COLUMN_QUESTION,question.getQuestion());
        contentValues.put(QuestionsTable.COLUMN_OPTION1,question.getOption1());
        contentValues.put(QuestionsTable.COLUMN_OPTION2,question.getOption2());
        contentValues.put(QuestionsTable.COLUMN_OPTION3,question.getOption3());
        contentValues.put(QuestionsTable.COLUMN_OPTION4,question.getOption4());
        contentValues.put(QuestionsTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        sqLiteDatabase.insert(QuestionsTable.TABLE_NAME, null, contentValues);
    }


}
