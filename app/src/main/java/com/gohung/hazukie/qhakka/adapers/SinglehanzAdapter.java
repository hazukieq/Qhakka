package com.gohung.hazukie.qhakka.adapers;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gohung.hazukie.qhakka.R;
import com.gohung.hazukie.qhakka.Utils.ConvertTextUtils;
import com.gohung.hazukie.qhakka.database.Word;

import java.util.ArrayList;
import java.util.List;

public class SinglehanzAdapter  extends RecyclerView.Adapter<SinglehanzAdapter.ViewHolder> {
    private List<String> mlist=new ArrayList<>();
    private OnItemClickListener onItemClickListener=null;
    public int currentposiotion=0;



    public interface OnItemClickListener{
        void onClick(View v,int position,String s);
        //void onLongClick(View v);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.onItemClickListener=onItemClickListener;
    }

    public SinglehanzAdapter(List<String> list){
        this.mlist=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_list_item,parent,false);
        //root.setOnClickListener(this::onClick);
       // root.setOnLongClickListener(this::onLongClick);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.textView.setText(mlist.get(position));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(viewHolder.itemView, viewHolder.getLayoutPosition(), mlist.get(viewHolder.getLayoutPosition()));
                    //currentposiotion=viewHolder.getAdapterPosition();
                    notifyDataSetChanged();
                }
            }
        });

        if(currentposiotion==viewHolder.getAdapterPosition()){
            viewHolder.itemView.setBackgroundColor(viewHolder.itemView.getContext().getColor(R.color.white));
        }else{
            viewHolder.itemView.setBackgroundColor(viewHolder.itemView.getContext().getColor(R.color.light_white));
        }
       /* Word word=mlist.get(position);
        ConvertTextUtils convert=new ConvertTextUtils(viewHolder.itemView.getContext());
        viewHolder.sihz.setText(word.getHz());
        viewHolder.sibh.setText(convert.returnText(word,"bh"));
        viewHolder.sihk.setText(convert.returnText(word,"hk"));
        viewHolder.siva.setText(convert.returnText(word,"va"));
        viewHolder.sicmn.setText(convert.returnText(word,"cmn"));
        viewHolder.itemView.setTag(word.getHz());*/
}

    @Override
    public int getItemCount() {
        if(mlist==null||mlist.size()<=0){
            return 0;
        }
        return mlist.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView  textView;// sihz,sibh,sihk,siva,sicmn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.text);
           // sihz=(TextView) itemView.findViewById(R.id.hz);
            //sibh=(TextView) itemView.findViewById(R.id.bh);
            //sihk=(TextView) itemView.findViewById(R.id.hk_p);
            //siva=(TextView) itemView.findViewById(R.id.va);
            //sicmn=(TextView) itemView.findViewById(R.id.cmn_p);
        }
    }

}
