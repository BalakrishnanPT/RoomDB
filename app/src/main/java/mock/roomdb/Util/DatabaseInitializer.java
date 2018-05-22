//package mock.roomdb.Util;
//
//import android.os.AsyncTask;
//import android.support.annotation.NonNull;
//import android.util.Log;
//
//import java.util.List;
//
//import mock.roomdb.data.db.AppDatabase;
//import mock.roomdb.data.entity.User;
//
///**
// * Created by BalaKrishnan on 22-02-2018.
// */
//
//public class DatabaseInitializer {
//
//    private static final String TAG = DatabaseInitializer.class.getName();
//
//    public static void populateAsync(@NonNull final AppDatabase db) {
//        PopulateDbAsync task = new PopulateDbAsync(db);
//        task.execute();
//    }
//
//    public static void populateSync(@NonNull final AppDatabase db) {
//        populateWithTestData(db);
//    }
//
//    private static User addUser(final AppDatabase db, User user) {
//     //   db.userDao().insertAll(user);
//        return user;
//    }
//
//    private static void populateWithTestData(AppDatabase db) {
//        User user = new User();
//        user.setFirstName("Ajay");
//        user.setLastName("Saini");
//        user.setAge(25);
//      //  user.setLastUpdate(4);
//        addUser(db, user);
//
//        List<User> userList = db.userDao().getAll();
//        for(User u :userList){
//            Log.d(DatabaseInitializer.TAG, "Rows Count: " + u.toString());
//        }
//    }
//
//    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
//
//        private final AppDatabase mDb;
//
//        PopulateDbAsync(AppDatabase db) {
//            mDb = db;
//        }
//
//        @Override
//        protected Void doInBackground(final Void... params) {
//            populateWithTestData(mDb);
//            return null;
//        }
//
//    }
//}