package com.gohung.hazukie.qhakka.binderr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.gohung.hazukie.qhakka.Data_model.PlayHk;
import com.gohung.hazukie.qhakka.R;
import com.gohung.hazukie.qhakka.Utils.ConvertTextUtils;

public class SecondHkPlayBinder extends ItemViewBinder<PlayHk,SecondHkPlayBinder.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        View root=layoutInflater.inflate(R.layout.second_hk_audio_card,viewGroup,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, PlayHk playHk) {

        viewHolder.hkp.setText(playHk.getHkp());
        viewHolder.playhk.setTag(playHk.getAudioIndex());

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView hkp;
        private ImageButton playhk;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hkp=(TextView) itemView.findViewById(R.id.sehk_pin);
            playhk=(ImageButton) itemView.findViewById(R.id.seplayhk);
        }
    }
}
