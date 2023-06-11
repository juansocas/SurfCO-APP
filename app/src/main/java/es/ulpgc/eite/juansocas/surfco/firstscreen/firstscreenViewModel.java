package es.ulpgc.eite.juansocas.surfco.firstscreen;

import java.util.List;

import es.ulpgc.eite.juansocas.surfco.data.Picos;
import es.ulpgc.eite.juansocas.surfco.data.User;
import es.ulpgc.eite.juansocas.surfco.data.User_Picos;

public class firstscreenViewModel {
    public List<User> usuarios;
    public List<Picos> olas;
    public List<User_Picos> user_picosintermedia;


    public List<User> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<User> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Picos> getOlas() {
        return olas;
    }

    public void setOlas(List<Picos> olas) {
        this.olas = olas;
    }

    public List<User_Picos> getUser_picosintermedia() {
        return user_picosintermedia;
    }

    public void setUser_picosintermedia(List<User_Picos> user_picosintermedia) {
        this.user_picosintermedia = user_picosintermedia;
    }
}
