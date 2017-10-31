package com.bwei.taotiao.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwei.taotiao.fragment.TabFragment;

import java.util.List;

/**
 * Created by MK on 2017/9/14.
 */
public class TabLayoutAdpter extends FragmentPagerAdapter{

    List<String> list;
    public TabLayoutAdpter(FragmentManager fm, List<String> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        TabFragment fragment = new TabFragment();

        Bundle bundle = new Bundle();
        if (list.get(position).equals("头条")){
            bundle.putString("name","top");
        }else if (list.get(position).equals("社会")){
            bundle.putString("name","shehui");
        }else if (list.get(position).equals("国内")){
            bundle.putString("name","guonei");
        }else if (list.get(position).equals("国际")){
            bundle.putString("name","guoji");
        }else if (list.get(position).equals("娱乐")){
            bundle.putString("name","yule");
        }else if (list.get(position).equals("体育")){
            bundle.putString("name","tiyu");
        }else if (list.get(position).equals("军事")){
            bundle.putString("name","junshi");
        }else if (list.get(position).equals("科技")){
            bundle.putString("name","keji");
        }else if (list.get(position).equals("财经")){
            bundle.putString("name","caijing");
        }else if (list.get(position).equals("时尚")){
            bundle.putString("name","shishang");
        }
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
