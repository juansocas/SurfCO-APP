package es.ulpgc.eite.juansocas.surfco.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.ulpgc.eite.juansocas.surfco.data.User;

@Dao
public interface UserDAO {




    //TODO: INSERTAR NUEVO USUARIO

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertarUser(User user);



    @Update
    void updateUser(User user);

    @Query("SELECT * FROM usuario")
    List<User> getUsers();


/*
    @Query("SELECT * FROM Usuarios INNER JOIN picos On user_id = picos.user_id WHERE picos.id = :picodd");
    List<User> getUserByPicoId(int picodd);
 */

}
