package com.jiangyy.easydialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by JYY on 2017/8/10.
 */

public class OtherDialog {

    public static class Builder {

        private Context mContext;
        private Dialog mDialog;
        private View mView;
        private LayoutInflater mInflater;

        private WindowManager.LayoutParams mParams;
        private DisplayMetrics mDisplayMetrics;

        public Builder(Context context) {
            mContext = context;
            mInflater = LayoutInflater.from(mContext);
            initView();
        }

        private void initView() {
            mDialog = new Dialog(mContext, R.style.EasyDialogStyle);

            mDisplayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            windowManager.getDefaultDisplay().getMetrics(mDisplayMetrics);
            mParams = mDialog.getWindow().getAttributes();
            mParams.width = (int) (mDisplayMetrics.widthPixels * 0.8);
            mDialog.getWindow().setAttributes(mParams);
        }

        public Builder setContentView(int resource) {
            mView = mInflater.inflate(resource, null);
            mDialog.setContentView(mView);
            return this;
        }

        public Builder setText(int id, String message) {
            TextView textView = mView.findViewById(id);
            textView.setText(message);
            return this;
        }

        public Builder setOnClickListener(int id, View.OnClickListener listener) {
            dismiss();
            if (listener != null) {
                mView.findViewById(id).setOnClickListener(listener);
            }
            return this;
        }

        public Builder setOnClickListener(int id, String message, View.OnClickListener listener) {
            dismiss();
            TextView textView = mView.findViewById(id);
            textView.setText(message);
            if (listener != null) {
                textView.setOnClickListener(listener);
            }
            return this;
        }

        public Builder setWidth(float width) {
            mParams.width = (int) (mDisplayMetrics.widthPixels * width);
            mDialog.getWindow().setAttributes(mParams);
            return this;
        }

        public Builder setHeight(float height) {
            mParams.height = (int) (mDisplayMetrics.heightPixels * height);
            mDialog.getWindow().setAttributes(mParams);
            return this;
        }

        public Builder setCancelable(boolean flag) {
            mDialog.setCancelable(flag);
            return this;
        }

        public Builder setCanceledOnTouchOutside(boolean flag) {
            mDialog.setCanceledOnTouchOutside(flag);
            return this;
        }

        public void show() {
            if (mDialog != null) {
                mDialog.show();
            }
        }

        public void dismiss() {
            if (mDialog != null) {
                mDialog.dismiss();
            }
        }

    }

}