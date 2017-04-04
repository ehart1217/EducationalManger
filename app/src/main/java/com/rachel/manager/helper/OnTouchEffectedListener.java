package com.rachel.manager.helper;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * 给一个图片加一个滤镜,来实现点击效果.缺点是这样做了以后就不能重写Touch事件.
 * 使用方法: 保证view的clickable属性是true.然后设置view.setOnTouchListener(new OnTouchEffectedListener());
 * <p/>
 * Created by ehart on 15-12-9.
 */
public class OnTouchEffectedListener implements View.OnTouchListener {

    private static final String TAG = OnTouchEffectedListener.class.getSimpleName();

    private int mFilterColor;

    /**
     * 无参构造函数,默认滤镜颜色是 Color.LTGRAY
     */
    public OnTouchEffectedListener() {
        this(Color.LTGRAY);
    }

    /**
     * 指定一个滤镜颜色的构造函数
     *
     * @param color 指定的颜色
     */
    public OnTouchEffectedListener(int color) {
        mFilterColor = color;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (!v.isClickable()) {
            v.setClickable(true);
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                setFilter(v);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                removeFilter(v);
                break;
            default:
                break;
        }

        return false;
    }

    private void setFilter(View v) {
        Drawable drawable = null;
        if (v instanceof ImageView) {
            drawable = ((ImageView) v).getDrawable();
        }

        if (drawable == null) {
            drawable = v.getBackground();
        }
        if (drawable != null) {
            drawable.setColorFilter(mFilterColor, PorterDuff.Mode.MULTIPLY);
        }
    }

    private void removeFilter(View v) {
        Drawable drawable = null;
        if (v instanceof ImageView) {
            drawable = ((ImageView) v).getDrawable();
        }
        if (drawable == null) {
            drawable = v.getBackground();
        }
        if (drawable != null) {
            drawable.clearColorFilter();
        }
    }
}
