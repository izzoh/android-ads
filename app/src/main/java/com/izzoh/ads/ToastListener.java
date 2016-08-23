package com.izzoh.ads;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

/**
 * Created by user on 8/23/2016.
 */
public class ToastListener extends AdListener{
    private Context context;
    private String mErrorReason;

    public ToastListener(Context context){
        this.context = context;
    }

    @Override
    public void onAdLoaded() {
        Toast.makeText(context.getApplicationContext(), "Loaded ad", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdFailedToLoad(int i) {
        mErrorReason = "";
        switch (i){
            case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                mErrorReason = "Internal error";
                break;
            case AdRequest.ERROR_CODE_INVALID_REQUEST:
                mErrorReason = "Invalid request";
                break;
            case AdRequest.ERROR_CODE_NETWORK_ERROR:
                mErrorReason = "Network Error";
                break;
            case AdRequest.ERROR_CODE_NO_FILL:
                mErrorReason = "No fill";
        }
        Toast.makeText(context.getApplicationContext(), String.format("onAdFailedToLoad(%s)", mErrorReason), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onAdOpened() {
        Toast.makeText(context.getApplicationContext(), "Ad opened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdLeftApplication() {
        Toast.makeText(context.getApplicationContext(), "Ad left app to the browser", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdClosed() {
        Toast.makeText(context.getApplicationContext(), "Ad Closed", Toast.LENGTH_SHORT).show();
    }

    public String getErrorReason() {return mErrorReason == null ? "": mErrorReason;}
}
