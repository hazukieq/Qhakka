package com.gohung.hazukie.qhakka.binderr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.gohung.hazukie.qhakka.Data_model.SecondHk;
import com.gohung.hazukie.qhakka.R;

public class SecondHkCard extends ItemViewBinder<SecondHk,SecondHkCard.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        View root=layoutInflater.inflate(R.layout.second_hk_card,viewGroup,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, SecondHk secondHk) {
            viewHolder.content.setText(secondHk.getHkcard());
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            content=(TextView) itemView.findViewById(R.id.shk_card_text);

        }
    }
}
