package com.gohung.hazukie.qhakka.adapers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.gohung.hazukie.qhakka.Data_model.BnannerModel;
import com.gohung.hazukie.qhakka.R;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public class ImageAdapter extends BannerAdapter<BnannerModel,ImageAdapter.BannerViewHolder> {

    public ImageAdapter(List<BnannerModel> datas){
        super(datas);
    }

    @Override
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {

        return new BannerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_image_title, parent, false));
    }

    @Override
    public void onBindView(BannerViewHolder holder, BnannerModel data, int position, int size) {
        //       holder.imageview.setImageResource(data.imageId);

        holder.textView.setText(data.title);
        Glide.with(holder.imageview.getContext()).load(data.getImageId()).into(holder.imageview);
        //holder.imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //holder.imageview.setImageResource(data.getImageId());
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageview;
        public TextView textView;
        public BannerViewHolder(@NonNull View view){
            super(view);
            imageview=(ImageView) view.findViewById(R.id.banner_image);
            textView=(TextView) view.findViewById(R.id.bannerTitle);

        }
    }

}
