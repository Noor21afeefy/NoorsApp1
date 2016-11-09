package com.afeefy.noor.noorsapp.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.afeefy.noor.noorsapp.R;

/**
 * Created by user on 11/3/2016.
 */
public class MyAdabterTask extends ArrayAdapter<MyTask> {

    public MyAdabterTask(Context context, int resource) {

        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.adabter,parent,false);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.TvTitle);
        EditText etPhone = (EditText) convertView.findViewById(R.id.etPhone);
        ImageButton btnCall=(ImageButton)convertView.findViewById(R.id.btnCall);
        ImageButton btnLocation = (ImageButton) convertView.findViewById(R.id.btnLocation);
//        Button btnSave = (Button) convertView.findViewById(R.id.btnSave);
//        Button btnContacts = (Button) convertView.findViewById(R.id.btnContacts);
//       RatingBar rtBarPriorityr=(RatingBar) convertView.findViewById(R.id.rtBarPriority);
        final MyTask myTask=getItem(position);
        tvTitle.setText(myTask.getTitle());
        etPhone.setText(myTask.getPhone());
//        rtBarPriorityr.setRating(myTask.getPriority());
//        etLocation.setText(myTask.getAddress());
//        btnContacts.setText(myTask.getId());
        btnCall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }


        });

        btnLocation.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });
        return convertView;






    }
{
}}
