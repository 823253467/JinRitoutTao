package com.bwei.taotiao.appliaction;

import android.app.Application;

import com.bwei.taotiao.util.ImageLoaderUtil;

/**
 * Created by MK on 2017/9/15.
 */
public class ImageLoader extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderUtil.getInit(this);
    }
}
