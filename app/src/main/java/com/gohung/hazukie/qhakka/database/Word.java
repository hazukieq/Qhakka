package com.gohung.hazukie.qhakka.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word")
public class Word {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id",typeAffinity = ColumnInfo.INTEGER)
    public int id;

    @ColumnInfo(name = "hz",typeAffinity = ColumnInfo.TEXT)
    public String hz;

    @ColumnInfo(name = "bh",typeAffinity = ColumnInfo.TEXT)
    public String bh;

    @ColumnInfo(name = "hk_p",typeAffinity = ColumnInfo.TEXT)
    public String hk_p;

    @ColumnInfo(name = "hk",typeAffinity = ColumnInfo.TEXT)
    public String hk;

    @ColumnInfo(name = "va",typeAffinity = ColumnInfo.TEXT)
    public String va;

    @ColumnInfo(name = "cmn_p",typeAffinity = ColumnInfo.TEXT)
    public String cmn_p;

    @ColumnInfo(name = "ltc_mc",typeAffinity = ColumnInfo.TEXT)
    public String ltc_mc;

    @ColumnInfo(name = "sw",typeAffinity = ColumnInfo.TEXT)
    public String sw;

    @ColumnInfo(name = "kx",typeAffinity = ColumnInfo.TEXT)
    public String kx;

    @ColumnInfo(name = "hd",typeAffinity = ColumnInfo.TEXT)
    public String hd;

    public Word(int id,String hz,String bh,String hk_p,String hk,String cmn_p,String va,String ltc_mc,String sw,String kx,String hd){
        this.id=id;
        this.hz=hz;
        this.bh=bh;
        this.hk_p=hk_p;
        this.hk=hk;
        this.cmn_p=cmn_p;
        this.ltc_mc=ltc_mc;
        this.sw=sw;
        this.kx=kx;
        this.hd=hd;
        this.va=va;
    }

    public String getHz() {
        return hz;
    }

    public String getCmn_p() {
        return cmn_p;
    }

    public String getBh() {
        return bh;
    }

    public String getHk_p() {
        return hk_p;
    }

    public String getVa() {
        return va;
    }

    public String getSw() {
        return sw;
    }

    public String getKx() {
        return kx;
    }

    public String getHd() {
        return hd;
    }

    public String getHk() {
        return hk;
    }

}
