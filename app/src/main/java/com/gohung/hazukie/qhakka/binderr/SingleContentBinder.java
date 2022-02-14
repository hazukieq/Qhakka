package com.gohung.hazukie.qhakka.binderr;

import android.graphics.Color;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.gohung.hazukie.qhakka.Data_model.single_content;
import com.gohung.hazukie.qhakka.R;
import com.gohung.hazukie.qhakka.Utils.ConvertToUtils;
import com.google.android.material.shape.RelativeCornerSize;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kotlin.text.Regex;

public class SingleContentBinder extends ItemViewBinder<single_content,SingleContentBinder.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        View root=layoutInflater.inflate(R.layout.single_content_card,viewGroup,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, single_content single_content) {
        String title= "<font color=\"#7285aa\"><big>"+single_content.getTitle()+ "</big></font>";
        viewHolder.title.setText(Html.fromHtml(title));
        String mCon=single_content.getContent();
        ConvertToUtils utis=new ConvertToUtils();
        mCon=mCon.replaceAll("(\\d*)(\\.)(\\d*)(\n)","\n第$1页第$3字$4");
        Pattern p=Pattern.compile("\\`.*\\`");

        Matcher matcher=p.matcher(mCon);
        String copy="";
        while(matcher.find()){
            String willconvert= "<font color=\"#7285aa\"><small>"+matcher.group()+"</small></font>";
            String fe=matcher.group();
            mCon=mCon.replace(fe,willconvert);


        }
        copy=mCon.replace("`","");

        viewHolder.content.setText(Html.fromHtml(copy.replace("\n","<br/>")));
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
