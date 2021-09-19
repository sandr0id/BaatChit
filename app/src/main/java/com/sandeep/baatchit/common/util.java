package com.sandeep.baatchit.common;

import android.content.Context;
import android.net.ConnectivityManager;

public class util {
    public static boolean connectionAvailable(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivityManager !=null && connectivityManager.getActiveNetworkInfo()!=null)
        {
            return connectivityManager.getActiveNetworkInfo().isAvailable();
        }else
        {
            return false;
        }
    }
}
