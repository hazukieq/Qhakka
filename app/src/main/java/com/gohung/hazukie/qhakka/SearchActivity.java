package com.gohung.hazukie.qhakka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.drakeet.multitype.MultiTypeAdapter;
import com.gohung.hazukie.qhakka.CustomView.ClearEditText;
import com.gohung.hazukie.qhakka.Utils.FilterData;
import com.gohung.hazukie.qhakka.adapers.SinglehanzAdapter;
import com.gohung.hazukie.qhakka.binderr.SingleContentBinder;
import com.gohung.hazukie.qhakka.binderr.SingleHanzBinder;
import com.gohung.hazukie.qhakka.database.Word;
import com.gohung.hazukie.qhakka.database.Word_database;
import com.gohung.hazukie.qhakka.viewmodels.WordViewModel;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private QMUITopBarLayout topba;
    private TextView txt;
    private ScrollView scroll;
    private ClearEditText clear;
    private ImageView imags;
    private QMUIRoundButton roundButton;
    private RecyclerView recy;
    private ArrayList<Object> items=new ArrayList<>();
  //     private List<Word> alls=new ArrayList<>();
    private List<Word> copyList=new ArrayList<>();
    private Word_database wdatabase;
  //  private SinglehanzAdapter hanzAd;
    private MultiTypeAdapter hanzAd;
    private Spinner spinner;
    private String[] spinner_strs;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private void initViews(){
        scroll=(ScrollView)findViewById(R.id.searchAct_scroll);
        //scroll.setVisibility(View.VISIBLE);
        txt=(TextView)findViewById(R.id.searchAct_text);
        txt.setText(getText(R.string.searchAct_text_content));
        recy=(RecyclerView) findViewById(R.id.search_recy);
        wdatabase=Word_database.getInstance(this);
        hanzAd=new MultiTypeAdapter();
        SingleHanzBinder hanzBinder=new SingleHanzBinder();
        hanzBinder.setOnItemClickListener(new onItemClickListener() {
            @Override
            public void onItemClick(View v, String s) {
                Intent inl=new Intent();
                inl.setClass(SearchActivity.this,SecondActivity.class);
                Bundle bu=new Bundle();
                bu.putString("hz",s);
                inl.putExtras(bu);
                startActivity(inl);
            }

            @Override
            public void onItemUrlClick(View v, String s, String url) {

            }

            @Override
            public void onItemLongClick(View v, String s) {

            }
        });
        hanzAd.register(Word.class,hanzBinder);
        //hanzAd=new SinglehanzAdapter(alls);
        hanzAd.setItems(items);
        recy.setLayoutManager(new LinearLayoutManager(this));
        recy.setAdapter(hanzAd);
        clear=(ClearEditText)findViewById(R.id.search_clearEdit);
        roundButton=(QMUIRoundButton)findViewById(R.id.search_btn);
        roundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yhz = clear.getText().toString();
                int spinner_selected=sp.getInt("spinner_selected",0);
                String input_str=clear.getText().toString();
                if(input_str.isEmpty()){
                   // alls.clear();
                    items.clear();
                    scroll.setVisibility(View.VISIBLE);

                    hanzAd.notifyDataSetChanged();
                }else{

                   // alls.clear();
                    items.clear();
                    FilterData filterData=new FilterData(input_str,copyList);
                    switch (spinner_selected) {
                        case 0:
                            if (String.valueOf(input_str).matches("[\u4e00-\u9fa5]")) {
                                List<Word> retru = new ArrayList<>();
                                retru.clear();
                                retru = filterData.returnHanzlist();
                                //alls.addAll(retru);
                                items.addAll(retru);
                                scroll.setVisibility(View.GONE);
                                hanzAd.notifyDataSetChanged();
                                break;
                            }
                            break;
                        case 1:
                            List<Word> het = new ArrayList<>();
                            het.clear();
                            het = filterData.returnHakkaList();
                            //alls.addAll(het);
                            items.addAll(het);
                            scroll.setVisibility(View.GONE);
                            hanzAd.notifyDataSetChanged();
                            break;
                        case 2:
                            List<Word> ret = new ArrayList<>();
                            ret.clear();
                            ret = filterData.returnCmnList();
                            //alls.addAll(ret);
                            items.addAll(ret);
                            scroll.setVisibility(View.GONE);
                            hanzAd.notifyDataSetChanged();
                            break;
                    }

                    }

            }
        });
        /*hanzAd.setOnItemClickListener(new Sin.OnItemClickListener() {
            @Override
            public void onClick(View v, String hz) {
                Intent inl=new Intent();
                inl.setClass(SearchActivity.this,SecondActivity.class);
                Bundle bu=new Bundle();
                bu.putString("hz",hz);
                inl.putExtras(bu);
                startActivity(inl);
            }

            @Override
            public void onLongClick(View v, String hz) {

            }
        });*/
        topba=(QMUITopBarLayout)findViewById(R.id.search_top);
        imags=(ImageView)findViewById(R.id.search_imageview);
        Glide.with(this).load(R.drawable.icon_app_search).into(imags);
        topba.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QMUIStatusBarHelper.translucent(SearchActivity.this);
        setContentView(R.layout.search_layout);
        sp= PreferenceManager.getDefaultSharedPreferences(SearchActivity.this);
        editor=sp.edit();
        spinner=(Spinner)findViewById(R.id.actionDown);
        WordViewModel wordViewModel=new ViewModelProvider(this).get(WordViewModel.class);
        wordViewModel.getLiveDataWord().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                //alls.clear();
                copyList.addAll(words);
            }
        });
        initViews();
        initSpinner();

    }

    private void initSpinner(){

        spinner_strs= new String[]{getString(R.string.frag_main_hanz),getString(R.string.frag_main_hakka),getString(R.string.frag_main_common)};
        ArrayAdapter<String> spinnerAdp=new ArrayAdapter<String>(this,R.layout.spinner_item_selected,spinner_strs);
        spinnerAdp.setDropDownViewResource(R.layout.sinner_dropdown_item);
        spinner.setAdapter(spinnerAdp);
        sp= this.getPreferences(Context.MODE_PRIVATE);
        editor=sp.edit();
        int selected=sp.getInt("spinner_selected",0);
        Log.i("spinner_selected is--->", String.valueOf(selected));
        spinner.setSelection(selected);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor.putInt("spinner_selected",i);
                editor.commit();
                Log.i( "onItemSelected commit is-->", String.valueOf(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}