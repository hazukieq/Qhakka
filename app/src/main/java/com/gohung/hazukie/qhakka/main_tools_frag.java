package com.gohung.hazukie.qhakka;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drakeet.multitype.MultiTypeAdapter;
import com.gohung.hazukie.qhakka.Data_model.UniversalMuluk;
import com.gohung.hazukie.qhakka.Data_model.UniversalTitle;
import com.gohung.hazukie.qhakka.binderr.UniversalMulukBinder;
import com.gohung.hazukie.qhakka.binderr.UniversalTitleBinder;

import java.util.ArrayList;

public class main_tools_frag extends Fragment {
    private RecyclerView recy;
    private ArrayList<Object> items=new ArrayList<>();
    private MultiTypeAdapter multiTypeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.fragment_main_tools_frag, container, false);
        recy=(RecyclerView) root.findViewById(R.id.frag_main_tools_recy);
        recy.setHasFixedSize(true);
        multiTypeAdapter=new MultiTypeAdapter();
        multiTypeAdapter.register(UniversalTitle.class,new UniversalTitleBinder());
        multiTypeAdapter.register(UniversalMuluk.class,new UniversalMulukBinder());
        items.add(new UniversalTitle("编程方面资源"));
        items.add(new UniversalTitle("语言学方面资源"));
        items.add(new UniversalTitle("医学方面资源"));
        items.add(new UniversalTitle("客家方言资源"));
        items.add(new UniversalTitle("方言输入法介绍"));
        multiTypeAdapter.setItems(items);
        recy.setAdapter(multiTypeAdapter);

        return root;
    }
}