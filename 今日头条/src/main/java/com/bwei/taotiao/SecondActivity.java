package com.bwei.taotiao;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bwei.taotiao.base.BaseActivty;
import com.bwei.taotiao.fragment.ShouyeFragment;
import com.bwei.taotiao.fragment.TouTiaoFragment;
import com.bwei.taotiao.fragment.WoFragment;
import com.bwei.taotiao.util.WangLuo;

public class SecondActivity extends BaseActivty {



    private RadioGroup radioGroup;

    @Override
    protected int getLayout() {
        return R.layout.activity_second;
    }

    @Override
    protected void getfindID() {



        radioGroup = (RadioGroup) findViewById(R.id.group01);
    }

    @Override
    protected void getData() {

       Boolean iswl =  WangLuo.isWL(this);
        if (iswl){

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new ShouyeFragment()).commit();

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    switch (radioGroup.getCheckedRadioButtonId()){
                        case R.id.radio01:

                            transaction.replace(R.id.frame_layout,new ShouyeFragment()).commit();

                            break;
                        case R.id.radio02:
                            transaction.replace(R.id.frame_layout,new TouTiaoFragment()).commit();
                            break;
                        case R.id.radio03:
                            transaction.replace(R.id.frame_layout,new WoFragment()).commit();
                            break;
                    }
                }
            });


        }else {
            WangLuo.TanKuang(this);
        }
    }
}
