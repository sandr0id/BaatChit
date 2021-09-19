package com.sandeep.baatchit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sandeep.baatchit.common.util;

public class MessageActivity extends AppCompatActivity {
    private TextView tvMessage;
    private ProgressBar pbMessage;
    private ConnectivityManager.NetworkCallback networkCallback; //using this we r tracking whether the internet connection is changing or not

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        tvMessage = findViewById(R.id.tvMessage);
        pbMessage = findViewById(R.id.pbMessage);

        //checking version of android in which app is running
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP)
        {
            networkCallback = new ConnectivityManager.NetworkCallback(){
                @Override
                public void onAvailable(@NonNull Network network) {
                    super.onAvailable(network);
                    finish();
                }

                @Override
                public void onLost(@NonNull Network network) {
                    super.onLost(network);
                    tvMessage.setText(R.string.no_internet);
                }
            };

            //registring it to callback manager

            ConnectivityManager connectivityManager = (ConnectivityManager)  getSystemService(CONNECTIVITY_SERVICE);
            connectivityManager.registerNetworkCallback(new NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build(),networkCallback);
        }


    }

    public void btnRetryClick(View v)
    {
        pbMessage.setVisibility(View.VISIBLE);

        if(util.connectionAvailable(this))
        {
            finish();
        }
        else
        {
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    pbMessage.setVisibility(View.GONE);
                }
            },3000);
        }


    }

    public void btnCloseClick(View v)
    {
        finishAffinity();//it will closd all the activity in the affinity
    }
}