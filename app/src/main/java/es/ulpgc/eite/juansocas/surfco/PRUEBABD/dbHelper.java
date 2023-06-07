package es.ulpgc.eite.juansocas.surfco.PRUEBABD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "preuba.db";
    private static final String TABLA_USERS = "t_user";

    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_USERS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "telefono INTEGER NOT NULL," +
                "password TEXT NOT NULL," +
                "infoMACION TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE Picos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "imagen TEXT NOT NULL," +
                "info TEXT NOT NULL," +
                "isla TEXT NOT NULL)" );

        sqLiteDatabase.execSQL("CREATE TABLE USER_PICOS (" +
                "userId INTEGER," +
                "picoId INTEGER," +
                "FOREIGN KEY (userId) REFERENCES user(id) ON DELETE CASCADE," +
                "FOREIGN KEY (picoId) REFERENCES picos(id) ON DELETE CASCADE," +
                "PRIMARY KEY (userId, picoId))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLA_USERS);

        sqLiteDatabase.execSQL("DROP TABLE Picos");

        sqLiteDatabase.execSQL("DROP TABLE USER_PICOS");

        onCreate(sqLiteDatabase);



    }
}
