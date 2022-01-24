package com.gohung.hazukie.qhakka;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gohung.hazukie.qhakka.Utils.ConvertTextUtils;
import com.gohung.hazukie.qhakka.database.Word;

import java.util.ArrayList;
import java.util.List;

public class SinglehanzAdapter  extends RecyclerView.Adapter<SinglehanzAdapter.ViewHolder> implements View.OnClickListener{
    private List<Word> mlist=new ArrayList<>();
    private OnItemClickListener onItemClickListener=null;

    public interface OnItemClickListener{
        void onClick(View v,String hz);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.onItemClickListener=onItemClickListener;
    }

    public SinglehanzAdapter(List<Word> list){
        this.mlist=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_hanz_card,parent,false);
        root.setOnClickListener(this::onClick);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        Word word=mlist.get(position);
        ConvertTextUtils convert=new ConvertTextUtils(viewHolder.itemView.getContext());
        viewHolder.sihz.setText(word.getHz());
        viewHolder.sibh.setText(convert.returnText(word,"bh"));
        viewHolder.sihk.setText(convert.returnText(word,"hk"));
        viewHolder.siva.setText(convert.returnText(word,"va"));
        viewHolder.sicmn.setText(convert.returnText(word,"cmn"));
        viewHolder.itemView.setTag(word.getHz());
    }

    @Override
    public int getItemCount() {
        if(mlist==null||mlist.size()<=0){
            return 0;
        }
        return mlist.size();
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) {
            onItemClickListener.onClick(view,(String) view.getTag());
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView sihz,sibh,sihk,siva,sicmn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sihz=(TextView) itemView.findViewById(R.id.hz);
            sibh=(TextView) itemView.findViewById(R.id.bh);
            sihk=(TextView) itemView.findViewById(R.id.hk_p);
            siva=(TextView) itemView.findViewById(R.id.va);
            sicmn=(TextView) itemView.findViewById(R.id.cmn_p);
        }
    }

}
