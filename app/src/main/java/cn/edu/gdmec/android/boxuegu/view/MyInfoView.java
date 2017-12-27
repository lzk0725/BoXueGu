package cn.edu.gdmec.android.boxuegu.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.edu.gdmec.android.boxuegu.R;
import cn.edu.gdmec.android.boxuegu.utils.AnalysisUtils;

/**
 * Created by student on 17/12/27.
 */

public class MyInfoView {
    private Context mContext;
    private final LayoutInflater minflater;
    private View mCurrentvView;
    private LinearLayout ll_head;
    private ImageView iv_head_icon;
    private RelativeLayout rl_course_history;
    private RelativeLayout rl_setting;
    private TextView tv_user_name;

    public MyInfoView(Context mContext) {
        this.mContext = mContext;
        minflater = LayoutInflater.from(mContext);
    }

    private void initView(){
        mCurrentvView = minflater.inflate(R.layout.main_view_myinfo, null);
        ll_head = (LinearLayout) mCurrentvView.findViewById(R.id.ll_head);
        iv_head_icon = (ImageView) mCurrentvView.findViewById(R.id.iv_head_icon);

        rl_course_history = (RelativeLayout) mCurrentvView.findViewById(R.id.rl_course_history);
        rl_setting = (RelativeLayout) mCurrentvView.findViewById(R.id.rl_setting);

        tv_user_name = (TextView) mCurrentvView.findViewById(R.id.et_username);
        mCurrentvView.setVisibility(View.VISIBLE);
        setLoginParams(readLoginStatus());

        ll_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //判断是否已经登录
                if (readLoginStatus()){
                    //跳转到个人资料界面
                }else {

                }
            }
        });
    }

    private void setLoginParams(boolean isLogin) {
        if (isLogin){
            tv_user_name.setText(AnalysisUtils.readLoginUserName(mContext));
        }else {
            tv_user_name.setText("点击登录");
        }
    }

    private boolean readLoginStatus(){
        SharedPreferences sp = mContext.getSharedPreferences("loginInfo",Context.MODE_PRIVATE);
        boolean isLogin = sp.getBoolean("isLogin",false);
        return isLogin;
    }
}
