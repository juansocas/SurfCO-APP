package es.ulpgc.eite.juansocas.surfco.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        tableName = "picos"
        /*
        foreignKeys = @ForeignKey(
                entity = User.class,
                parentColumns = "id",
                childColumns = "user_id",
                onDelete = CASCADE
        )

         */


)

public class Picos {

        @PrimaryKey
        public int id;

        public String nombre;

        public String imagen;

        public String info;

        public String isla;

        //@ColumnInfo(name = "user_id")
        //private int user_id;
}
