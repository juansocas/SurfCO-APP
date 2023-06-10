package es.ulpgc.eite.juansocas.surfco.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.ulpgc.eite.juansocas.surfco.data.Picos;

@Dao
public interface PicosDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertarPico( Picos picos);

    @Update
    void updatePico(Picos picos);

    @Query("SELECT * FROM olas")
    List<Picos> getAllPicos();


}
