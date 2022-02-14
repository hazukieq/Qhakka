package com.gohung.hazukie.qhakka.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.gohung.hazukie.qhakka.database.Word;
import com.gohung.hazukie.qhakka.database.Word_database;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private Word_database datase;
    private LiveData<List<Word>> liveDataWord;

    public WordViewModel(@NonNull Application application){
        super(application);
        datase=Word_database.getInstance(application);
        liveDataWord=datase.word_dao().getAllWordList();
    }
    public LiveData<List<Word>> getLiveDataWord(){
        return liveDataWord;
    }

}
