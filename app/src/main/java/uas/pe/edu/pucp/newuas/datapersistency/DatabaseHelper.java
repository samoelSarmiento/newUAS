package uas.pe.edu.pucp.newuas.datapersistency;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.User;
import uas.pe.edu.pucp.newuas.model.UserResponse;

/**
 * Created by samoe on 27/10/2016.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "db.uas";
    private static final int DATABASE_VERSION = 1;
    private Dao<UserResponse, Integer> userResponseDAO = null;
    private Dao<User, Integer> userDao = null;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, UserResponse.class);
        } catch (SQLException e) {
            Log.e("DBEror", "Error de base de datos");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource source, int oldVersion, int newVersion) {
        try {
            //Se borran todas las tablas
            TableUtils.dropTable(source, User.class, true);
            TableUtils.dropTable(source, UserResponse.class, true);
            //Se crean denuevo
            onCreate(db, source);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Dao<UserResponse, Integer> getUserResponseDAO() throws SQLException {
        if (userResponseDAO == null) userResponseDAO = getDao(UserResponse.class);
        return userResponseDAO;
    }

    public Dao<User, Integer> getUserDao() throws SQLException {
        if (userDao == null) userDao = getDao(User.class);
        return userDao;
    }
}
