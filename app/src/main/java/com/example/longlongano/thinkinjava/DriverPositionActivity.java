package com.example.longlongano.thinkinjava;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DriverPositionActivity extends AppCompatActivity {

    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_position);

        final ImageView imageView = (ImageView) findViewById(R.id.icon);
        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_bg);

        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    frameLayout.setLayoutParams(new LinearLayout.LayoutParams(dip2px(v.getContext(), 120), dip2px(v.getContext(),120)));

                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(dip2px(v
                            .getContext(), 52), dip2px(v.getContext(), 52));
                    params.gravity= Gravity.CENTER;
                    imageView.setLayoutParams(params);
                    InjectUtils.injectOnClick(DriverPositionActivity.this);
                }else {
                    frameLayout.setLayoutParams(new LinearLayout.LayoutParams(dip2px(v.getContext(), 96), dip2px(v.getContext(),96)));

                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(dip2px(v
                            .getContext(), 40), dip2px(v.getContext(), 40));
                    params.gravity= Gravity.CENTER;
                    imageView.setLayoutParams(params);
                }

                flag = !flag;
            }
        });



    }

    @OnClick({R.id.fl_bg, R.id.pb_loading})
    public void customerOnClick(View view) {
        System.out.println("view = [" + view + "]");
    }

    public static int px2dip(Context context, float pxValue){
        final float scale = context.getResources ().getDisplayMetrics ().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int dip2px(Context context,float dpValue){
        final float scale = context.getResources ().getDisplayMetrics ().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
