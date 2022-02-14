package com.gohung.hazukie.qhakka;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.drakeet.multitype.MultiTypeAdapter;
import com.gohung.hazukie.qhakka.Data_model.BnannerModel;
import com.gohung.hazukie.qhakka.Data_model.SecondHk;
import com.gohung.hazukie.qhakka.Data_model.UniversalMuluk;
import com.gohung.hazukie.qhakka.Data_model.UniversalTitle;
import com.gohung.hazukie.qhakka.adapers.ImageAdapter;
import com.gohung.hazukie.qhakka.binderr.BannerBinder;
import com.gohung.hazukie.qhakka.binderr.UniversalMulukBinder;
import com.gohung.hazukie.qhakka.binderr.UniversalTitleBinder;
import com.gohung.hazukie.qhakka.database.Lipoem;
import com.gohung.hazukie.qhakka.database.Word_database;
import com.gohung.hazukie.qhakka.viewmodels.LipoemViewModel;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.transformer.AlphaPageTransformer;
import com.youth.banner.util.BannerUtils;

import java.util.ArrayList;
import java.util.List;

public class main_culture_subFrag extends Fragment {
    private Banner banner;
    private ArrayList<Object> items = new ArrayList<>();
    private List<Lipoem> Lipoems = new ArrayList<>();
    private List<Lipoem> copys = new ArrayList<>();
    private Word_database wdat;
    private MultiTypeAdapter multiAD;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_main_culture_sub, container, false);
       // banner = (Banner) root.findViewById(R.id.banner_card_banner);

        wdat = Word_database.getInstance(this.getActivity());
        RecyclerView recy = (RecyclerView) root.findViewById(R.id.frag_main_culture_recy);
        multiAD = new MultiTypeAdapter();
        UniversalTitleBinder universalTitleBinder=new UniversalTitleBinder();
        universalTitleBinder.setOnItemClickListener(new onItemClickListener() {
            @Override
            public void onItemClick(View v, String s) {
                switch (s){
                    case "李太白诗集专栏":
                        Intent iy=new Intent();
                        iy.setClass(root.getContext(), UniversalActivity.class);
                        Bundle bun=new Bundle();
                        bun.putString("search","0");
                        iy.putExtras(bun);
                        startActivity(iy);
                        break;
                    case "论语专栏":
                        Toast.makeText(getActivity(), ""+s, Toast.LENGTH_SHORT).show();
                        break;
                    case "道德经专栏":
                        Toast.makeText(getActivity(), ""+s, Toast.LENGTH_SHORT).show();
                        break;
                    case "庄子专栏":
                        Toast.makeText(getActivity(), ""+s, Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;


                }


            }

            @Override
            public void onItemUrlClick(View v, String s, String url) {

            }

            @Override
            public void onItemLongClick(View v, String s) {

            }
        });
        multiAD.register(UniversalTitle.class,universalTitleBinder);
        UniversalMulukBinder mulukBinder=new UniversalMulukBinder();
        mulukBinder.setOnItemClickListener(new onItemClickListener() {
            @Override
            public void onItemClick(View v, String s) {
                Intent forUni=new Intent();
                forUni.setClass(getActivity(),UniversalActivity.class);
                Bundle bu=new Bundle();
                //bu.putString("link","https://www.gushiwen.com//view/72750.html");
                bu.putString("search",s);
                forUni.putExtras(bu);
                startActivity(forUni);

            }

            @Override
            public void onItemUrlClick(View v, String s, String url) {

            }

            @Override
            public void onItemLongClick(View v, String s) {

            }
        });
        multiAD.register(UniversalMuluk.class, mulukBinder);
        multiAD.register(BnannerModel.class,new BannerBinder(getActivity()));
        multiAD.setItems(items);
        recy.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recy.setAdapter(multiAD);
        new QueryAllWordsTask().execute();
        initDatas();

        return root;
    }



    private void initDatas(){

    }


    private class QueryAllWordsTask extends AsyncTask<Void,Void,Void> {
        public QueryAllWordsTask(){

        }

        @Override
        protected Void doInBackground(Void... voids) {
            Lipoems.clear();

            Lipoems.addAll(wdat.lipoem_dao().getFiftypoems());
            items.clear();
            items.add(new BnannerModel(0,null));
            items.add(new UniversalTitle("李太白诗集专栏"));
            for(Lipoem ini:Lipoems) items.add(new UniversalMuluk(ini.getMuluk(),""));
            items.add(new UniversalTitle("论语专栏"));
            items.add(new UniversalTitle("道德经专栏"));
            items.add(new UniversalTitle("庄子专栏"));
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            multiAD.notifyDataSetChanged();

        }
    }


    @Override
    public void onResume() {
        super.onResume();
    }
}