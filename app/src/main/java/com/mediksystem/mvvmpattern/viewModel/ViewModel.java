package com.mediksystem.mvvmpattern.viewModel;

import android.app.Person;
import android.util.Log;

import com.mediksystem.mvvmpattern.model.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import androidx.databinding.BaseObservable;

public class ViewModel extends BaseObservable {
    private Database database;
    private List<Person> items = new ArrayList<>();
    private String winner;

    public ViewModel(Database database){
        Log.d("", "ViewModel 생성자 실행 | DB(Model) 참조");
        this.database = database;

        this.database.setOnDatabaseListener(new Database.DatabaseListener() {
            @Override
            public void onChanged() {
                Log.d("","리스너 실행");
                winner = null;
                winner = database.getWinner();
                notifyChange();
            }
        });
    }

    public void getUser() {
        Log.d("","db에게 user(winner)를 달라고 요청");
        database.getUser();
    }

    public String getWinner(){
        if (winner != null) {
            Log.d("Winner 반환", winner);
            return winner;
        } else {
            return "";
        }

    }
}
