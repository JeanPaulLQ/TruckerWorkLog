package com.someware.bitacoraviajes.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.someware.bitacoraviajes.data.models.Incomes;
import com.someware.bitacoraviajes.data.repository.IncomesRepository;

import java.util.List;

public class IncomesViewModel extends AndroidViewModel {
    private IncomesRepository repository;
    private LiveData<List<Incomes>> listIncomes;
    public IncomesViewModel(@NonNull Application application) {
        super(application);
        repository = new IncomesRepository(application);
    }
    public LiveData<List<Incomes>> getListIncomes(long id){
        listIncomes = repository.getAllIncomes(id);
        return listIncomes;
    }
    public void insertIncome(Incomes incomes){
        repository.insert(incomes);
    }
    public void updateIncome(Incomes incomes){
        repository.update(incomes);
    }
    public void deleteIncome(Incomes incomes){
        repository.delete(incomes);
    }
    public void insertAllIncomes(Incomes... incomes){
        repository.insertGroup(incomes);
    }
}
