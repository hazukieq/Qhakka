package com.gohung.hazukie.qhakka.binderr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.gohung.hazukie.qhakka.Data_model.single_content;
import com.gohung.hazukie.qhakka.R;

import org.w3c.dom.Text;

public class SingleContentBinder extends ItemViewBinder<single_content,SingleContentBinder.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        View root=layoutInflater.inflate(R.layout.single_content_card,viewGroup,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, single_content single_content) {
        viewHolder.title.setText(single_content.getTitle());
        viewHolder.content.setText(single_content.getContent());
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title,content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=(TextView) itemView.findViewById(R.id.title);
            content=(TextView) itemView.findViewById(R.id.content);
        }
    }
}
