package com.gohung.hazukie.qhakka.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class,Lipoem.class},exportSchema = false,version = 1)
public abstract class Word_database extends RoomDatabase {

    private static final String DATABASE_NAME="qhk.db";
    private static Word_database databaseInstance;

    public static synchronized Word_database getInstance(Context context){
        if (databaseInstance == null) {
            databaseInstance= Room.databaseBuilder(context.getApplicationContext(),Word_database.class,DATABASE_NAME)
                    .createFromAsset("database/qhk.db")
                    .build();
        }
        return databaseInstance;
    }
    public abstract Word_Dao word_dao();
    public abstract Lipoem_Dao lipoem_dao();

}
