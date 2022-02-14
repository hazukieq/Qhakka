package com.gohung.hazukie.qhakka;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drakeet.multitype.MultiTypeAdapter;
import com.gohung.hazukie.qhakka.Data_model.UniversalMuluk;
import com.gohung.hazukie.qhakka.Data_model.Wordlabel;
import com.gohung.hazukie.qhakka.binderr.UniversalMulukBinder;
import com.gohung.hazukie.qhakka.binderr.WordlabelBinder;
import com.gohung.hazukie.qhakka.database.Word_database;

import java.util.ArrayList;


public class Word_Subfrag extends Fragment {
    String wantStr;
    private Word_database wdata;
    private RecyclerView recy;
    private MultiTypeAdapter multiTypeAdapter;
    private ArrayList<Object> items=new ArrayList<>();

    public Word_Subfrag(String wantSearch){
        this.wantStr=wantSearch;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View root=inflater.inflate(R.layout.fragment_word_subfrag, container, false);
         recy=(RecyclerView) root.findViewById(R.id.frag_word_subfrag_recy);
      LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
         recy.setLayoutManager(linearLayoutManager);

        multiTypeAdapter=new MultiTypeAdapter();
        multiTypeAdapter.register(Wordlabel.class, new WordlabelBinder());
        multiTypeAdapter.register(UniversalMuluk.class,new UniversalMulukBinder());
        items.add(new UniversalMuluk(wantStr,""));
        for(int i=0;i<100;i++) {
            //if(i%7==0) items.add(new UniversalMuluk("",""));
            items.add(new Wordlabel("这是测试内容"));
        }
        multiTypeAdapter.setItems(items);
        recy.setAdapter(multiTypeAdapter);
        multiTypeAdapter.notifyDataSetChanged();
         return root;
    }
}