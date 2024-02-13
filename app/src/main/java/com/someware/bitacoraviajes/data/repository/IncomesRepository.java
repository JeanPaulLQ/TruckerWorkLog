package com.someware.bitacoraviajes.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.someware.bitacoraviajes.data.DAO.IncomesDao;
import com.someware.bitacoraviajes.data.database.AppDataBase;
import com.someware.bitacoraviajes.data.models.Incomes;

import java.util.List;

public class IncomesRepository {
    private IncomesDao incomesDao;
    private LiveData<List<Incomes>> allIncomes;

    public IncomesRepository(Application application){
        AppDataBase dataBase = AppDataBase.getInstance(application);
        incomesDao = dataBase.incomesDao();
        //allIncomes = incomesDao.getIncomesById();
    }

    public LiveData<List<Incomes>> getAllIncomes(long id) {
        allIncomes = incomesDao.getIncomesById(id);
        return allIncomes;
    }
    public void insert(Incomes incomes){
        new Thread(()->incomesDao.insertIncomes(incomes)).start();
    }
    public void delete(Incomes incomes){
        new Thread(()->incomesDao.deleteIncomes(incomes)).start();
    }
    public void update(Incomes incomes){
        new Thread(()->incomesDao.updateIncomes(incomes)).start();
    }
    public void insertGroup(Incomes... incomes){
        new Thread(()->incomesDao.insertAll(incomes));
    }
}
