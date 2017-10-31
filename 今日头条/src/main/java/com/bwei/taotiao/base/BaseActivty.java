package com.bwei.taotiao.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by MK on 2017/9/14.
 */
public abstract class BaseActivty extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);


        setContentView(getLayout());
        getfindID();
        getData();

    }

    protected abstract int getLayout();

    protected abstract void getfindID();

    protected abstract void getData();

}
