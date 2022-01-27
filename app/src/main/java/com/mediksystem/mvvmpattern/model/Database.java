package com.mediksystem.mvvmpattern.model;

import android.util.Log;

import java.util.ArrayList;

public class Database {
    private static Database instance;
    private ArrayList<Person> personList = new ArrayList<>();
    private String winner;
    private DatabaseListener databaseListener;

    private Database() {
        Log.d("DB", "Model Database 생성");
        personList.add(new Person(0, "최OO"));
        personList.add(new Person(1, "김OO"));
        personList.add(new Person(2, "고OO"));
        personList.add(new Person(3, "문OO"));
        personList.add(new Person(4, "윤OO"));
    }

    public static Database getInstance() {
        Log.d("", "Model 접근 가능하도록 DB 인스턴스 값 요청");
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void getUser() {
        Log.d("", "당첨자 획득");
        winner = personList.get((int)(Math.random()*5)).getName();
        notifyChange();
    }

    private void notifyChange() {
        if (databaseListener != null) {
            Log.d("", "Model Data 변경되어 notify 하라고 알림");
            databaseListener.onChanged();
        }
    }

    public void setOnDatabaseListener(DatabaseListener databaseListener) {
        Log.d("구현 객체 참조 변수 세팅",databaseListener.getClass().getSimpleName());
        this.databaseListener = databaseListener;
    }

    public String getWinner(){
        return winner;
    }

    public interface DatabaseListener {
        void onChanged();
    }
}
