package com.example.kamiji.todolist;

import android.app.Application;

import com.example.kamiji.todolist.dao.TaskDatabase;

public class TodoApplication extends Application {

    TaskDatabase taskDB;

    @Override
    public void onCreate() {
        super.onCreate();

        taskDB = TaskDatabase.getINSTANCE(this);
    }

    public TaskDatabase getDatabase() {
        return taskDB;
    }
}
