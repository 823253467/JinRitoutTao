package com.bwei.taotiao.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.taotiao.R;
import com.bwei.taotiao.bean.TouTiaoBean;
import com.bwei.taotiao.util.ImageLoaderUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by MK on 2017/9/17.
 */
public class MyAdapter extends BaseAdapter{
    Context context;
    List<TouTiaoBean.NewslistBean> listt;
    public MyAdapter(Context context, List<TouTiaoBean.NewslistBean> listt) {
        this.context=context;
        this.listt=listt;


    }

    @Override
    public int getCount() {
        return listt.size();
    }

    @Override
    public Object getItem(int i) {
        return listt.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null){

            view = View.inflate(context, R.layout.item,null);

            holder = new ViewHolder();
            holder.image01 = (ImageView) view.findViewById(R.id.image01);
            holder.text01 = (TextView) view.findViewById(R.id.text01);


            view.setTag(holder);


        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.text01.setText(listt.get(i).getTitle());

        ImageLoader.getInstance().displayImage(listt.get(i).getPicUrl(),holder.image01, ImageLoaderUtil.getoption());
        return view;
    }
    class ViewHolder{
        ImageView image01;
        TextView text01;
    }
}
