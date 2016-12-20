package com.sky.photogallery.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by tonycheng on 2016/12/20.
 */

public class NetworkUtil {

    public static boolean isNetworkAvailableAndConnected(Context context) {
        ConnectivityManager manager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        boolean isNetworkAvailable = manager.getActiveNetworkInfo() != null;
        boolean isNetworkConnected = isNetworkAvailable &&
                manager.getActiveNetworkInfo().isConnected();

        return isNetworkConnected;
    }
}
