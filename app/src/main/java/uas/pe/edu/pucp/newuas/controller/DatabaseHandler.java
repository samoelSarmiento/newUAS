package uas.pe.edu.pucp.newuas.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.model.Specialty;
import uas.pe.edu.pucp.newuas.model.Teacher;


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
    private static final String TABLE_SPECIALTIES = "Specialty";
    private static final String TABLE_TEACHERS = "Teacher";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_IDPERFIL = "idperfil";
    private static final String KEY_USER = "usuario";
    private static final String KEY_ID_SPECIALTY = "idEspecialidad";
    private static final String KEY_CODE = "codigo";
    private static final String KEY_DESC_SPECIALTY = "descripcion";
    private static final String KEY_ID_COORDINATOR = "idCoordinador";
    //teachers
    private static final String KEY_ID_TEACHER = "idProfesor";
    private static final String KEY_ID_SPECIALTY_TEACHER = "idEspecialidad";
    private static final String KEY_ID_USER = "idUsuario";
    private static final String KEY_TEACHER_CODE = "codigo";
    private static final String KEY_NAME = "nombre";
    private static final String KEY_APP = "apepaterno";
    private static final String KEY_APM = "apematerno";
    private static final String KEY_MAIL = "correo";
    private static final String KEY_ROLE = "cargo";
    private static final String KEY_ACTIVE = "vigente";
    private static final String KEY_OFFICE = "oficina";
    private static final String KEY_PHONE = "telefono";
    private static final String KEY_ANEXO = "anexo";
    private static final String KEY_DESC_TEACHER = "descripcion";
    private static final String KEY_ID_ACCREDITOR_USER = "idAcreditador";
    private static final String KEY_ID_TEACHER_USER = "idTeacher";
    private static final String KEY_ID_INVESTIGATOR_USER = "idInvestigador";


    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + " ("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_IDPERFIL + " INTEGER, "
                + KEY_USER + " VARCHAR(100),"
                + KEY_ID_ACCREDITOR_USER + " INTEGER,"
                + KEY_ID_TEACHER_USER + " INTEGER,"
                + KEY_ID_INVESTIGATOR_USER + "INTEGER"
                + ")";


        db.execSQL(CREATE_USERS_TABLE);

        String CREATE_SPECIALTIES_TABLE = "CREATE TABLE " + TABLE_SPECIALTIES + " ("
                + KEY_ID_SPECIALTY + " INTEGER PRIMARY KEY,"
                + KEY_CODE + " VARCHAR(100), "
                + KEY_DESC_SPECIALTY + " VARCHAR(100),"
                + KEY_ID_COORDINATOR + " INTEGER"
                + ")";

        String CREATE_TEACHERS_TABLE = "CREATE TABLE " + TABLE_TEACHERS + " ("
                + KEY_ID_TEACHER + " INTEGER PRIMARY KEY,"
                + KEY_ID_SPECIALTY_TEACHER + " INTEGER, "
                + KEY_ID_USER + " INTEGER,"
                + KEY_TEACHER_CODE + " VARCHAR(100),"
                + KEY_NAME + " VARCHAR(100),"
                + KEY_APP + " VARCHAR(100),"
                + KEY_APM + " VARCHAR(100),"
                + KEY_MAIL + " VARCHAR(100),"
                + KEY_ROLE + " VARCHAR(100),"
                + KEY_ACTIVE + " INTEGER,"
                + KEY_OFFICE + " VARCHAR(100),"
                + KEY_PHONE + " VARCHAR(100),"
                + KEY_ANEXO + " VARCHAR(100),"
                + KEY_DESC_TEACHER + " VARCHAR(100)"
                //+ "FOREIGN KEY("+ KEY_ID_SPECIALTY_TEACHER +") REFERENCES " + TABLE_SPECIALTIES +"("+KEY_ID_SPECIALTY +"),"
                //+ "FOREIGN KEY("+ KEY_ID_USER +") REFERENCES " + TABLE_USERS +"("+KEY_ID +"),"
                + ")";


        //String ADD_ID_TEACHER_TO_SPECIALTY =

        db.execSQL(CREATE_SPECIALTIES_TABLE);
        db.execSQL(CREATE_TEACHERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SPECIALTIES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEACHERS);
        // Create tables again
        onCreate(db);
    }

    public void addSpecialty(Specialty specialty) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID_SPECIALTY, specialty.getIdEspecialidad());
        values.put(KEY_CODE, specialty.getCodigo());
        values.put(KEY_DESC_SPECIALTY, specialty.getDescripcion());

        SQLiteDatabase db2 = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_SPECIALTIES + " WHERE " + KEY_ID_SPECIALTY + " = " + specialty.getIdEspecialidad();
        Cursor cursor = db2.rawQuery(query, null);
        db2.execSQL(query);
        if (cursor.moveToFirst()){
            db.update(TABLE_SPECIALTIES, values, KEY_ID_SPECIALTY + " = " + specialty.getIdEspecialidad(), null);
        }else{
            db.insert(TABLE_SPECIALTIES, null, values);

        }


        db2.close();
        db.close();

    }

    public Specialty getSpecialtyById(Integer specialtyId) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_SPECIALTIES + " WHERE " + KEY_ID_SPECIALTY + " = " + specialtyId;
        Cursor cursor = db.rawQuery(query, null);
        Specialty sp = null;

        if (cursor.moveToFirst()) {
            sp = new Specialty();
            //Specialty sp = new Specialty();
            sp.setIdEspecialidad(Integer.parseInt(cursor.getString(0)));
            sp.setCodigo(cursor.getString(1));
            sp.setDescripcion(cursor.getString(2));
            String query2 = "SELECT * FROM " + TABLE_TEACHERS + " WHERE " + KEY_ID_TEACHER + " = " + cursor.getString(3);
            Cursor cursor2 = db.rawQuery(query2, null);
            Teacher teacher = null;
            if (cursor2.moveToFirst()){
                teacher = new Teacher();
                teacher.setIdDocente(Integer.parseInt(cursor.getString(0)));
                teacher.setIdEspecialidad(Integer.parseInt(cursor.getString(1)));
                teacher.setIdUsuario(Integer.parseInt(cursor.getString(2)));
                teacher.setCodigo(cursor.getString(3));
                teacher.setNombre(cursor.getString(4));
                teacher.setApellidoPaterno(cursor.getString(5));
                teacher.setApellidoMaterno(cursor.getString(6));
                teacher.setCorreo(cursor.getString(7));
                teacher.setCargo(cursor.getString(8));
                teacher.setAnexo(cursor.getString(9));
                sp.setCoordinator(teacher);
            }


            //sp.setCoordinator(null);

        }
        return sp;
    }

/*
    public void addContact(User contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IDPERFIL, contact.getIdPerfil()); // Contact Name
        //values.put(KEY_USER, contact.getUser()); // Contact Phone

        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        db.close(); // Closing database connection
    }

    public boolean checkIfUserExists(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] tableColumns = new String[]{KEY_USER};
        String whereClause = KEY_USER + " = ?";
        String[] whereArgs = new String[]{username};
        String orderBy = KEY_USER;
        //formamos el query
        Cursor cursor = db.query(TABLE_USERS,tableColumns,whereClause,whereArgs,null,null,orderBy);
        boolean exists = cursor != null && cursor.getCount() > 0;
        //Closing connections
        cursor.close();
        db.close();
        //return result
        return exists;
    }

    public User queryUser(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] tableColumns = new String[]{KEY_USER};
        String whereClause = KEY_USER + " = ?";
        String[] whereArgs = new String[]{username};
        String orderBy = KEY_USER;
        //formamos el query
        Cursor cursor = db.query(TABLE_USERS,tableColumns,whereClause,whereArgs,null,null,orderBy);
        User user = null;
        if (cursor != null){
            cursor.moveToFirst();
            int id = cursor.getInt(0);
            int idPerfil = cursor.getInt(1);
            String usnm = cursor.getString(2);
            //user = new User(id,idPerfil,usnm);
        }
        cursor.close();
        db.close();;
        return user;
    }
    */
}
