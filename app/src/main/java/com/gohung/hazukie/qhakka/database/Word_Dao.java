package com.gohung.hazukie.qhakka.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Word_Dao {
    @Update
    void updateWord(Word word);

    @Query("SELECT * FROM word")
    List<Word> getAllWord();

    @Query("SELECT * FROM word WHERE hz=:hz")
    Word getSingleWord(String hz);

    @Query("SELECT * FROM word")
    LiveData<List<Word>> getAllWordList();

    @Query("SELECT *FROM word WHERE hk_p=:hk_p")
    List<Word> getWOrdsByHkp(String hk_p);

    @Query("SELECT * FROM word WHERE cmn_p=:cmn_p")
    List<Word> getWordsByCmnp(String cmn_p);

}
