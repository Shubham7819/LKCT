package com.ss.lkct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class AboutActivity extends AppCompatActivity {

    private AdView mAdAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mAdAbout = findViewById(R.id.adAbout);
        AdRequest adReqAbout = new AdRequest.Builder().build();
        mAdAbout.loadAd(adReqAbout);
    }
}
