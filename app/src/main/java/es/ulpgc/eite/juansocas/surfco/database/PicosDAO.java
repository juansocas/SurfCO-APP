package es.ulpgc.eite.juansocas.surfco.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import es.ulpgc.eite.juansocas.surfco.data.Picos;

@Dao
public interface PicosDAO {

    @Query("SELECT * FROM picos")
    List<Picos> getAllPicos();


}
