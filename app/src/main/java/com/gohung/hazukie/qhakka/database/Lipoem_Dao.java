package com.gohung.hazukie.qhakka.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Lipoem_Dao {

    @Query("SELECT * FROM Lipoems WHERE muluk=:muluk")
    Lipoem getLipoemByMuluk(String muluk);

    @Query("SELECT*FROM Lipoems")
    List<Lipoem> getAllLipoems();

    @Query("SELECT muluk FROM Lipoems")
    LiveData<List<String>> getAllByLivedata();

    @Query("SELECT*FROM Lipoems limit 50")
    List<Lipoem> getFiftypoems();

    @Query("SELECT*FROM Lipoems WHERE id=:id")
    Lipoem getPoemById(int id);
}
