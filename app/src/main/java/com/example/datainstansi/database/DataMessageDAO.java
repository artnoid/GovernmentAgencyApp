package com.example.datainstansi.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DataMessageDAO {
    @Insert
    Long insertData(DataMessage dataMessage);

    @Query("Select*from datamessage_db")
    DataMessage[] getData();

    @Update
    int updateData(DataMessage item);

    @Delete
    void deleteData(DataMessage item);
}