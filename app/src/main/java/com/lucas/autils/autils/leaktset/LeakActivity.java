package com.lucas.autils.autils.leaktset;

import android.app.Activity;
import android.os.Bundle;

import com.lucas.autils.autils.R;

/**
 * 内存泄露
 * @author lucas
 * created at 2019/9/22 2:53 PM
 */
public class LeakActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_test);

        LeakTestManager manager = LeakTestManager.getInstance(LeakActivity.this);
    }

}