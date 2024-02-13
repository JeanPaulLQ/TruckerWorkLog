package com.someware.bitacoraviajes.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.someware.bitacoraviajes.data.DAO.FuelExpensesDao;
import com.someware.bitacoraviajes.data.database.AppDataBase;
import com.someware.bitacoraviajes.data.models.FuelExpenses;

import java.util.List;

public class FuelExpensesRepository {
    private FuelExpensesDao fuelExpensesDao;
    private LiveData<List<FuelExpenses>> allFuelExpenses;

    public FuelExpensesRepository(Application application) {
        AppDataBase dataBase = AppDataBase.getInstance(application);
        fuelExpensesDao = dataBase.fuelExpensesDao();
    }

    public LiveData<List<FuelExpenses>> getAllFuelExpenses(long id) {
        allFuelExpenses = fuelExpensesDao.getFuelExpensesById(id);
        return allFuelExpenses;
    }

    public void insert(FuelExpenses fuelExpenses) {
        new Thread(() -> fuelExpensesDao.insertFuelExpenses(fuelExpenses));
    }
    public void delete(FuelExpenses fuelExpenses){
        new Thread(()->fuelExpensesDao.deleteFuelExpenses(fuelExpenses));
    }
    public void update(FuelExpenses fuelExpenses){
        new Thread(()->fuelExpensesDao.updateFuelExpenses(fuelExpenses));
    }
    public void insertAll(FuelExpenses... fuelExpenses){
        new Thread(()->fuelExpensesDao.insertAll(fuelExpenses));
    }
}
