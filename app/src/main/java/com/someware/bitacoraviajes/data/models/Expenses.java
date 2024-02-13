package com.someware.bitacoraviajes.data.models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "expenses_table", foreignKeys = {@ForeignKey(entity = WorkService.class, parentColumns = "workId", childColumns = "workServiceId", onDelete = ForeignKey.CASCADE)})
public class Expenses {
    @PrimaryKey(autoGenerate = true)
    long expensesId;
    long workServiceId;
    String description;
    double cost;

    public long getExpensesId() {
        return expensesId;
    }

    public void setExpensesId(long expensesId) {
        this.expensesId = expensesId;
    }

    public long getWorkServiceId() {
        return workServiceId;
    }

    public void setWorkServiceId(long workServiceId) {
        this.workServiceId = workServiceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isExpensesType() {
        return expensesType;
    }

    public void setExpensesType(boolean expensesType) {
        this.expensesType = expensesType;
    }

    boolean expensesType;// 0 outbound , 1 return

}
