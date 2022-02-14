package com.gohung.hazukie.qhakka.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

import androidx.annotation.NonNull;

public class ScrollWebView extends WebView {
    private OnScrollChangeCallBack changeCallBack;

    public void setOnChangeCallBack(OnScrollChangeCallBack changeCallBack) {
        this.changeCallBack = changeCallBack;
    }

    public ScrollWebView(@NonNull Context context) {
        super(context);
    }
    public ScrollWebView(@NonNull Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
    }
    public ScrollWebView(@NonNull Context context,AttributeSet attributeSet,int i) {
        super(context,attributeSet,i);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(changeCallBack!=null){
            changeCallBack.onScroll(l-oldl,t-oldt);
        }
    }

    public interface OnScrollChangeCallBack{
        public void onScroll(int dx,int dy);
    }

}
