package com.someware.bitacoraviajes.data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.someware.bitacoraviajes.data.models.Expenses;

import java.util.List;

@Dao
public interface ExpensesDao {
    @Query("SELECT * FROM expenses_table WHERE workServiceId=:id")
    LiveData<List<Expenses>> getExpensesById(long id);
    @Insert
    void insertAll(Expenses... expenses);
    @Insert
    void insertExpenses(Expenses expenses);
    @Update
    void updateExpenses(Expenses expenses);
    @Delete
    void deleteExpenses(Expenses expenses);
}
