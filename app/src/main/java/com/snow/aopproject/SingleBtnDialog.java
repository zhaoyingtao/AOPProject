package com.snow.aopproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


public class SingleBtnDialog {

    private Context mContext;
    private AlertDialog mDialog;

    private TextView mTvContent;
    private TextView mTvSure;

    public SingleBtnDialog(Context mContext) {
        this.mContext = mContext;
        initView();
    }

    private void initView() {
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.dialog_single_btna, null);
        mTvContent = contentView.findViewById(R.id.tv_content_msg);
        mTvSure = contentView.findViewById(R.id.tv_sure);
        mDialog = new AlertDialog.Builder(mContext).setView(contentView).create();
        mDialog.setCancelable(true);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                Log.e("snow_aop", "dialog关闭");
            }
        });
    }

    public void show() {
        Log.e("snow_aop", "dialog显示");
        mDialog.show();
    }

    public void dismiss() {

        if (mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    public interface DialogItemClickListener {
        void onSure();
    }
}
