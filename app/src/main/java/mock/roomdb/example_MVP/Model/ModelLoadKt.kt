package mock.roomdb.example_MVP.Model

import android.content.Context
import android.util.Log
import mock.roomdb.data.db.AppDatabase
import mock.roomdb.data.db.UserKt

/**
 * Created by BalaKrishnan on 26-02-2018.
 */
class ModelLoadKt : ImageViewInteractor{
    private var mDb: AppDatabase? = null

    constructor(ctx : Context){
        mDb = AppDatabase.getAppDatabase(ctx)

    }

    override fun changeText(s: String,r: String): List<UserKt> {
        var user = UserKt(null,s,r)
        insertDataInDb(user)
        var v = getData()
        Log.d("Throwable",v?.toString())
        return v!!
    }

     fun load(): List<UserKt> {
        return getData()
    }

    private fun insertDataInDb(userData: UserKt) {
            mDb?.userDao()?.insert(userData)
    }
    private fun getData(): List<UserKt> {
        return mDb?.userDao()!!.getAll()
    }
}