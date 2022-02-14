package com.gohung.hazukie.qhakka.Data_model;

import com.gohung.hazukie.qhakka.R;

import java.util.ArrayList;
import java.util.List;

public class BnannerModel {
    public int  imageId;
    public String title;

    public  BnannerModel(int imageId,String title){
        this.imageId=imageId;
        this.title=title;
    }

    public static List<BnannerModel> getBnanerData(){
        List<BnannerModel> list=new ArrayList<>();
        list.add(new BnannerModel(R.drawable.compass,"医科大校园景"));
        list.add(new BnannerModel(R.drawable.home,"我熟悉的家乡"));
        list.add(new BnannerModel(R.drawable.city,"忙碌的城市"));
        return list;
    }

    public int getImageId() {
        return imageId;
    }
}
