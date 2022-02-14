package com.gohung.hazukie.qhakka;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gohung.hazukie.qhakka.CustomView.ClearEditText;
import com.gohung.hazukie.qhakka.adapers.QMUIFragmentPagerAdapter;
import com.gohung.hazukie.qhakka.adapers.SinglehanzAdapter;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUIViewPager;
import com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment;
import com.qmuiteam.qmui.widget.tab.QMUITab;
import com.qmuiteam.qmui.widget.tab.QMUITabBuilder;
import com.qmuiteam.qmui.widget.tab.QMUITabSegment;
import com.qmuiteam.qmui.widget.tab.QMUITabSegment2;

import java.util.ArrayList;
import java.util.List;


public class word_Fragment extends Fragment {
    private RecyclerView recyclerView;
    private FrameLayout frameLayout;
    private SinglehanzAdapter adapter;
    private List<String> alls=new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_word, container, false);

        ImageView imags=(ImageView)root.findViewById(R.id.imageview);
        frameLayout=(FrameLayout)root.findViewById(R.id.frag_word_frame);
        recyclerView=(RecyclerView)root.findViewById(R.id.frag_word_recy);
        alls.add("名词");
        alls.add("动词");
        alls.add("代词");
        alls.add("连词");
        alls.add("助词");
        alls.add("形容词");
        alls.add("数词");
        alls.add("量词");
        adapter=new SinglehanzAdapter(alls);
        recyclerView.setAdapter(adapter);

        if(adapter.currentposiotion==0){
            replaceFragment(new Word_Subfrag("名词"));
            //Toast.makeText(getActivity(), "0", Toast.LENGTH_SHORT).show();
        }
        adapter.setOnItemClickListener(new SinglehanzAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position,String s) {
                adapter.currentposiotion=position;
                adapter.notifyDataSetChanged();
                replaceFragment(new Word_Subfrag(s));
            }
        });
        Glide.with(root.getContext()).load(R.drawable.icon_app_search).into(imags);
        ClearEditText editText=(ClearEditText)root.findViewById(R.id.clearsearch);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(i==KeyEvent.KEYCODE_ENTER){
                    //Toast.makeText(root.getContext(), "clicked enter key",Toast.LENGTH_SHORT).show();

                }
                return false;
            }
        });

        return root;
    }


    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.frag_word_frame,fragment);
        //transaction.addToBackStack(null);
        transaction.commit();

    }
    public void returnFragment(Fragment fragment){
        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left,R.anim.slide_in_left,R.anim.slide_out_right);
        transaction.replace(R.id.frag_word_frame,fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}