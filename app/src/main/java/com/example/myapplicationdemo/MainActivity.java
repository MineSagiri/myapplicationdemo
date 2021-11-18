package com.example.myapplicationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.NaviPara;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng endLatLng = new LatLng(117.2703,31.748498);
                // 构造导航参数
                NaviPara naviPara = new NaviPara();
                // 设置终点位置
                naviPara.setTargetPoint(endLatLng);
                // 设置导航策略，这里是避免拥堵
                naviPara.setNaviStyle(AMapUtils.DRIVING_AVOID_CONGESTION);
                try {
                    // 调起高德地图导航
                    AMapUtils.openAMapNavi(naviPara, getApplicationContext());
                } catch (com.amap.api.maps.AMapException e) {
                    // 如果没安装会进入异常，调起下载页面
                    Toast.makeText(getApplicationContext(), e.getErrorMessage(),Toast.LENGTH_SHORT).show();
                    //AMapUtils.getLatestAMapApp(getApplicationContext());
                }
            }
        });
    }
}