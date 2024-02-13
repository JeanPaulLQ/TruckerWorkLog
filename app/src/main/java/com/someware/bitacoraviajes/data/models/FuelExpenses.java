package com.someware.bitacoraviajes.data.models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "fuel_expenses_table", foreignKeys = {@ForeignKey(entity = WorkService.class, parentColumns = "workId", childColumns = "workServiceId", onDelete = ForeignKey.CASCADE)})
public class FuelExpenses {
    @PrimaryKey(autoGenerate = true)
    long fuelExpensesId;
    long workServiceId;
    String serviceStation;
    double gallonsFuel;

    public long getFuelExpensesId() {
        return fuelExpensesId;
    }

    public void setFuelExpensesId(long fuelExpensesId) {
        this.fuelExpensesId = fuelExpensesId;
    }

    public long getWorkServiceId() {
        return workServiceId;
    }

    public void setWorkServiceId(long workServiceId) {
        this.workServiceId = workServiceId;
    }

    public String getServiceStation() {
        return serviceStation;
    }

    public void setServiceStation(String serviceStation) {
        this.serviceStation = serviceStation;
    }

    public double getGallonsFuel() {
        return gallonsFuel;
    }

    public void setGallonsFuel(double gallonsFuel) {
        this.gallonsFuel = gallonsFuel;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getFuelDate() {
        return fuelDate;
    }

    public void setFuelDate(long fuelDate) {
        this.fuelDate = fuelDate;
    }

    String documents;
    String location;
    long fuelDate;

}
