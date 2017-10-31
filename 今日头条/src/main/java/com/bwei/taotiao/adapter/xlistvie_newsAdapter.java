package com.bwei.taotiao.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.taotiao.R;
import com.bwei.taotiao.bean.DataDataBean;
import com.bwei.taotiao.util.ImageLoaderUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by MK on 2017/9/14.
 */
public class xlistvie_newsAdapter extends BaseAdapter{
    Context context;
    List<DataDataBean.ResultBean.DataBean> list;

    private int left=0;
    private int rigeht=1;


    public xlistvie_newsAdapter(Context context, List<DataDataBean.ResultBean.DataBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return left;
        }
        return rigeht;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i)==left){

            ViewHolder01 holder;
            if (view==null){

                view = View.inflate(context, R.layout.xlistview_item01,null);

                holder = new ViewHolder01();

                holder.text01 = (TextView) view.findViewById(R.id.text01);
                holder.image01 = (ImageView) view.findViewById(R.id.image01);

                view.setTag(holder);
            }else {
                holder = (ViewHolder01) view.getTag();
            }
            holder.text01.setText(list.get(i).getTitle());
            ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s(),holder.image01, ImageLoaderUtil.getoption());
        }else if (getItemViewType(i)==rigeht){

            ViewHolder02 holder;
            if (view==null){

                view = View.inflate(context, R.layout.xlistview_item02,null);

                holder = new ViewHolder02();

                holder.text01 = (TextView) view.findViewById(R.id.text01);
                holder.image01 = (ImageView) view.findViewById(R.id.image01);


                view.setTag(holder);
            }else {
                holder = (ViewHolder02) view.getTag();
            }
            holder.text01.setText(list.get(i).getTitle());
            ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s(),holder.image01, ImageLoaderUtil.getoption());
        }
        return view;
    }
    class ViewHolder01{
        TextView text01;
        ImageView image01;
    }
    class ViewHolder02{
        TextView text01;
        ImageView image01;
    }
}
