package com.example.androidnetworking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView idContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idContent = findViewById(R.id.Content);



//        Spannable addContent2 = new SpannableString("MYFPL");
//        addContent2.setSpan(new ForegroundColorSpan(Color.rgb(255,122,0)),0,addContent2.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        idContent.setText(addContent2);

    }
}