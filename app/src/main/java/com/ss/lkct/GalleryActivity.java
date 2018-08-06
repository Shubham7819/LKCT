package com.ss.lkct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class GalleryActivity extends AppCompatActivity {

    private AdView mAdGalTop;
    private AdView mAdGalBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mAdGalTop = findViewById(R.id.adGalTop);
        AdRequest adReqGalTop = new AdRequest.Builder().build();
        mAdGalTop.loadAd(adReqGalTop);

        mAdGalBottom = findViewById(R.id.adGalBottom);
        AdRequest adReqGalBottom = new AdRequest.Builder().build();
        mAdGalBottom.loadAd(adReqGalBottom);
    }
}
