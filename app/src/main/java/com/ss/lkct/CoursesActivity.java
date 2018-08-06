package com.ss.lkct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class CoursesActivity extends AppCompatActivity {

    private AdView mAdCourBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        mAdCourBottom = findViewById(R.id.adCourBottom);
        AdRequest adReqCourBottom = new AdRequest.Builder().build();
        mAdCourBottom.loadAd(adReqCourBottom);
    }

    public void beMethod(View view) {
        Intent intent = new Intent(this, BEActivity.class);
        startActivity(intent);
    }

    public void mtechMethod(View view) {
        Intent intent = new Intent(this, MtechActivity.class);
        startActivity(intent);
    }

    public void mbaMethod(View view) {
        Intent intent = new Intent(this, MBAActivity.class);
        startActivity(intent);
    }

}
