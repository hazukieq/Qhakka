package com.gohung.hazukie.qhakka;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.MultiTypeAdapter;
import com.gohung.hazukie.qhakka.Data_model.PlayHk;
import com.gohung.hazukie.qhakka.Data_model.SecondHk;
import com.gohung.hazukie.qhakka.Utils.ConvertTextUtils;
import com.gohung.hazukie.qhakka.binderr.SecondHkCard;
import com.gohung.hazukie.qhakka.binderr.SecondHkPlayBinder;
import com.gohung.hazukie.qhakka.binderr.SingleHanzBinder;
import com.gohung.hazukie.qhakka.database.Word;
import com.gohung.hazukie.qhakka.database.Word_database;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Object> items=new ArrayList<>();
    private List<Word> mlist=new ArrayList<>();
    private MultiTypeAdapter multiTypeAdapter;
    private RecyclerView recy;
    Word_database database;
    SinglehanzAdapter singleAdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //QMUIStatusBarHelper.setStatusBarLightMode(this);
        TextView te=(TextView) findViewById(R.id.testcmn);
        recy=(RecyclerView)findViewById(R.id.recy);
        multiTypeAdapter=new MultiTypeAdapter();
        multiTypeAdapter.register(Word.class,new SingleHanzBinder());
        multiTypeAdapter.register(PlayHk.class,new SecondHkPlayBinder());
        multiTypeAdapter.register(SecondHk.class,new SecondHkCard());



        ConvertTextUtils cv=new ConvertTextUtils(this);
        Word wos=new Word(1,"我","5","hauh,haus,haux","hauh,fais,gax",null," ","bbb","hhh","jhjj","jjj");
        String d=cv.returnText(wos,"hk");
        te.setText(d);
        items.add(wos);
        String[] sd=wos.getHk_p().split(",");
        items.add(new SecondHk("客家话解释"));
        for(int y=0;y<sd.length;y++){
            String w=sd[y];
            PlayHk play=new PlayHk(w,w+".mp3");
            items.add(play);
        }
        items.add(new SecondHk("这是一个测试卡片"));
        //database=Word_database.getInstance(this);
        //new QueryAllWordsTask().execute();
        //mlist=database.word_dao().getAllWord();
        //mlist.add(wos);
        multiTypeAdapter.setItems(items);
        recy.setAdapter(multiTypeAdapter);
       // singleAdp=new SinglehanzAdapter(mlist);
        //recy.setAdapter(singleAdp);
        /*singleAdp.setOnItemClickListener(new SinglehanzAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, String hz) {
                Toast.makeText(MainActivity.this,""+hz,Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    private class QueryAllWordsTask extends AsyncTask<Void,Void,Void> {
        public QueryAllWordsTask(){

        }

        @Override
        protected Void doInBackground(Void... voids) {
            mlist.clear();
            mlist.addAll(database.word_dao().getAllWord());
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            singleAdp.notifyDataSetChanged();

        }
    }
}