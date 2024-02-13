package com.someware.bitacoraviajes.data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.someware.bitacoraviajes.data.models.FuelExpenses;

import java.util.List;

@Dao
public interface FuelExpensesDao {
    @Query("SELECT * FROM fuel_expenses_table WHERE workServiceId=:id")
    LiveData<List<FuelExpenses>> getFuelExpensesById(long id);
    @Insert
    void insertAll(FuelExpenses... expenses);
    @Insert
    void insertFuelExpenses(FuelExpenses expenses);
    @Update
    void updateFuelExpenses(FuelExpenses expenses);
    @Delete
    void deleteFuelExpenses(FuelExpenses expenses);
}
