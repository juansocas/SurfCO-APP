package es.ulpgc.eite.juansocas.surfco.loginscreen;

import android.nfc.Tag;
import android.util.Log;

import java.util.List;

import es.ulpgc.eite.juansocas.surfco.data.RepositoryContract;
import es.ulpgc.eite.juansocas.surfco.data.User;

public class loginscreenModel implements loginscreenContract.Model{

    public static String TAG = loginscreenModel.class.getSimpleName();
    private RepositoryContract repository;
    boolean verificacion;

    public loginscreenModel(RepositoryContract repo) {
        this.repository = repo;
    }

    public boolean verificarcredenciales(String correo, String password){
        repository.getUsers(new RepositoryContract.OnUsergeted() {
            @Override
            public void onUsergeted(List<User> users) {
                for (int i = 0; i< users.size();i++){
                    if(correo == users.get(i).email || password == users.get(i).password){
                        verificacion = true;
                    } else {
                        verificacion = false;
                    }
                }

            }
        });
        return verificacion;

    }

    public void insertarUser_MODEL(User user1, RepositoryContract.OnUsersUpdated callback){

        Log.e(TAG,"insertarUser_MODEL()");
        repository.insertUser(user1, new RepositoryContract.OnUsersUpdated() {

            @Override
            public void onUsersUpdated(List<User> users) {
                callback.onUsersUpdated(users);

            }
        });


    }
    @Override
    public void fetchUsersListData_MODEL(final RepositoryContract.GetUsersListCallback callback){

        Log.e(TAG,"fetchUsersListData_MODEL()");

        repository.loadUsers(true, new RepositoryContract.FetchUsersDataCallback() {
            @Override
            public void onUsersDataFetched(boolean error) {
                if(!error){
                    repository.getUsersList(callback);
                }
            }
        });

        

    }



}
