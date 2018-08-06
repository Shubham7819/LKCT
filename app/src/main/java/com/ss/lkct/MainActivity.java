package com.ss.lkct;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {

    private AdView mAdMainTop;
    private InterstitialAd mInterFaculty;
    private InterstitialAd mInterFacility;
    private InterstitialAd mInterDev;
    private RewardedVideoAd contriAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-6844568931343897~2376406273");

        contriAd = MobileAds.getRewardedVideoAdInstance(this);
        contriAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();

        mAdMainTop = findViewById(R.id.adMainTop);
        AdRequest adReqMainTop = new AdRequest.Builder().build();
        mAdMainTop.loadAd(adReqMainTop);

        mInterFaculty = new InterstitialAd(this);
        mInterFaculty.setAdUnitId("ca-app-pub-6844568931343897/8684215202");
        AdRequest req = new AdRequest.Builder().build();
        mInterFaculty.loadAd(req);

        mInterFacility = new InterstitialAd(this);
        mInterFacility.setAdUnitId("ca-app-pub-6844568931343897/6113483068");
        AdRequest req1 = new AdRequest.Builder().build();
        mInterFacility.loadAd(req1);

        mInterDev = new InterstitialAd(this);
        mInterDev.setAdUnitId("ca-app-pub-6844568931343897/2504700100");
        AdRequest req2 = new AdRequest.Builder().build();
        mInterDev.loadAd(req2);


    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

/*        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
*/

        int id = item.getItemId();
        if (id == R.id.menu_contact) {
            Intent intent = new Intent(this, ContactActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.menu_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.menu_developers) {
            if (mInterDev.isLoaded()) {
                mInterDev.show();
            }
            Intent intent = new Intent(this, DevelopersActivity.class);
            startActivity(intent);
            return true;
        }
        return true;
    }

    private void loadRewardedVideoAd() {
        contriAd.loadAd("ca-app-pub-6844568931343897/2452313922",
                new AdRequest.Builder().build());
    }

    public void galleryMethod(View view) {
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);
    }

    public void facultyMethod(View view) {
        if (mInterFaculty.isLoaded()) {
            mInterFaculty.show();
        }
        Intent intent = new Intent(this, FacultyActivity.class);
        startActivity(intent);
    }

    public void coursesMethod(View view) {
        Intent intent = new Intent(this, CoursesActivity.class);
        startActivity(intent);
    }

    public void facilitiesMethod(View view) {
        if (mInterFacility.isLoaded()) {
            mInterFacility.show();
        }
        Intent intent = new Intent(this, FacilitiesActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Like Our Work ?")
                .setMessage("If you like our work make some contribution by watching a video..")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //finish();
                        if (contriAd.isLoaded()) {
                            contriAd.show();
                        }
                        finish();
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })/*("No", null)*/
                .show();
    }

}
