package com.someware.bitacoraviajes.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.someware.bitacoraviajes.data.models.FuelExpenses;
import com.someware.bitacoraviajes.data.repository.FuelExpensesRepository;

import java.util.List;

public class FuelExpensesViewModel extends AndroidViewModel {
    private FuelExpensesRepository fuelExpensesRepository;
    private LiveData<List<FuelExpenses>> listItemFuel;
    public FuelExpensesViewModel(@NonNull Application application) {
        super(application);
        fuelExpensesRepository = new FuelExpensesRepository(application);
    }
    public LiveData<List<FuelExpenses>> getListItemFuel(long id){
        listItemFuel = fuelExpensesRepository.getAllFuelExpenses(id);
        return listItemFuel;
    }
    public void insertFuelExpense(FuelExpenses fuelExpenses){
        fuelExpensesRepository.insert(fuelExpenses);
    }
    public void updateFuelExpenses(FuelExpenses fuelExpenses){
        fuelExpensesRepository.update(fuelExpenses);
    }
    public void deleteFuelExpenses(FuelExpenses fuelExpenses){
        fuelExpensesRepository.delete(fuelExpenses);
    }
    public void insertAllExpenses(FuelExpenses... fuelExpenses){
        fuelExpensesRepository.insertAll(fuelExpenses);
    }
}
