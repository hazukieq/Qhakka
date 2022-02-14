package com.gohung.hazukie.qhakka.binderr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.gohung.hazukie.qhakka.Data_model.BnannerModel;
import com.gohung.hazukie.qhakka.R;
import com.gohung.hazukie.qhakka.adapers.ImageAdapter;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.transformer.AlphaPageTransformer;

public class BannerBinder extends ItemViewBinder<BnannerModel,BannerBinder.ViewHolder> {
    private FragmentActivity getA;

    public BannerBinder(FragmentActivity getA){
        this.getA=getA;
    }


                        @NonNull
                        @Override
    public ViewHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.bannerview,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, BnannerModel bnannerModel) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private Banner banner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            int position=getLayoutPosition();
            banner=(Banner) itemView.findViewById(R.id.banner_card_banner);
            banner.setAdapter(new ImageAdapter(BnannerModel.getBnanerData()));
            banner.addBannerLifecycleObserver(getA);
            banner.addPageTransformer(new AlphaPageTransformer());
            banner.setBannerGalleryEffect(0, 0);
            banner.setIndicator(new CircleIndicator(getA));
        }
    }
}
