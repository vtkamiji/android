package com.example.kamiji.todolist.dao;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.kamiji.todolist.model.Task;

@Database(entities = {Task.class}, version = 1)
public abstract class TaskDatabase extends RoomDatabase {

    private static TaskDatabase INSTANCE;

    protected TaskDatabase(){}

    public abstract TaskDAO getTaskDAO();

    public synchronized static TaskDatabase getINSTANCE(Context context) {
        if (INSTANCE == null) {
//            synchronized (this) {
                INSTANCE = Room.databaseBuilder(context, TaskDatabase.class, "task_database").allowMainThreadQueries().build();
//            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
