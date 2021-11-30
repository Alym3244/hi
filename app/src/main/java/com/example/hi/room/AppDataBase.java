package com.example.hi.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.hi.model.TaskModel;

@Database(entities = {TaskModel.class},version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract TaskDao taskDao();

}
