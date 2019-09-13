package com.lucas.autils.autils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
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
public class JsJavaActivity extends Activity {

    private WebView webview;
    private TextView tvJs;
    private TextView tvJsArgs;
    private TextView tvShowmsg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsjava);

        setWebview();
        initView();


    }




    private void initView() {
        tvJs = (TextView) findViewById(R.id.tv_androidcalljs);
        tvJsArgs = (TextView) findViewById(R.id.tv_androidcalljsargs);
        tvShowmsg = (TextView) findViewById(R.id.tv_showmsg);

        tvJs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.loadUrl("javascript:javacalljs()");
            }
        });

        tvJsArgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.loadUrl("javascript:javacalljswith(" + "'Android传过来的参数'" + ")");
            }
        });
    }




    private void setWebview() {
        webview = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        //与js交互必须设置
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl("file:///android_asset/html.html");
        webview.addJavascriptInterface(JsJavaActivity.this,"android");


        //拦截url
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.indexOf("jum")>-1){
                    Toast.makeText(JsJavaActivity.this,"拦截到了相应url，更加需要跳转",Toast.LENGTH_LONG).show();
                    return true;
                }else if (url.startsWith("http")){
                    view.loadUrl(url);
                    return true;
                }
                return false;
            }


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                // 开始加载页面时
            }



            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // 加载结束

                //因为该方法的执行不会使页面刷新，而方法（loadUrl ）的执行则会使页面刷新。
                //Android 4.4 后才可使用
                webview.evaluateJavascript("javascript:javacalljswith(" + "'webview加载完成'" + ")", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        //此处为 js 返回的结果
                        Log.v("Native",value);
                    }
                });


            }

        });
    }




    @JavascriptInterface
    public void jsCallAndroid(){
        tvShowmsg.setText("Js调用Android方法");
    }

    @JavascriptInterface
    public void jsCallAndroidArgs(String args){
        tvShowmsg.setText(args);
    }



}