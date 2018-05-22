package mock.roomdb.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import mock.roomdb.data.db.UserKt

/**
 * Created by BalaKrishnan on 26-02-2018.
 */
@Dao
interface UserDataDao {
    @Query("SELECT * from UserKt")
    fun getAll(): List<UserKt>

    @Insert(onConflict = REPLACE)
    fun insert(userData: UserKt)

    @Query("DELETE from UserKt")
    fun deleteAll()
}
