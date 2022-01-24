package com.gohung.hazukie.qhakka.binderr;

import android.content.Context;
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

import org.w3c.dom.Text;

public class secondhanzCardBinder extends ItemViewBinder<Word,secondhanzCardBinder.ViewHolder> {

    private Context context;
    public  secondhanzCardBinder(Context con){
        this.context=con;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        View root=layoutInflater.inflate(R.layout.second_hanz_card,viewGroup,false);
        return  new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, Word word) {
        ConvertTextUtils convertTextUtils=new ConvertTextUtils(context);
        viewHolder.shz.setText(word.getHz());
        viewHolder.sbh.setText(convertTextUtils.returnText(word,"bh"));
        viewHolder.scmnp.setText(convertTextUtils.returnText(word,"cmn"));
        viewHolder.shkp.setText(convertTextUtils.returnText(word,"hk"));
        viewHolder.sva.setText(convertTextUtils.returnText(word,"va"));

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView shz,sbh,shkp,scmnp,sva;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shz=(TextView) itemView.findViewById(R.id.shz);
            sbh=(TextView) itemView.findViewById(R.id.sbh);
            shkp=(TextView) itemView.findViewById(R.id.shk_p);
            scmnp=(TextView) itemView.findViewById(R.id.scmn_p);
            sva=(TextView) itemView.findViewById(R.id.sva);
        }
    }
}
