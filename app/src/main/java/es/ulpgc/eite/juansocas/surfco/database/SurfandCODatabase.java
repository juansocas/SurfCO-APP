package es.ulpgc.eite.juansocas.surfco.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import es.ulpgc.eite.juansocas.surfco.data.Picos;
import es.ulpgc.eite.juansocas.surfco.data.User;


@Database(entities = {Picos.class, /*User.class*/}, version = 1)
public abstract class SurfandCODatabase extends RoomDatabase {
    public abstract PicosDAO picosDAO();
    public abstract UserDAO userDAO();
}
