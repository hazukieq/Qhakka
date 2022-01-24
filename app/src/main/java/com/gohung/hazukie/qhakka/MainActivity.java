package com.gohung.hazukie.qhakka;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.MultiTypeAdapter;
import com.gohung.hazukie.qhakka.Utils.ConvertTextUtils;
import com.gohung.hazukie.qhakka.binderr.SingleHanzBinder;
import com.gohung.hazukie.qhakka.database.Word;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Object> items=new ArrayList<>();
    private List<Word> mlist=new ArrayList<>();
    private MultiTypeAdapter multiTypeAdapter;
    private RecyclerView recy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //QMUIStatusBarHelper.setStatusBarLightMode(this);
        TextView te=(TextView) findViewById(R.id.testcmn);
        recy=(RecyclerView)findViewById(R.id.recy);
        multiTypeAdapter=new MultiTypeAdapter();
        multiTypeAdapter.register(Word.class,new SingleHanzBinder());



        ConvertTextUtils cv=new ConvertTextUtils(this);
        Word wos=new Word(1,"我","5","","ss",null," ","bbb","hhh","jhjj","jjj");
        String d=cv.returnText(wos,"va");
        te.setText(d);
        items.add(wos);
        mlist.add(wos);
        multiTypeAdapter.setItems(items);
        //recy.setAdapter(multiTypeAdapter);
        SinglehanzAdapter singleAdp=new SinglehanzAdapter(mlist);
        recy.setAdapter(singleAdp);
        singleAdp.setOnItemClickListener(new SinglehanzAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, String hz) {
                //Toast.makeText(MainActivity.this,""+hz,Toast.LENGTH_SHORT).show();
            }
        });
    }
}