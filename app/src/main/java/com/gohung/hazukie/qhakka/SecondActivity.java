package com.gohung.hazukie.qhakka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.drakeet.multitype.MultiTypeAdapter;
import com.gohung.hazukie.qhakka.Data_model.PlayHk;
import com.gohung.hazukie.qhakka.Data_model.SecondHk;
import com.gohung.hazukie.qhakka.Data_model.single_content;
import com.gohung.hazukie.qhakka.Utils.ConvertToUtils;
import com.gohung.hazukie.qhakka.binderr.SecondHkCard;
import com.gohung.hazukie.qhakka.binderr.SecondHkPlayBinder;
import com.gohung.hazukie.qhakka.binderr.SingleContentBinder;
import com.gohung.hazukie.qhakka.binderr.secondhanzCardBinder;
import com.gohung.hazukie.qhakka.database.Word;
import com.gohung.hazukie.qhakka.database.Word_database;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondActivity extends AppCompatActivity {
    private RecyclerView recy;
    private MultiTypeAdapter multiTypeAdapter;
    private ArrayList<Object> items=new ArrayList<>();
    private List<Word> mlist=new ArrayList<>();
    private Word_database database;
    private    String receive;
    private QMUITopBar topbar;
    private QMUICollapsingTopBarLayout collaps;
    private ImageView ima;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private static String urs="https://api.ixiaowai.cn/api/api.php";
private void initGlide(){
    Glide.with(SecondActivity.this).load(R.drawable.home).into(ima);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarLightMode(this);
        ima=(ImageView) findViewById(R.id.img);
        //sp= PreferenceManager.getDefaultSharedPreferences(this);
        //editor=sp.edit();
        initGlide();
        Intent ing=getIntent();
        Bundle bu=ing.getExtras();
     receive=bu.getString("hz");
        Log.i("hz is--->", ""+receive);
        database=Word_database.getInstance(this);
        new QueryAllWordsTask(receive).execute();
        recy=(RecyclerView)findViewById(R.id.second_recy);
        recy.setHasFixedSize(true);
        multiTypeAdapter=new MultiTypeAdapter();
        multiTypeAdapter.register(Word.class,new secondhanzCardBinder(this));
        multiTypeAdapter.register(PlayHk.class,new SecondHkPlayBinder());
        multiTypeAdapter.register(single_content.class,new SingleContentBinder());
        multiTypeAdapter.register(SecondHk.class,new SecondHkCard());





        recy.setAdapter(multiTypeAdapter);

        topbar=(QMUITopBar) findViewById(R.id.topbar);
       collaps=(QMUICollapsingTopBarLayout)findViewById(R.id.collapsing_topbar_layout);
        topbar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private class QueryAllWordsTask extends AsyncTask<Void,Void,Void> {
        String h;
        public QueryAllWordsTask(String hz){
                   this.h=hz;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            mlist.add(database.word_dao().getSingleWord(h));
            Word wos=mlist.get(0);
            items.add(wos);
            items.add(new SecondHk(receive+"\n"+getString(R.string.hakka_head)));
           String hk=wos.getHk_p();


           if(hk== null||hk.isEmpty()) items.add(new PlayHk("暂无","vu.mp3"));
           else items.add(hk);
           items.add(new single_content("客家话解释","这是测试内容"));
           String sw=wos.getSw();
           if((!sw.isEmpty())) items.add(new single_content(getString(R.string.sw_head), sw));
           else items.add(new single_content(getString(R.string.sw_head),getString(R.string.all_vu)));

           String kx=wos.getKx();
           if((!kx.isEmpty())) items.add(new single_content(getString(R.string.kx_head),kx));
           else items.add(new single_content(getString(R.string.sw_head),getString(R.string.all_vu)));

           String hd=wos.getHd();
           if((!hd.isEmpty())) items.add(new single_content(getString(R.string.hd_head),hd));
           else items.add(new single_content(getString(R.string.sw_head),getString(R.string.all_vu)));

            multiTypeAdapter.setItems(items);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            multiTypeAdapter.notifyDataSetChanged();
            //collaps.setExpandedTitleColor(getColor(R.color.light_white));
            collaps.setTitle(getString(R.string.second_details));
        }
    }
}