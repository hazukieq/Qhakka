package com.gohung.hazukie.qhakka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.drakeet.multitype.MultiTypeAdapter;

import com.gohung.hazukie.qhakka.Data_model.PlayHk;
import com.gohung.hazukie.qhakka.Data_model.SecondHk;
import com.gohung.hazukie.qhakka.Data_model.single_content;
import com.gohung.hazukie.qhakka.Utils.ConvertTextUtils;
import com.gohung.hazukie.qhakka.Utils.ConvertToUtils;
import com.gohung.hazukie.qhakka.binderr.SecondHkCard;
import com.gohung.hazukie.qhakka.binderr.SecondHkPlayBinder;
import com.gohung.hazukie.qhakka.binderr.SingleContentBinder;
import com.gohung.hazukie.qhakka.binderr.secondhanzCardBinder;
import com.gohung.hazukie.qhakka.database.Word;
import com.gohung.hazukie.qhakka.database.Word_database;

import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import java.util.ArrayList;
import java.util.List;


public class SecondActivity extends AppCompatActivity {
    private RecyclerView recy;

    private MultiTypeAdapter multiTypeAdapter;
    private ArrayList<Object> items=new ArrayList<>();
    private List<Word> mlist=new ArrayList<>();
    private Word_database database;
    private    String receive;
    private QMUITopBarLayout topbar;
    private SharedPreferences sp;
    private Boolean hk_boolean;
    private Boolean swBoolean;
    private Boolean kxBoolean;
    private Boolean hdBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        QMUIStatusBarHelper.translucent(this);

         sp= PreferenceManager.getDefaultSharedPreferences(this);
         hk_boolean=sp.getBoolean("hakka_boolean",true);
         swBoolean=sp.getBoolean("sw_boolean",true);
         kxBoolean=sp.getBoolean("kx_boolean",true);
         hdBoolean=sp.getBoolean("hd_boolean",true);
        Intent ing=getIntent();
        Bundle bu=ing.getExtras();
        receive=bu.getString("hz");
        database=Word_database.getInstance(this);
        new QueryAllWordsTask(receive).execute();
        recy=(RecyclerView)findViewById(R.id.second_recy);
        multiTypeAdapter=new MultiTypeAdapter();
        multiTypeAdapter.register(Word.class,new secondhanzCardBinder(this));

        SecondHkCard secondHkcard=new SecondHkCard();
        multiTypeAdapter.register(PlayHk.class,new SecondHkPlayBinder());
        multiTypeAdapter.register(single_content.class,new SingleContentBinder());
        multiTypeAdapter.register(SecondHk.class,secondHkcard);

        recy.setAdapter(multiTypeAdapter);

        topbar=(QMUITopBarLayout) findViewById(R.id.second_topbar);
        topbar.setTitle(receive+"\t"+getString(R.string.second_details));
        ImageButton imagbtn=topbar.addRightImageButton(R.drawable.second_explain_icon,R.id.second_topbar);
        imagbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showLongMessageDialog();
            }
        });
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

            String hk=wos.getHk_p();
            if(hk_boolean==true){
                items.add(new SecondHk(receive+"\n"+getString(R.string.hakka_head)));
                if(hk== null||hk.isEmpty()) {
                    items.add(new PlayHk("暂无", "vu.mp3"));
               }else {

                    String[] hks=hk.split(",");
                    for(int i=0;i<hks.length;i++){
                        String shkp=hks[i];
                        ConvertToUtils utils=new ConvertToUtils();
                        String hkpin=utils.returnSingleTones_PY(shkp);
                        items.add(new PlayHk(hkpin,hk+".mp3"));
                    }

                }

            }

           String hkext=wos.getHk();
           if(hkext==null||hkext.isEmpty()) items.add(new single_content("客家话解释",getString(R.string.all_vu)));
           else items.add(new single_content("客家话解释",hkext));


            String sw=wos.getSw();
           if(swBoolean==true){

               if((!sw.isEmpty())) items.add(new single_content(getString(R.string.sw_head), sw));
               else items.add(new single_content(getString(R.string.sw_head),getString(R.string.all_vu)));
           }



            String kx=wos.getKx();
           if(kxBoolean==true){
               if((!kx.isEmpty())) items.add(new single_content(getString(R.string.kx_head),kx));
               else items.add(new single_content(getString(R.string.sw_head),getString(R.string.all_vu)));
           }


            String hd=wos.getHd();
           if(hdBoolean==true){
               if((!hd.isEmpty())) items.add(new single_content(getString(R.string.hd_head),hd));
               else items.add(new single_content(getString(R.string.sw_head),getString(R.string.all_vu)));
           }

            multiTypeAdapter.setItems(items);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            multiTypeAdapter.notifyDataSetChanged();
        }
    }
    private void showLongMessageDialog() {
        new QMUIDialog.MessageDialogBuilder(SecondActivity.this)
                .setTitle(getString(R.string.second_explain))
                .setSkinManager(QMUISkinManager.defaultInstance(SecondActivity.this))
                .setMessage(getText(R.string.second_explain_content))
                .addAction("知道了", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .create( R.style.DialogTheme2).show();
    }
}