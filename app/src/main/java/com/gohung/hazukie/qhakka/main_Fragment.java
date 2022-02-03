package com.gohung.hazukie.qhakka;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gohung.hazukie.qhakka.database.Word;
import com.gohung.hazukie.qhakka.database.Word_database;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link main_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class main_Fragment extends Fragment {
    private QMUITopBarLayout topBarLayout;
    private SinglehanzAdapter singleAd;
    private List<Word> mlist=new ArrayList<>();
    private RecyclerView recy;
    private Word_database database;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public main_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Main_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static main_Fragment newInstance(String param1, String param2) {
        main_Fragment fragment = new main_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_main, container, false);
        EditText edit=(EditText) root.findViewById(R.id.frag_main_search);
        recy=(RecyclerView)root.findViewById(R.id.frag_main_recy);
        recy.setHasFixedSize(true);
        singleAd=new SinglehanzAdapter(mlist);
        //database=Word_database.getInstance(this.getContext());
        //new QueryAllWordsTask().execute();
        WordViewModel wordViewModel=new ViewModelProvider(this.getActivity()).get(WordViewModel.class);
        wordViewModel.getLiveDataWord().observe(this.getActivity(), new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                mlist.clear();
                mlist.addAll(words);
                singleAd.notifyDataSetChanged();

            }
        });
        recy.setAdapter(singleAd);
        singleAd.setOnItemClickListener(new SinglehanzAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, String hz) {
                Intent inl=new Intent();
                inl.setClass(getActivity(),SecondActivity.class);
                Bundle bu=new Bundle();
                bu.putString("hz",hz);
                inl.putExtras(bu);
                main_Fragment.this.startActivity(inl);
            }
        });
        edit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(i==KeyEvent.KEYCODE_ENTER){
                    //Toast.makeText(root.getContext(), "clicked enter key",Toast.LENGTH_SHORT).show();
                    //return true;
                }
                return false;
            }
        });
        return root;
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
            singleAd.notifyDataSetChanged();

        }
    }
}