package com.someware.bitacoraviajes.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.someware.bitacoraviajes.data.DAO.WorkServiceDao;
import com.someware.bitacoraviajes.data.database.AppDataBase;
import com.someware.bitacoraviajes.data.models.WorkService;

import java.util.List;

public class WorkServiceRepository {
    private WorkServiceDao workServiceDao;
    private LiveData<List<WorkService>> allWorks;

    public WorkServiceRepository(Application application){
        AppDataBase appDataBase = AppDataBase.getInstance(application);
        workServiceDao=appDataBase.workServiceDao();
    }
    public LiveData<List<WorkService>> getAllWorks(long id){
        allWorks=workServiceDao.getWorkService(id);
        return allWorks;
    }
    public void insert(WorkService workService){
        new Thread(()->workServiceDao.insertWork(workService)).start();
    }
    public void delete(WorkService workService){
        new Thread(()->workServiceDao.deleteWork(workService)).start();
    }
    public void update(WorkService workService){
        new Thread(()->workServiceDao.updateWork(workService)).start();
    }
    public void deleteAll(){
        new Thread(()->workServiceDao.deleteAll()).start();
    }
    public int getPendingWorks(){
        return workServiceDao.getCountPendingWorks();
    }
    public int getCompletedWorks(){
        return workServiceDao.getCountCompletedWorks();
    }
    public int getCountByMonth(String month){
        return workServiceDao.getCountWorksByMonth(month);
    }
}
