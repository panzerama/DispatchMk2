package models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverter

import java.time.OffsetDateTime

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
        var startDate: OffsetDateTime? = null
){
        constructor(newEventAddress: String, newEventDate: OffsetDateTime):this(null, newEventAddress, newEventDate)
        constructor():this(null, null, null)
}

object EventTypeConverters {
        @TypeConverter
        @JvmStatic
        fun toOffsetDateTime(value: String?): OffsetDateTime? {
                return value?.let {
                        return OffsetDateTime.parse(value)
                }
        }

        @TypeConverter
        @JvmStatic
        fun fromOffsetDateTime(date: OffsetDateTime?): String? {
                return date?.toString()
        }
}