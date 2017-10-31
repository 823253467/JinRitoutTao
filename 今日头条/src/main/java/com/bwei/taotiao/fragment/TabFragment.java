package com.bwei.taotiao.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.taotiao.R;
import com.bwei.taotiao.adapter.xlistvie_newsAdapter;
import com.bwei.taotiao.base.BaseFragment;
import com.bwei.taotiao.bean.DataDataBean;
import com.bwei.taotiao.inter.NetInfoCallBack;
import com.bwei.taotiao.util.GetNetData;
import com.bwei.taotiao.util.WangLuo;
import com.bwei.taotiao.view.XListView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MK on 2017/9/14.
 */
public class TabFragment extends BaseFragment{

    private XListView xListView;
    private List<DataDataBean.ResultBean.DataBean> list = new ArrayList<>();

    @Override
    protected View ShiTu(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.tab_item, container, false);

        xListView = (XListView) view.findViewById(R.id.tab_xlistview);
        return view;
    }

    @Override
    protected void NenRong() {

        Bundle bundle = getArguments();
        String string = bundle.getString("name");

        GetNetData.FuoQuStringData(string, new NetInfoCallBack() {
            @Override
            public void getsuccessString(String string) {

                Log.i("------",string);
                Gson gson = new Gson();

                DataDataBean dataDataBean = gson.fromJson(string, DataDataBean.class);
//                List<DataDataBean.ResultBean.DataBean> list = dataDataBean.getResult().getData();
                list.addAll(dataDataBean.getResult().getData());
                xlistvie_newsAdapter adapter = new xlistvie_newsAdapter(getActivity(), list);
                xListView.setAdapter(adapter);

            }
        },getActivity());
    }
}
