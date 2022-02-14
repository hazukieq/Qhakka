package com.gohung.hazukie.qhakka.binderr;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.drakeet.multitype.ItemViewBinder;
import com.gohung.hazukie.qhakka.R;
import com.gohung.hazukie.qhakka.Utils.ConvertTextUtils;
import com.gohung.hazukie.qhakka.database.Word;

import org.w3c.dom.Text;

public class secondhanzCardBinder extends ItemViewBinder<Word,secondhanzCardBinder.ViewHolder> {
    private SharedPreferences sp;

    private Context context;
    public  secondhanzCardBinder(Context con){
        this.context=con;
        this.sp= PreferenceManager.getDefaultSharedPreferences(con);
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

        String bh_head=convertTextUtils.returnSecondText(word,"bh");
        Log.i( "onBindViewHolder: ","-->"+bh_head);
        viewHolder.sbh.setText(Html.fromHtml(bh_head.replace("\n","<br/>")));

        String cmn_head=convertTextUtils.returnSecondText(word,"cmn");
        viewHolder.scmnp.setText(Html.fromHtml(cmn_head.replace("\n","<br/>")));

        String hk_head=convertTextUtils.returnSecondText(word,"hk");
        viewHolder.shkp.setText(Html.fromHtml(hk_head.replace("\n","<br/>")));


        String va_head=convertTextUtils.returnSecondText(word,"va");
        viewHolder.sva.setText(Html.fromHtml(va_head.replace("\n","<br/>")));

        Glide.with(viewHolder.itemView.getContext()).load(R.drawable.mi).into(viewHolder.simg);

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView shz,sbh,shkp,scmnp,sva;
        private ImageView simg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shz=(TextView) itemView.findViewById(R.id.shz);
            sbh=(TextView) itemView.findViewById(R.id.sbh);
            shkp=(TextView) itemView.findViewById(R.id.shk_p);
            scmnp=(TextView) itemView.findViewById(R.id.scmn_p);
            sva=(TextView) itemView.findViewById(R.id.sva);
            simg=(ImageView) itemView.findViewById(R.id.simg);

            Boolean cmnBoolean=sp.getBoolean("cmn_boolean",true);
            Boolean vasBoolean=sp.getBoolean("vas_boolean",true);

            if(cmnBoolean==true){
                scmnp.setVisibility(View.VISIBLE);
            }else{
                scmnp.setVisibility(View.INVISIBLE);
            }

            if(vasBoolean==true){
                sva.setVisibility(View.VISIBLE);
            }else{
                sva.setVisibility(View.INVISIBLE);
            }
        }

    }
}
