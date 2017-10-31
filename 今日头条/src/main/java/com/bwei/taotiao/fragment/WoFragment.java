package com.bwei.taotiao.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.taotiao.R;
import com.bwei.taotiao.base.BaseFragment;

/**
 * Created by MK on 2017/9/14.
 */
public class WoFragment extends BaseFragment{
    @Override
    protected View ShiTu(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.wo_item, container, false);
        return view;
    }

    @Override
    protected void NenRong() {

    }
}
