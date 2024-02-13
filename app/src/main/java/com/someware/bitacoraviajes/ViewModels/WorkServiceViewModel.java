package com.someware.bitacoraviajes.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.someware.bitacoraviajes.data.models.WorkService;
import com.someware.bitacoraviajes.data.repository.WorkServiceRepository;

import java.util.List;

public class WorkServiceViewModel extends AndroidViewModel {
    private WorkServiceRepository workServiceRepository;
    private LiveData<List<WorkService>> listWorkServices;

    public WorkServiceViewModel(@NonNull Application application) {
        super(application);
        workServiceRepository = new WorkServiceRepository(application);
    }

    public void insertWork(WorkService workService) {
        workServiceRepository.insert(workService);
    }

    public void delete(WorkService workService) {
        workServiceRepository.delete(workService);
    }

    public void update(WorkService workService) {
        workServiceRepository.update(workService);
    }

    public void deleteAll() {
        workServiceRepository.deleteAll();
    }

    public int getPendingWorks() {return workServiceRepository.getPendingWorks();}
    public int getCompletedWorks(){return workServiceRepository.getCompletedWorks();}
    public int getWorksByMonth(String month){return workServiceRepository.getCountByMonth(month);}
}
