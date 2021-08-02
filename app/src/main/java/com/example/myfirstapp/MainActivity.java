package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
//package com.google.firebase.database;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.util.Log;

//import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        String str = getResources().getString(R.string.edit_message);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Writing to a file
//        try{
//            FileOutputStream fos = openFileOutput("myfile.txt", MODE_PRIVATE);
//            // Mode_private represents mode, file can only be accessed by calling applciation
//            String text = "hi";
//            fos.write(text.getBytes());
//            fos.close();
//        }
//        catch(Exception ex){
//        }

        //Reading from a file
//        try{
//            FileInputStream fis = openFileInput("myfile.txt");
//            BufferedReader b = new BufferedReader((new InputStreamReader(fis)));
////            String s = b.readLine();
////            while(s != null){
////                //processing
////                s = b.readLine();
////            }
//            Log.i("info", b.readLine());
//            fis.close();
//        }
//        catch(Exception ex){
//        }

        //Shared preferences
//        SharedPreferences p = getSharedPreferences("myprefs", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = p.edit();
//        editor.putInt("mykey", 123);
//        editor.apply();

//        int value = p.getInt("mykey", 0);
//        Log.i("info", "" + value);

//        SharedPreferences p = getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = p.edit();
//        editor.putInt("mykey", 123);
//        editor.apply();

        //Writing to a realtime database
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
//        Student student = new Student(100, "alice");
//        ref.child("students").child("s1").setValue(student);
//         s1 is key, student is value

////        Reading from a the realtime database
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("students");
        // if anything in "students" changes, we get notifiied
        ValueEventListener listener = new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                // if anything changes under students, we display all info of all children under students
                for(DataSnapshot child:dataSnapshot.getChildren()){
                    Student student = child.getValue(Student.class);
                    Log.i("info", student.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError){
                Log.w("warning", "loadPost:onCancelled", databaseError.toException());
            }
        };
        ref.addValueEventListener(listener);
        // we add the valueeventlistener to the database
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName2);
//        String message = editText.getText().toString();

//        Switch sw = (Switch) findViewById(R.id.switch1);
//        boolean b = sw.isChecked(); // returns true if switch on, false if off

//        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
//        RadioButton rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());

//        Spinner spinner = (Spinner) findViewById(R.id.spinner);
//        String val = String.valueOf(spinner.getSelectedItem());

//        intent.putExtra(EXTRA_MESSAGE, "" + rb.getText());    //emtpy string + b is a string (this way b is string? )
//        intent.putExtra(EXTRA_MESSAGE, "" + val);
//        intent.putExtra("username", "rawd");

        Student s = new Student(1000, "Alex");
        intent.putExtra(EXTRA_MESSAGE, s);
        startActivity(intent);
    }
}