package com.example.datainstansi.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataMessage.class},version = 1)

public abstract class AppDatabase extends RoomDatabase {

    public abstract DataMessageDAO dao();
    private static AppDatabase appDatabase;

    public static AppDatabase intDB(Context context) {
        if(appDatabase == null)
            appDatabase= Room.databaseBuilder(context, AppDatabase.class, "dbDataMessage").allowMainThreadQueries().build();

        return appDatabase;
    }


}
