package com.example.projecthomescreenpreview;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteReadOnlyDatabaseException;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

public class CalanderActivity extends AppCompatActivity {

    private mySQLiteDBHandler dbHandler;
    private EditText editText;
    private CalendarView calendarView;
    private String selectedDate;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calander);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText = findViewById(R.id.editTextTextPersonName);
        calendarView = findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                selectedDate = Integer.toString(year) + Integer.toString(month) + Integer.toString(dayOfMonth);
                ReadDatabase();
            }
        });

        try{

            dbHandler = new mySQLiteDBHandler(this, "CalendarDatabase", null, 1);
            sqLiteDatabase = dbHandler.getWritableDatabase();
            sqLiteDatabase.execSQL("CREATE TABLE EventCalendar(Date TEXT, Event TEXT)");
        }
        catch (Exception e){
            e.printStackTrace();
        }}

    public void InsertDatabase () {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Date", selectedDate);
        contentValues.put("Event", editText.getText().toString());
        sqLiteDatabase.insert("EventCalendar", null, contentValues);

    }

    public void ReadDatabase (){
        String query = "Select Event from EventCalendar where Date =" +selectedDate;
        try{
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);
            cursor.moveToFirst();
            editText.setText(cursor.getString(0));
        }catch (Exception e){
            e.printStackTrace();
            editText.setText("");
        }
    }

}
