package com.example.ttv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DisplayActivity extends AppCompatActivity {
    Button buttonReturn;
    VideoView videoView;
    DatabaseReference lab411SRV;
    Uri uri;
    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        MediaController mediaController = new MediaController(this);

        buttonReturn = findViewById(R.id.buttonReturn);
        videoView = findViewById(R.id.videoDisplay);
        lab411SRV = FirebaseDatabase.getInstance().getReference().child("Display/link");

        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        lab411SRV.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Retrieve the link from the data snapshot
                link = dataSnapshot.getValue(String.class);

                // Pass the link to the video player
                uri = Uri.parse(link);
                videoView.setVideoURI(uri);
                videoView.start();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors
                // ...
            }
        });

        // uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/lab411-srv-3dbd2.appspot.com/o/SampleVideo_1280x720_1mb.mp4?alt=media&token=8c770d1d-a7da-4020-9e96-9f607e1e129c");
        //uri = Uri.parse(link);
        //videoView.setVideoURI(uri);
        //videoView.start();

        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}