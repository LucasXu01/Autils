package com.lucas.autils.autils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 原生webview  js与安卓互调
 * @author lucas
 * created at 2019/9/12 12:23 PM
 */
public class testActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsjava);

        String name = getIntent().getStringExtra("name");
        int age = getIntent().getIntExtra("age",1);
        databean databean = (databean)getIntent().getSerializableExtra("ceshi");

        name = "lucas lucas";
        age = 44;
        databean.setName("xuxux  xiugai!");
        databean.setAge(1000);



    }





}