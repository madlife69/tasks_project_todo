package com.example.tasks_project.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize
import java.text.DateFormat

@Entity(tableName = "task_table")
@VersionedParcelize
data class Task(
    val name: String,
    val important: Boolean = false,
    val completed: Boolean = false,
    val created: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true) val id: Int = 0
) : Parcelable {

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }

    val createdDateFormatted: String
        get() = DateFormat.getDateInstance().format(created)

    constructor(parcel: Parcel) : this(
        parcel.readString()?: "",
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readLong(),
        parcel.readInt()
    ) {
    }

    companion object CREATOR : Parcelable.Creator<Task> {
        override fun createFromParcel(parcel: Parcel): Task {
            return Task(parcel)
        }

        override fun newArray(size: Int): Array<Task?> {
            return arrayOfNulls(size)
        }
    }
}
