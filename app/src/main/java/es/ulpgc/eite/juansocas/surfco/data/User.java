package es.ulpgc.eite.juansocas.surfco.data;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;


import java.util.List;


@Entity(tableName = "usuario")
public class User {

    @PrimaryKey
    @ColumnInfo(name = "id")
    public int id;

    //@ColumnInfo(name = "Nombre")
    public String nombre;

    //@ColumnInfo(name = "Email")
    public String email;

    //@ColumnInfo(name = "Telefono")
    public int telefono;

    //@ColumnInfo(name = "Password")
    public String password;

    //@ColumnInfo(name = "Informacion")
    public String Info;
/*
    @Ignore
    @SerializedName("Picos")
    @ColumnInfo(name = "Picos")
    public List<Picos> picos;

 */


    public User(){

    }

    public User(int id, String nombre, String email, int telefono, String password, String info) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
        Info = info;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }
/*
    public List<Picos> getPicos() {
        return picos;
    }

    public void setPicos(List<Picos> picos) {
        this.picos = picos;
    }

 */
}
