package com.someware.bitacoraviajes.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.someware.bitacoraviajes.data.models.Expenses;
import com.someware.bitacoraviajes.data.repository.ExpensesRepository;

import java.util.List;

public class ExpensesViewModel extends AndroidViewModel {
    private ExpensesRepository expensesRepository;
    private LiveData<List<Expenses>> listExpenses;
    public ExpensesViewModel(@NonNull Application application) {
        super(application);
        expensesRepository = new ExpensesRepository(application);
    }
    public void insertExpenses(Expenses expenses){
        expensesRepository.insert(expenses);
    }
    public void updateExpenses(Expenses expenses){
        expensesRepository.update(expenses);
    }
    public void deleteExpenses(Expenses expenses){
        expensesRepository.delete(expenses);
    }
    public void insertAllExpenses(Expenses... expenses){
        expensesRepository.insertGroup(expenses);
    }

}
