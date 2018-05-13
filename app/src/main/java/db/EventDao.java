package db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import models.Event;

/**
 * Created by jd on 3/13/18.
 */

@Dao
public interface EventDao {
    @Insert
    void insert(Event event);

    @Query("DELETE FROM events")
    void deleteAll();

    @Query("SELECT * FROM events WHERE uid = :searchId")
    LiveData<Event> getById(int searchId);

    @Query("SELECT * FROM events ORDER BY event_start_date ASC")
    LiveData<List<Event>> getAllEvents();
}
