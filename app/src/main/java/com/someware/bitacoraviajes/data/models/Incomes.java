package com.someware.bitacoraviajes.data.models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "incomes_table", foreignKeys = {@ForeignKey(entity = WorkService.class, parentColumns = "workId", childColumns = "workServiceId", onDelete = ForeignKey.CASCADE)})
public class Incomes {
    @PrimaryKey(autoGenerate = true)
    long incomesId;
    String description;
    double amount;
    long workServiceId;

    public long getIncomesId() {
        return incomesId;
    }

    public void setIncomesId(long incomesId) {
        this.incomesId = incomesId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getWorkServiceId() {
        return workServiceId;
    }

    public void setWorkServiceId(long workServiceId) {
        this.workServiceId = workServiceId;
    }
}
