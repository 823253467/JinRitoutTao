package com.bwei.taotiao.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.bwei.taotiao.R;
import com.bwei.taotiao.adapter.TabLayoutAdpter;
import com.bwei.taotiao.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MK on 2017/9/14.
 */
public class ShouyeFragment extends BaseFragment{

    private EditText editText;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected View ShiTu(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.shouye_item, container, false);

        editText = (EditText) view.findViewById(R.id.shouye_edit);
        tabLayout = (TabLayout) view.findViewById(R.id.shouye_tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.shouye_viewpager);

        return view;
    }

    @Override
    protected void NenRong() {

        List<String> list = new ArrayList<>();
        list.add("头条");
        list.add("社会");
        list.add("国内");
        list.add("国际");
        list.add("娱乐");
        list.add("体育");
        list.add("军事");
        list.add("科技");
        list.add("财经");
        list.add("时尚");


        TabLayoutAdpter adpter = new TabLayoutAdpter(getFragmentManager(),list);
        viewPager.setAdapter(adpter);

        tabLayout.setupWithViewPager(viewPager);
    }
}
