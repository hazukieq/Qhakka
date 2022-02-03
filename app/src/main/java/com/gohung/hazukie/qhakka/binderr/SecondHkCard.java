package com.gohung.hazukie.qhakka.binderr;

import android.text.Html;
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

        String str=secondHk.getHkcard();
        String title= "<font color=\"#7285aa\"><big>"+str.charAt(0)+ "</big></font>";
        str=str.replace(String.valueOf(str.charAt(0)),title);
            viewHolder.content.setText(Html.fromHtml(str.replace("\n","<br/>")));
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            content=(TextView) itemView.findViewById(R.id.shk_card_text);

        }
    }
}
