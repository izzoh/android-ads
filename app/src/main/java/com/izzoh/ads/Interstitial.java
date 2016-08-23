package com.izzoh.ads;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import static com.izzoh.ads.R.string.interstitial_ad_unit_id;

/**
 * Created by user on 8/22/2016.
 */
public class Interstitial extends AppCompatActivity {
    private Button mShowButton, mLoadButton;
    private InterstitialAd mInterstitial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);
        mShowButton = (Button) findViewById(R.id.showButton);
        mShowButton.setEnabled(false);

        mLoadButton = (Button) findViewById(R.id.loadButton);

        mLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadInterstitial(view);
            }
        });

        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitial(view);
            }
        });

    }

    public void loadInterstitial(View unusedView){
        mShowButton.setEnabled(false);
        mShowButton.setText(getResources().getString(R.string.load_interstitial));
        mInterstitial = new InterstitialAd(this);

        mInterstitial.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
        mInterstitial.setAdListener(new ToastListener(this){

            @Override
            public void onAdLoaded() {
                mShowButton.setText("Show Interstitial");
                mShowButton.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                mShowButton.setText(getErrorReason());
            }
        });
        AdRequest ar = new AdRequest.Builder().build();
        mInterstitial.loadAd(ar);

    }

    public void showInterstitial(View unusedView){
        if (mInterstitial.isLoaded()){
            mInterstitial.show();
        }

        mShowButton.setText("Interstitial Not ready");
        mShowButton.setEnabled(false);
    }

}
