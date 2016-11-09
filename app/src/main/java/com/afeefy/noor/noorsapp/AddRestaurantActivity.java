package com.afeefy.noor.noorsapp;

import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.afeefy.noor.noorsapp.Data.MyTask;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class AddRestaurantActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etLocation;
    private EditText etPicture;
    private RatingBar rtBarPriority;
    private Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);
        etLocation=(EditText)findViewById(R.id.etLocation);
        etName=(EditText)findViewById(R.id.etName);
        etPicture=(EditText)findViewById(R.id.etPicture);
        rtBarPriority=(RatingBar)findViewById(R.id.rtBarPriority);
        btnAdd=(Button)findViewById(R.id.btnAdd);



    }

    public void dataHandler(){
        String stName=etName.getText().toString();
        String stLocation=etLocation.getText().toString();
        String stPicture=etPicture.getText().toString();
        int prio=rtBarPriority.getProgress();
        Date date= Calendar.getInstance().getTime();
        boolean isOk = true;
        //2.checking
        if (stName.length() < 1) {
            etName.setError("");
            isOk = false;
        }
        if (stPicture.length() == 0) {
            etPicture.setError("there is no picture available ");
            isOk = false;
        }
        if (stLocation.length()==0) {
            etLocation.setError("There Is No Location");
            isOk = false;
        }
        if (isOk) {
            MyTask myTask = new MyTask();
            myTask.setId(stName);
            myTask.setPriority(prio);
            myTask.setWhen(date);
            myTask.setAddress(stLocation);
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            String email= FirebaseAuth.getInstance().getCurrentUser().getEmail();
            email=email.replace(".","_");
            reference.child(email).child("Adding restaurant").push().setValue(myTask, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference)
                {
                    // reference.child(email).child("MyTasks").push().setValue(myTask,new DatabaseReference);                    //3
                    if (databaseError == null)// add successful

                    {
                        Toast.makeText(AddRestaurantActivity.this, "Save", Toast.LENGTH_LONG).show();
                    } else// adding failed
                    {
                        Toast.makeText(AddRestaurantActivity.this, "Saving failed" + databaseError.getMessage(), Toast.LENGTH_LONG).show();


                    }


                }


            });


        }




    }
}
