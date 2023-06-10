package es.ulpgc.eite.juansocas.surfco.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "olas")

public class Picos {

        @PrimaryKey
        @ColumnInfo(name = "id")
        public int id;

        public String nombre;

        public String imagen;

        public String info;

        public String isla;

        //@ColumnInfo(name = "user_id")
        //private int user_id;


        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getImagen() {
                return imagen;
        }

        public void setImagen(String imagen) {
                this.imagen = imagen;
        }

        public String getInfo() {
                return info;
        }

        public void setInfo(String info) {
                this.info = info;
        }

        public String getIsla() {
                return isla;
        }

        public void setIsla(String isla) {
                this.isla = isla;
        }
}
