package com.gohung.hazukie.qhakka;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import java.util.ArrayList;

public class SubFragment extends Fragment {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private String tile;
    private QMUITopBarLayout top;
    private ListView lsit;
    private String[] strings;
    private int select=0;
    private ArrayAdapter<String> arrayAdapter;
    private String settings_one,settings_two;

    public SubFragment(String title,String[] strings,int selectedType){
        //,String setting_one,String setting_two){
        this.tile=title;
        this.strings=strings;
        this.select=selectedType;
       // this.settings_one=setting_one;
        //this.settings_two=setting_two;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_setting_lang_sub,container,false);
        lsit=(ListView)root.findViewById(R.id.sub_frag_list);
        top=(QMUITopBarLayout)root.findViewById(R.id.sub_frag_top);
        sp= PreferenceManager.getDefaultSharedPreferences(getActivity());
        editor=sp.edit();
        top.setTitle(tile);
        top.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getActivity().onBackPressed();
            }
        });
        initsList();
        return root;
    }

    private void initsList(){
                lsit.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                arrayAdapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_single_choice,strings);
                lsit.setAdapter(arrayAdapter);
                int listRecord=0;
                switch (select){
                    case 0:
                    int cmnWay=sp.getInt("cmn_visible_way",0);
                    listRecord=cmnWay;
                    break;
                    case 1:
                        int hkWay=sp.getInt("hakka_visible_way",0);
                        listRecord=hkWay;
                        break;
                    case 2:
                        int ipaWay=sp.getInt("ipa_visible_way",1);
                        listRecord=ipaWay;
                        break;
                    case 3:
                        int fontWay=sp.getInt("font_visible_way",0);
                        listRecord=fontWay;
                        break;
                    default:
                        break;
                }
                lsit.setItemChecked(listRecord,true);
                lsit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        switch (select){
                            case 0:
                                editor.putInt("cmn_visible_way",i);
                                editor.commit();
                                break;
                            case 1:
                                editor.putInt("hakka_visible_way",i);
                                editor.commit();
                                break;
                            case 2:
                                editor.putInt("ipa_visible_way",i);
                                editor.commit();
                                break;
                            case 3:
                                editor.putInt("font_visible_way",i);
                                editor.commit();
                                break;

                        }
                       // Toast.makeText(getActivity(), "clicked"+i, Toast.LENGTH_SHORT).show();
                    }
                });

    }

}
