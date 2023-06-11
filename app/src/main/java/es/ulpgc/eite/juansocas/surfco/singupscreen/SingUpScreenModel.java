package es.ulpgc.eite.juansocas.surfco.singupscreen;

import android.util.Log;

import java.util.List;

import es.ulpgc.eite.juansocas.surfco.data.RepositoryContract;
import es.ulpgc.eite.juansocas.surfco.data.User;
import es.ulpgc.eite.juansocas.surfco.loginscreen.loginscreenModel;

public class SingUpScreenModel implements  SingUpScreenContract.Model{

    public static String TAG = SingUpScreenModel.class.getSimpleName();

    RepositoryContract repository;

    public SingUpScreenModel(RepositoryContract repository){
        this.repository = repository;
    }

    public void insertarNuevoUser_Model(User user, RepositoryContract.OnUsersUpdated callback){

        Log.e(TAG, "insertarNuevoUser_Model()");
        repository.insertUser(user, new RepositoryContract.OnUsersUpdated() {
            @Override
            public void onUsersUpdated(List<User> users) {
                callback.onUsersUpdated(users);
            }
        });

    }
}
