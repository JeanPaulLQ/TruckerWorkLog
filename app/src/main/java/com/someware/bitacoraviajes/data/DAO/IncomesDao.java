package com.someware.bitacoraviajes.data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.someware.bitacoraviajes.data.models.Incomes;

import java.util.List;

@Dao
public interface IncomesDao {
    @Query("SELECT * FROM incomes_table WHERE workServiceId=:id")
    LiveData<List<Incomes>> getIncomesById(long id);
    @Insert
    void insertAll(Incomes... incomes);
    @Insert
    void insertIncomes(Incomes incomes);
    @Update
    void updateIncomes(Incomes incomes);
    @Delete
    void deleteIncomes(Incomes incomes);
}
