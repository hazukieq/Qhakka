package com.gohung.hazukie.qhakka.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Lipoems")
public class Lipoem {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id",typeAffinity = ColumnInfo.INTEGER)
    public int id;

    @ColumnInfo(name = "muluk",typeAffinity = ColumnInfo.TEXT)
    public String muluk;

    @ColumnInfo(name = "content",typeAffinity = ColumnInfo.TEXT)
    public String content;

    public Lipoem(int id,String muluk,String content){
        this.id=id;
        this.muluk=muluk;
        this.content=content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getMuluk() {
        return muluk;
    }
}
