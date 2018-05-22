package mock.roomdb.data.db;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

import mock.roomdb.data.dao.UserDao;
import mock.roomdb.data.dao.UserDataDao;
import mock.roomdb.data.entity.User;
@Database(entities = {UserKt.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract UserDataDao userDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "userDetails")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                          //  .addMigrations(MIGRATION_3_4)
                            .build();
        }
        return INSTANCE;
    }
//
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
//            database.execSQL("ALTER TABLE User "
//                    + " ADD COLUMN last_update INTEGER NOT NULL DEFAULT 0");
        }
    };

    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Create the new table
            database.execSQL(
                    "CREATE TABLE users_new1 (uid TEXT, username TEXT, last_update INTEGER, PRIMARY KEY(uid))");

            // Copy the data
            database.execSQL(
                    "INSERT INTO users_new1 (uid, username, last_update) SELECT uid, first_name, last_update FROM user");

            // Remove the old table
            database.execSQL("DROP TABLE user");

            // Change the table name to the correct one
            database.execSQL("ALTER TABLE users_new1 RENAME TO user");
        }
    };


    public static void destroyInstance() {
        INSTANCE = null;
    }
}