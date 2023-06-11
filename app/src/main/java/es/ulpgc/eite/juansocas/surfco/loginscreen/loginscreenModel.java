package es.ulpgc.eite.juansocas.surfco.loginscreen;

import android.nfc.Tag;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.juansocas.surfco.data.RepositoryContract;
import es.ulpgc.eite.juansocas.surfco.data.SurfandCoRepository;
import es.ulpgc.eite.juansocas.surfco.data.User;
import es.ulpgc.eite.juansocas.surfco.database.SurfandCODatabase;

public class loginscreenModel implements loginscreenContract.Model{

    public static String TAG = loginscreenModel.class.getSimpleName();
    private RepositoryContract repository;
    boolean verificacion;
    List<User> usuarios = new ArrayList<>();

    public loginscreenModel(RepositoryContract repo) {
        this.repository = repo;
    }

    public boolean verificarcredenciales(String correo, String password, RepositoryContract.GetUsersListCallback callback){
        //List<User> usuarios = new ArrayList<>();

        Log.e(TAG,correo);
        Log.e(TAG,password);



        ///TODO: FALLA, NO LO CONSIGO
        // SEGURO QUE ES UNA GILIPOLLEZ


        repository.getUsers1(new RepositoryContract.GetUsersListCallback() {
            @Override
            public void setUsersList(List<User> users) {
                Log.e(TAG," pruebaaa   " + users.size());

                callback.setUsersList(users);


                repository.getUsersList(callback);
                for(int i = 0; i<users.size(); i++){
                    Log.e(TAG, "Esto es:  " + users.get(i).getNombre());
                    usuarios.add(users.get(i));
                }
            }
        });
        Log.e(TAG," FInall  " + usuarios.size());


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
