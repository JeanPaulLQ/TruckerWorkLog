package com.someware.bitacoraviajes.data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.someware.bitacoraviajes.data.models.WorkService;

import java.util.List;

@Dao
public interface WorkServiceDao {
    @Query("SELECT * FROM work_service_table")
    LiveData<List<WorkService>> getAllWorks();

    @Query("SELECT * FROM work_service_table WHERE workId =:id")
    LiveData<List<WorkService>> getWorkService(long id);

    @Insert
    void insertWork(WorkService workService);

    @Delete
    void deleteWork(WorkService workService);

    @Update
    void updateWork(WorkService workService);
    @Query("DELETE FROM work_service_table")
    void deleteAll();
    @Query("SELECT COUNT(*) FROM work_service_table WHERE status = 0")
    int getCountPendingWorks();
    @Query("SELECT COUNT(*) FROM work_service_table WHERE strftime('%m', outboundStartDate) = :month")
    int getCountWorksByMonth(String month);

    @Query("SELECT COUNT(*) FROM work_service_table WHERE status = 1")
    int getCountCompletedWorks();
}