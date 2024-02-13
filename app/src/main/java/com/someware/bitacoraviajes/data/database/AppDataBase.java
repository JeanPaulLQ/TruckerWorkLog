package com.someware.bitacoraviajes.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.someware.bitacoraviajes.data.DAO.ExpensesDao;
import com.someware.bitacoraviajes.data.DAO.FuelExpensesDao;
import com.someware.bitacoraviajes.data.DAO.IncomesDao;
import com.someware.bitacoraviajes.data.DAO.WorkServiceDao;
import com.someware.bitacoraviajes.data.models.Expenses;
import com.someware.bitacoraviajes.data.models.FuelExpenses;
import com.someware.bitacoraviajes.data.models.Incomes;
import com.someware.bitacoraviajes.data.models.WorkService;
import com.someware.bitacoraviajes.utils.DateConverter;

@Database(entities = {WorkService.class, Expenses.class, Incomes.class, FuelExpenses.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDataBase extends RoomDatabase {
    private static final String DATABASE_NAME = "service_database";
    private static volatile AppDataBase instance;

    public abstract WorkServiceDao workServiceDao();

    public abstract ExpensesDao expensesDao();

    public abstract IncomesDao incomesDao();

    public abstract FuelExpensesDao fuelExpensesDao();

    public static synchronized AppDataBase getInstance(Context context) {
        if (instance == null) {
            synchronized (AppDataBase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDataBase.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }

}
