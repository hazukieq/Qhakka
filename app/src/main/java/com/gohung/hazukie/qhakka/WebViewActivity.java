package com.gohung.hazukie.qhakka;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gohung.hazukie.qhakka.CustomView.ScrollWebView;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUIProgressBar;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.qmuiteam.qmui.widget.webview.QMUIBridgeWebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private FrameLayout mainView;
    private QMUIProgressBar progressBar;
    private QMUITopBarLayout topbar;
    private WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        QMUIStatusBarHelper.translucent(this);
        topbar=(QMUITopBarLayout)findViewById(R.id.webviewAct_topbar);
        mainView=(FrameLayout) findViewById(R.id.webviewAct_main_frame);
         web=new WebView(getApplicationContext());
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        web.setLayoutParams(params);
        mainView.addView(web);
        topbar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(web.canGoBack()){
                    web.goBack();
                }else{
                    finish();
                }
            }
        });
        progressBar=(QMUIProgressBar)findViewById(R.id.webviewAct_progress);
        init();
        web.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(!url.startsWith("http")){
                    try {

                        final Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        new QMUIDialog.MessageDialogBuilder(WebViewActivity.this).setTitle("提示")
                                .setSkinManager(QMUISkinManager.defaultInstance(WebViewActivity.this))
                                .setMessage("请问是否需要打开相关应用？")
                        .addAction("取消", new QMUIDialogAction.ActionListener() {
                            @Override
                            public void onClick(QMUIDialog dialog, int index) {
                                dialog.dismiss();
                            }
                        })
                                .addAction("确认", new QMUIDialogAction.ActionListener() {
                                    @Override
                                    public void onClick(QMUIDialog dialog, int index) {
                                        startActivity(intent);
                                    }
                                }).create(R.style.DialogTheme2).show();

                    }catch (Exception e){
                        Toast.makeText(WebViewActivity.this, "出错啦！暂未实现相关功能！", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                    return true;
                }
                return false;
            }
        });
        web.setWebChromeClient(new CustomWebChromeClient(){


            @Override
            public void onReceivedTitle(WebView view, String title) {
                topbar.setTitle(title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {



                if(newProgress==100){
                   new Handler().postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           progressBar.setVisibility(View.GONE);
                       }
                   },200);

                }else{
                    progressBar.setProgress(newProgress);
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });

        Intent inh=getIntent();
        Bundle buj=inh.getExtras();
        String link=buj.getString("link");
        if(link!=null||(!link.isEmpty())){
            web.loadUrl(link);
        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    protected void init() {
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(false);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setDefaultTextEncodingName("GBK");
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setTextZoom(100);
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);

     }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode==KeyEvent.KEYCODE_BACK)&&web.canGoBack()){
            web.goBack();
               return true;
        }
        return super.onKeyDown(keyCode,event);
    }



    private class CustomWebChromeClient extends WebChromeClient{
        CustomViewCallback customViewCallback;

        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            customViewCallback=callback;
            web.setVisibility(View.GONE);
            topbar.setVisibility(View.GONE);
            FrameLayout video=(FrameLayout) findViewById(R.id.webviewAct_frame);
            video.addView(view);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            setFullScreen();
        }

        @Override
        public void onHideCustomView() {
            if(customViewCallback!=null){
                customViewCallback.onCustomViewHidden();
            }
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
            quitFullscreen();
            web.setVisibility(View.VISIBLE);
        }
    }

    public void setFullScreen(){

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
    public void quitFullscreen(){
        final WindowManager.LayoutParams attrs=getWindow().getAttributes();
        attrs.flags&=(~WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setAttributes(attrs);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
       // web.getSettings().setJavaScriptEnabled(false);
        topbar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(web!=null) {
               web.clearHistory();
               web.clearCache(true);
            ((ViewGroup)web.getParent()).removeView(web);
            web.destroy();
            web=null;
        }

    }
}