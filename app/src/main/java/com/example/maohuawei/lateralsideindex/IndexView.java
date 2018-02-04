package com.example.maohuawei.lateralsideindex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class IndexView extends View {


    private static String[] words = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"
    };

    private Paint paint;

    public IndexView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();

    }

    private void init() {

        initPaint();

    }

    private void initPaint() {

        paint = new Paint();
        //颜色
        paint.setColor(Color.BLACK);
        //抗锯齿
        paint.setAntiAlias(true);
        //加粗
        paint.setTypeface(Typeface.DEFAULT_BOLD);

        paint.setTextSize(30);

    }

    //宽度
    private int itemWidth;
    //高度
    private int itemHeight;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        itemWidth = getWidth() / words.length;
        itemHeight = getHeight();

    }


    private int touchIndex = -1;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < words.length; i++) {

            if (touchIndex == i) {
                // 按下绘制字母颜色
                paint.setColor(Color.RED);
            } else {
                paint.setColor(Color.BLACK);
            }
            String word = words[i];

            Rect rect = new Rect();

            paint.getTextBounds(word, 0, 1, rect);

            int wordWidth = rect.width();

            int wordHeight = rect.height();
            //绘制字母的X坐标
            float wordX = itemWidth / 2 - wordWidth / 2 + i * itemWidth;
            //绘制字母的Y坐标
            float wordY = itemHeight / 2 + wordHeight / 2;
            //绘制字母
            canvas.drawText(word, wordX, wordY, paint);
        }


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:

                float x = event.getX();


                int index = (int) (x / itemWidth);
                if (index != touchIndex) {

                    touchIndex = index;
                    invalidate();//强制绘制onDraw();
                    if (onIndexChangeListener != null && touchIndex < words.length) {
                        onIndexChangeListener.onIndexChange(words[touchIndex]);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                touchIndex = -1;
                invalidate();
                break;
        }


        return true;
    }


    public interface OnIndexChangeListener {
        void onIndexChange(String word);
    }

    private OnIndexChangeListener onIndexChangeListener;

    public void setOnIndexChangeListener(OnIndexChangeListener onIndexChangeListener) {
        this.onIndexChangeListener = onIndexChangeListener;
    }
}
