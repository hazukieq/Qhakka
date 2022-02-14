package com.gohung.hazukie.qhakka.binderr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.gohung.hazukie.qhakka.Data_model.SecondHk;
import com.gohung.hazukie.qhakka.Data_model.UniversalMuluk;
import com.gohung.hazukie.qhakka.R;
import com.gohung.hazukie.qhakka.onItemClickListener;

import org.w3c.dom.Text;

public class UniversalMulukBinder extends ItemViewBinder<UniversalMuluk,UniversalMulukBinder.ViewHolder>  {

    private com.gohung.hazukie.qhakka.onItemClickListener onItemClickListener=null;

    public void setOnItemClickListener(com.gohung.hazukie.qhakka.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.universal_muluk,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,UniversalMuluk muluk) {

        viewHolder.muluk.setText(muluk.getTitle());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener!=null){
                   onItemClickListener.onItemClick(viewHolder.itemView,muluk.getTitle());
                   onItemClickListener.onItemUrlClick(viewHolder.itemView, muluk.getTitle(), muluk.getUrl());
                }
            }
        });

    }





    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView muluk;
        public ViewHolder(View view){
            super(view);
            muluk=(TextView) view.findViewById(R.id.universal_muluk);
        }
    }
}
