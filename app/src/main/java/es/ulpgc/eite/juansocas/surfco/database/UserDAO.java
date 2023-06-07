package es.ulpgc.eite.juansocas.surfco.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import es.ulpgc.eite.juansocas.surfco.data.User;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM User")
    List<User> obtenerusuarios();

    @Query("SELECT * FROM User WHERE u = :usuario")
    User obtnerUser(String usuario);



}
