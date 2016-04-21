package com.example.roji.tutoring_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BusinessActivity extends AppCompatActivity {

    Button submit;
    EditText business;
    EditText name;
    EditText email;
    EditText phone;
    EditText comment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        submit = (Button) findViewById(R.id.sendEmail);
        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                business = (EditText) findViewById(R.id.business);
                String Business = business.getText().toString();
                name = (EditText) findViewById(R.id.name);
                String Name = name.getText().toString();
                email = (EditText) findViewById(R.id.email);
                String Email = email.getText().toString();
                phone = (EditText) findViewById(R.id.phone);
                String Phone = phone.getText().toString();
                comment = (EditText) findViewById(R.id.comment);
                String Comment = comment.getText().toString();
                sendEmail(Business,Name,Email,Phone,Comment);
            }
        });
    }


    protected void sendEmail(String Business,String Name,String Email,String Phone,String Comment) {

        String[] To = new String[] {"shervin.oloumi@mavs.uta.edu"};
        String Subject = ("Advertisement Request - Tutoring App");
        String Body = "Business: " + Business +"\n"+
                "Name: " + Name +"\n"+
                "Email: " + Email +"\n"+
                "Phone: " + Phone +"\n\n"+
                "Comments: " + Comment +"\n";

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));

        emailIntent.putExtra(Intent.EXTRA_EMAIL, To);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, Subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, Body);
        //emailIntent.putExtra(Intent.EXTRA_EMAIL, to);

        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }


}