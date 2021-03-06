package com.gohung.hazukie.qhakka;

import android.content.Intent;
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


public class main_interesting_frag extends Fragment {
    private MultiTypeAdapter multi;
    private ArrayList<Object> items=new ArrayList<>();
    private RecyclerView recy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         View root=inflater.inflate(R.layout.fragment_main_interesting_frag, container, false);
         multi=new MultiTypeAdapter();
         UniversalMulukBinder mulukBinder=new UniversalMulukBinder();
         mulukBinder.setOnItemClickListener(new onItemClickListener() {
             @Override
             public void onItemClick(View v, String s) {

             }

             @Override
             public void onItemUrlClick(View v, String s, String url) {
                 Intent intent=new Intent();
                 intent.setClass(getActivity(),WebViewActivity.class);
                 Bundle hj=new Bundle();
                 hj.putString("link",url);
                 intent.putExtras(hj);
                 startActivity(intent);
             }

             @Override
             public void onItemLongClick(View v, String s) {

             }
         });
         multi.register(UniversalTitle.class,new UniversalTitleBinder());
         multi.register(UniversalMuluk.class,mulukBinder);
         recy=(RecyclerView) root.findViewById(R.id.frag_main_interesting_recy);
         recy.setAdapter(multi);
         String urlhead="https://www.bilibili.com/read/mobile?id=";
         items.add(new UniversalTitle("???????????????"));
         items.add(new UniversalMuluk("A-Soul??????????????????","https://www.bilibili.com/read/mobile?id=11750289"));
         items.add(new UniversalMuluk("A-Soul?????????????????????","https://www.bilibili.com/read/mobile?id=10189015"));
         items.add(new UniversalMuluk("???????????????Up??????????????????????????????","https://www.bilibili.com/read/mobile?id=9751098"));
         items.add(new UniversalMuluk("A-Soul!?????????????????????????????????","https://www.bilibili.com/read/mobile?id=11255821"));
         items.add(new UniversalMuluk("???????????????????????????A-SOUL????????????","https://www.bilibili.com/read/mobile?id=10612124"));
         items.add(new UniversalMuluk("A-Soul???????????????????????????","https://www.bilibili.com/read/mobile?id=11060830"));
         items.add(new UniversalMuluk("A-Soul??????????????????????????????","https://www.bilibili.com/read/mobile?id=10246036"));

         items.add(new UniversalTitle("????????????"));
         items.add(new UniversalTitle("???????????????????????????"));
         multi.setItems(items);
         multi.notifyDataSetChanged();
         return root;
    }
}