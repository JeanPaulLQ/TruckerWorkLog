package com.someware.bitacoraviajes.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.someware.bitacoraviajes.data.DAO.ExpensesDao;
import com.someware.bitacoraviajes.data.database.AppDataBase;
import com.someware.bitacoraviajes.data.models.Expenses;

import java.util.List;

public class ExpensesRepository {
    private ExpensesDao expensesDao;
    private LiveData<List<Expenses>> allExpenses;
    public ExpensesRepository(Application application){
        AppDataBase dataBase = AppDataBase.getInstance(application);
        expensesDao = dataBase.expensesDao();
    }

    public LiveData<List<Expenses>> getAllExpenses(long id) {
        allExpenses = expensesDao.getExpensesById(id);
        return allExpenses;
    }
    public void insert(Expenses expenses){
        new Thread(()->expensesDao.insertExpenses(expenses));
    }
    public void delete(Expenses expenses){
        new Thread(()->expensesDao.deleteExpenses(expenses));
    }
    public void update(Expenses expenses){
        new Thread(()->expensesDao.updateExpenses(expenses));
    }
    public void insertGroup(Expenses... expenses){
        new Thread(()->expensesDao.insertAll(expenses));
    }

}
