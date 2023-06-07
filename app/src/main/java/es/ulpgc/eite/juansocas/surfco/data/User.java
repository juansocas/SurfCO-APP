package es.ulpgc.eite.juansocas.surfco.data;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class User {

    @PrimaryKey
    @NonNull
    public String id;
    public String nombre;
    public String email;
    public int telefono;
    //public ArrayList<Olas> picos;

    public User(@NonNull String id, String nombre,String email,int telefono){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;


    }


}
