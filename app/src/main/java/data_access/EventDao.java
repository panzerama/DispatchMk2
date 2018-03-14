package data_access;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import models.Event;

/**
 * Created by jd on 3/13/18.
 */

@Dao
public interface EventDao {
    @Insert
    void insert(Event event);

    @Query("SELECT * FROM event WHERE uid = :searchId")
    Event getById(int searchId);
}
