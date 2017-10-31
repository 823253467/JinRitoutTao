package com.bwei.taotiao.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bwei.taotiao.MainActivity;
import com.bwei.taotiao.R;
import com.bwei.taotiao.adapter.DocAdapter;
import com.bwei.taotiao.adapter.MyAdapter;
import com.bwei.taotiao.base.BaseFragment;
import com.bwei.taotiao.bean.JavaBean;
import com.bwei.taotiao.bean.TouTiaoBean;
import com.bwei.taotiao.inter.NetInfoCallBack;
import com.bwei.taotiao.util.GetNetData;
import com.bwei.taotiao.view.XListView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MK on 2017/9/14.
 */
public class TouTiaoFragment extends BaseFragment implements XListView.IXListViewListener {

    private ViewPager viewPager;

    private List<JavaBean.DataBean.EssayBean.AuthorBean> list1 = new ArrayList<JavaBean.DataBean.EssayBean.AuthorBean>();

    private List<TouTiaoBean.NewslistBean> listt = new ArrayList<>();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
                int currentItem = viewPager.getCurrentItem();

                viewPager.setCurrentItem(currentItem+1);
                handler.sendEmptyMessageDelayed(0,1000);
            }
        }
    };
    private LinearLayout linearlayout;
    private List<ImageView> image;
    private ImageView imageView;
    private XListView xListView;

    private int  num=1;
    @Override
    protected View ShiTu(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.toutiao_item, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_bunlo);
        linearlayout = (LinearLayout) view.findViewById(R.id.linear01);
        xListView = (XListView) view.findViewById(R.id.xlistview_tt);
        return view;
    }

    @Override
    protected void NenRong() {

        GetNetData.NetDoc(new NetInfoCallBack() {

            @Override
            public void getsuccessString(String string) {
                Log.i("===========",string);
                Gson gson = new Gson();

                JavaBean javaBean = gson.fromJson(string, JavaBean.class);
                final List<JavaBean.DataBean.EssayBean> list = javaBean.getData().getEssay();

                for (int i=0;i<list.size();i++){

                    list1.addAll(list.get(i).getAuthor());
                }

                //Log.i("-----",list.get(1).getHp_title());


                initDoc();

                DocAdapter adapter = new DocAdapter(getActivity(), list1,handler);
                viewPager.setAdapter(adapter);

                viewPager.setCurrentItem(list.size()*1000);

                handler.sendEmptyMessageDelayed(0,2000);

                viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {

                        for (int i=0;i<image.size();i++){
                            if (i==position%list1.size()){
                                image.get(i).setImageResource(R.drawable.doc_yes);
                            }else {
                                image.get(i).setImageResource(R.drawable.doc_no);

                            }
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });




            }
        },getActivity());

        /*xListView.setPullRefreshEnable(true);
        xListView.setPullRefreshEnable(true);
        xListView.setXListViewListener(this);

        getDataFromNet();*/
        //xListView.setAdapter();

    }

    private void getDataFromNet() {
        GetNetData.getNetTouTiao(getActivity(), num, new NetInfoCallBack() {
            @Override
            public void getsuccessString(String string) {


                Gson gson = new Gson();
                TouTiaoBean touTiaoBean = gson.fromJson(string, TouTiaoBean.class);

                listt.addAll(0,touTiaoBean.getNewslist());

                setAdapter();

                xListView.stopRefresh();

            }
        });
    }

    private void setAdapter() {
        new MyAdapter(getActivity(),listt);
    }

    private void initDoc() {

        image = new ArrayList<>();

        linearlayout.removeAllViews();

        for (int i=0;i<list1.size();i++){
            imageView = new ImageView(getActivity());

            if (i==0){
                imageView.setImageResource(R.drawable.doc_yes);
            }else {
                imageView.setImageResource(R.drawable.doc_no);

            }


            image.add(imageView);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(5,0,5,0);
            linearlayout.addView(imageView,params);


        }

    }

    @Override
    public void onRefresh() {

        num++;
        getDataFromNet();
    }

    @Override
    public void onLoadMore() {

    }
}
