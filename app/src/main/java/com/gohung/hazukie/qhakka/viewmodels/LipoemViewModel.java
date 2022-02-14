package com.gohung.hazukie.qhakka.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.gohung.hazukie.qhakka.database.Lipoem;
import com.gohung.hazukie.qhakka.database.Word_database;

import java.util.List;

public class LipoemViewModel extends AndroidViewModel {
    private Word_database wdata;
    private LiveData<List<String>> alls;

    public LipoemViewModel(@NonNull Application application) {
        super(application);
        wdata=Word_database.getInstance(application);
        alls=wdata.lipoem_dao().getAllByLivedata();
    }
    public LiveData<List<String>> getAllpoems(){
        return alls;
    }

}
