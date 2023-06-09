package es.ulpgc.eite.juansocas.surfco.database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import es.ulpgc.eite.juansocas.surfco.data.User;
import es.ulpgc.eite.juansocas.surfco.data.User_Picos;

@Dao
public interface User_PicosDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertarUser_picos(User_Picos user_picos);

    @Query("SELECT * FROM user_picos")
    List<User_Picos> getUser_Picos();


}
