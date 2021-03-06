package com.bwei.taotiao.util;

import android.content.Context;
import android.os.AsyncTask;

import com.bwei.taotiao.inter.NetInfoCallBack;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by MK on 2017/9/15.
 */
public class GetNetData {
    public static void FuoQuStringData(final String string, final NetInfoCallBack netInfoCallBack, Context context) {

        if (WangLuo.isWL(context)) {
            AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {
                @Override
                protected String doInBackground(Void... voids) {

                    String path = "http://v.juhe.cn/toutiao/index?type=" + string + "&key=597b4f9dcb50e051fd725a9ec54d6653";
                    try {
                        URL url = new URL(path);

                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        //设置
                        connection.setRequestMethod("GET");
                        connection.setReadTimeout(5000);
                        connection.setConnectTimeout(5000);

                        //获取
                        int responseCode = connection.getResponseCode();
                        if (responseCode == 200) {
                            InputStream inputStream = connection.getInputStream();

                            String s = StringStream.streamToString(inputStream, "utf-8");

                            return s;
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return "";
                }

                @Override
                protected void onPostExecute(String json) {


                    netInfoCallBack.getsuccessString(json);
                }
            };

            asyncTask.execute();
        }else {
            WangLuo.TanKuang(context);
        }
    }

    public static void NetDoc(final NetInfoCallBack callBack, Context context) {
        if (WangLuo.isWL(context)) {
            AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {
                @Override
                protected String doInBackground(Void... voids) {

                    String path = "http://v3.wufazhuce.com:8000/api/reading/index/?version=3.5.0&platform=android";
                    try {
                        URL url = new URL(path);

                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        //设置
                        connection.setRequestMethod("GET");
                        connection.setReadTimeout(5000);
                        connection.setConnectTimeout(5000);

                        //获取
                        int responseCode = connection.getResponseCode();
                        if (responseCode == 200) {
                            InputStream inputStream = connection.getInputStream();

                            String s = StringStream.streamToString(inputStream, "utf-8");

                            return s;
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return "";
                }

                @Override
                protected void onPostExecute(String json) {


                    callBack.getsuccessString(json);
                }
            };

            asyncTask.execute();
        }else {
            WangLuo.TanKuang(context);
        }
    }

    public static void getNetTouTiao(Context context, final int num, final NetInfoCallBack callBack) {
        if (WangLuo.isWL(context)) {
            AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {
                @Override
                protected String doInBackground(Void... voids) {

                    String path = "https://api.tianapi.com/wxnew/?key=8d6e3228d25298f13af4fc40ce6c9679&num=10&page="+num;
                    try {
                        URL url = new URL(path);

                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        //设置
                        connection.setRequestMethod("GET");
                        connection.setReadTimeout(5000);
                        connection.setConnectTimeout(5000);

                        //获取
                        int responseCode = connection.getResponseCode();
                        if (responseCode == 200) {
                            InputStream inputStream = connection.getInputStream();

                            String s = StringStream.streamToString(inputStream, "utf-8");

                            return s;
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return "";
                }

                @Override
                protected void onPostExecute(String json) {


                    callBack.getsuccessString(json);
                }
            };

            asyncTask.execute();
        }else {
            WangLuo.TanKuang(context);
        }
    }
}
