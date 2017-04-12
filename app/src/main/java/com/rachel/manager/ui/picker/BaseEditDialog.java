/* *
   * Copyright (C) 2017 BaoliYota Tech. Co., Ltd, LLC - All Rights Reserved.
   *
   * Confidential and Proprietary.
   * Unauthorized copying of this file, via any medium is strictly prohibited.
   * */

package com.rachel.manager.ui.picker;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.rachel.manager.R;


/**
 * 基础编辑框,内部封装了一个dialog
 *
 * @author wanchi@coolpad.com
 * @version 1.0, 2017/4/11
 */
public class BaseEditDialog {

    protected Dialog mDialog;
    protected OnEditResult mOnEditResult;

    public BaseEditDialog(Context context) {
        mDialog = new Dialog(context, R.style.DialogTheme);
        Window dialogWindow = mDialog.getWindow();
        if (dialogWindow != null) {
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            dialogWindow.setGravity(Gravity.BOTTOM);
            dialogWindow.setAttributes(lp);
            dialogWindow.setBackgroundDrawableResource(android.R.color.transparent);
        }
    }

    public void show() {
        if (!mDialog.isShowing()) {
            mDialog.show();
        }
    }

    /**
     * 设置编辑结果监听
     *
     * @param onEditResult 编辑结果监听
     */
    public void setOnEditResult(OnEditResult onEditResult) {
        mOnEditResult = onEditResult;
    }

    /**
     * 编辑结果监听器
     */
    public interface OnEditResult {
        /**
         * 得到编辑的结果
         *
         * @param results 结果，不为null
         */
        void onResult(@NonNull Object... results);
    }
}

