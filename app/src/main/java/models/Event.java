package models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by jd on 3/13/18.
 */

@Entity
public class Event {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "event_address")
    private String address;

    @ColumnInfo(name = "event_start_date")
    private String startDate; // TODO: 3/13/18 JD convert this to a sql friendly date object?? https://medium.com/@chrisbanes/room-time-2b4cf9672b98

    public Event(String address, String startDate) {
        this.address = address;
        this.startDate = startDate;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
