package models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by jd on 3/13/18.
 */

@Entity(tableName = "events")
data class Event(
        @PrimaryKey(autoGenerate = true)
        var uid: Int?,

        @field:ColumnInfo(name = "event_address")
        var address: String?,

        @field:ColumnInfo(name = "event_start_date")
        var startDate: String?
        // TODO: 3/13/18 JD convert this to a sql friendly date object?? https://medium.com/@chrisbanes/room-time-2b4cf9672b98
){
        constructor(newEventAddress: String, newEventDate: String):this(null, newEventAddress, newEventDate)
        constructor():this(null, null, null)
}
