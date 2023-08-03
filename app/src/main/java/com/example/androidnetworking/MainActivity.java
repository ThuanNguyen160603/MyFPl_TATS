package com.example.androidnetworking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "PushNotification";
    private static final String CHANNEL_ID = "101";
    TextView idContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idContent = findViewById(R.id.Content);

        createNotificationChannel();
        getToken();


//        Spannable addContent2 = new SpannableString("MYFPL");
//        addContent2.setSpan(new ForegroundColorSpan(Color.rgb(255,122,0)),0,addContent2.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        idContent.setText(addContent2);

    }
    public void StartLogin (View view) {
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }

    public void getToken() {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                //if task failed then
                if (!task.isSuccessful()) {
                    Log.d(TAG, "onComplete: Failed to get the token" );
                }

                String token = task.getResult();
                Log.d(TAG, "onComplete: "+token);
            }
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "firebaseNotifChannel";
            String description = "Recive Firebase notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }


    }
}