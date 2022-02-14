package com.gohung.hazukie.qhakka;

import android.view.View;

public interface onItemClickListener {
    void onItemClick(View v,String s);
    void onItemUrlClick(View v,String s,String  url);
    void onItemLongClick(View v,String s);
}
