package com.sky.photogallery.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.sky.photogallery.entity.GalleryItem;
import com.sky.photogallery.network.FlickrFetchr;
import com.sky.photogallery.utils.NetworkUtil;
import com.sky.photogallery.utils.QueryPreferences;

import java.util.List;

/**
 * Created by tonycheng on 2016/12/20.
 */

public class PollService extends IntentService {
    private static final String TAG = "PollService";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * Used to name the worker thread, important only for debugging.
     */
    public PollService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (!NetworkUtil.isNetworkAvailableAndConnected(this)) {
            return;
        }
        Log.d(TAG, "Received an intent：" + intent);

        String query = QueryPreferences.getStoredQuery(this);
        String lastResultId = QueryPreferences.getLastResultId(this);
        List<GalleryItem> items;

        if (query == null) {
            items = new FlickrFetchr().fetchRecentPhotos();
        } else {
            items = new FlickrFetchr().searchPhotos(query);
        }

        if (items.size() == 0) {
            return;
        }

        String resultId = items.get(0).getId();
        if (resultId.equals(lastResultId)) {
            Log.i(TAG, "Got an old result: " + resultId);
        } else {
            Log.i(TAG, "Got a new result: " + resultId);
        }
        QueryPreferences.setLastResultId(this, resultId);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, PollService.class);
    }
}
