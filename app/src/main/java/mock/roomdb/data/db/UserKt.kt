package mock.roomdb.data.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by BalaKrishnan on 26-02-2018.
 */@Entity(tableName = "UserKt")
data class UserKt(@PrimaryKey(autoGenerate = true) var id: Long?,
                       @ColumnInfo(name = "name") var name: String,
                       @ColumnInfo(name = "region") var region: String
){
    constructor():this(null,"","")
}