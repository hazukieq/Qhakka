package com.gohung.hazukie.qhakka.binderr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.gohung.hazukie.qhakka.R;
import com.gohung.hazukie.qhakka.Utils.ConvertTextUtils;
import com.gohung.hazukie.qhakka.database.Word;

public class SingleHanzBinder extends ItemViewBinder<Word,SingleHanzBinder.ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        View root=layoutInflater.inflate(R.layout.single_hanz_card,viewGroup,false);
        return  new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, Word word) {
        ConvertTextUtils convert=new ConvertTextUtils(viewHolder.itemView.getContext());
        viewHolder.sihz.setText(word.getHz());
        viewHolder.sibh.setText(convert.returnText(word,"bh"));
        viewHolder.sihk.setText(convert.returnText(word,"hk"));
        viewHolder.siva.setText(convert.returnText(word,"va"));
        viewHolder.sicmn.setText(convert.returnText(word,"cmn"));

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
