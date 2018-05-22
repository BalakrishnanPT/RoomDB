package mock.roomdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;


/**
 * Created by Eugene Alvizo on 1/4/2015.
 */
public class DataHelper extends OrmLiteSqliteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TestDB";
    private static final int DATABASE_VERSION = 1;

    private RuntimeExceptionDao<Orm_User, Integer> studRuntimeDAO = null;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Orm_User.class);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
        try {
            TableUtils.dropTable(connectionSource, Orm_User.class, true);
            onCreate(sqLiteDatabase,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public RuntimeExceptionDao<Orm_User, Integer> getStudRuntimeExceptionDao(){
        if(studRuntimeDAO == null){
            studRuntimeDAO = getRuntimeExceptionDao(Orm_User.class);
        }
        return studRuntimeDAO;

    }

}
