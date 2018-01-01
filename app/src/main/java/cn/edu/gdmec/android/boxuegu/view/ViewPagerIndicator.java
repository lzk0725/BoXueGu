package cn.edu.gdmec.android.boxuegu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import cn.edu.gdmec.android.boxuegu.R;


/**
 * Created by student on 17/12/29.
 */

public class ViewPagerIndicator extends LinearLayout {

    private int mCount;//小圆点的个数
    private int mIndex;//当前小圆点位置
    private Context context;

    public ViewPagerIndicator(Context context) {
        this(context,null);
    }

    public ViewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setGravity(Gravity.CENTER);
    }
    public void setCurrentPosition(int currentIndex){
        mIndex = currentIndex;
        removeAllViews();
        int pex = 5;//内边距
        for (int i=0;i<mCount;i++){
            ImageView imageView = new ImageView(context);
            if (mIndex == i){
                //蓝色为选中
                imageView.setImageResource(R.drawable.indicator_on);
            }else {
                //灰色图片
                imageView.setImageResource(R.drawable.indicator_off);
            }
            imageView.setPadding(pex,0,pex,0);
            addView(imageView);
        }
    }

    public void setCount(int count){
        this.mCount = count;
    }
}
