package com.rachel.manager.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 本地变量保存
 * Created by Rachel on 17/4/4.
 */

public class SharedPreferenceHelper {
        private static final String FILE_NAME = "app_data";
        private static SharedPreferences mSharedPreferences;// 单例
        private static SharedPreferenceHelper instance;// 单例

        private SharedPreferenceHelper(Context context) {
            mSharedPreferences = context.getSharedPreferences(FILE_NAME,
                    Context.MODE_PRIVATE);
        }

        /**
         * 获取单例
         */
        public static SharedPreferenceHelper getInstance(Context context) {
            if (instance == null) {
                instance = new SharedPreferenceHelper(context);
            }
            return instance;
        }

        /**
         * 保存数据
         */
        public void saveData(String key, Object data) {
            String type = data.getClass().getSimpleName();

            SharedPreferences.Editor editor = mSharedPreferences.edit();

            if ("Integer".equals(type)) {
                editor.putInt(key, (Integer) data);
            } else if ("Boolean".equals(type)) {
                editor.putBoolean(key, (Boolean) data);
            } else if ("String".equals(type)) {
                editor.putString(key, (String) data);
            } else if ("Float".equals(type)) {
                editor.putFloat(key, (Float) data);
            } else if ("Long".equals(type)) {
                editor.putLong(key, (Long) data);
            }

            editor.apply();
        }

        /**
         * 得到数据
         */
        public Object getData(String key, Object defValue) {

            String type = defValue.getClass().getSimpleName();
            if ("Integer".equals(type)) {
                return mSharedPreferences.getInt(key, (Integer) defValue);
            } else if ("Boolean".equals(type)) {
                return mSharedPreferences.getBoolean(key, (Boolean) defValue);
            } else if ("String".equals(type)) {
                return mSharedPreferences.getString(key, (String) defValue);
            } else if ("Float".equals(type)) {
                return mSharedPreferences.getFloat(key, (Float) defValue);
            } else if ("Long".equals(type)) {
                return mSharedPreferences.getLong(key, (Long) defValue);
            }

            return null;
        }
}
