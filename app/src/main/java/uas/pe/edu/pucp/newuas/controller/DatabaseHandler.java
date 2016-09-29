package uas.pe.edu.pucp.newuas.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import uas.pe.edu.pucp.newuas.model.User;

/**
 * Created by samoe on 28/09/2016.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "dp2";

    // Contacts table name
    private static final String TABLE_USERS = "Users";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_IDPERFIL = "idperfil";
    private static final String KEY_USER = "usuario";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + " ("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_IDPERFIL + " INTEGER, "
                + KEY_USER + " VARCHAR(100)" + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        // Create tables again
        onCreate(db);
    }

    /*CRUD USER*/
    void addContact(User contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IDPERFIL, contact.getIdPerfil()); // Contact Name
        values.put(KEY_USER, contact.getUser()); // Contact Phone

        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        db.close(); // Closing database connection
    }
}
