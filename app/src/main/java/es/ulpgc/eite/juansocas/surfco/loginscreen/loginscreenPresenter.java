package es.ulpgc.eite.juansocas.surfco.loginscreen;

import android.content.Intent;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;
import es.ulpgc.eite.juansocas.surfco.data.RepositoryContract;
import es.ulpgc.eite.juansocas.surfco.data.User;


public class loginscreenPresenter implements loginscreenContract.Presenter{

    private static  String TAG = "SurfCO.loginscreenPresenter";
    private WeakReference<loginscreenContract.View> view;
    private loginscreenState state;
    private loginscreenContract.Model model;
    private CatalogMediator mediator;

    public loginscreenPresenter(CatalogMediator mediator){
        this.mediator =mediator;
        state = mediator.getLoginScreenState();
    }



    @Override
    public void injectView(WeakReference<loginscreenContract.View> view) {
        this.view = view;

    }

    @Override
    public void injectModel(loginscreenContract.Model model) {
        this.model = model;
    }

    @Override
    public void fetchLoginScreenData() {
        Log.e(TAG,"fetchLoginScreenData()");
        // TODO: add code if is necessary

        model.fetchUsersListData_MODEL(new RepositoryContract.GetUsersListCallback() {
            @Override
            public void setUsersList(List<User> users) {
                state.Usuarios = users;

            }
        });


       // Log.e(TAG,"El tamaño de usarios son "+  state.Usuarios.size());

    }

    @Override
    public void onResume() {
        Log.e(TAG, "onResume()");
        // TODO: add code if is necessary

    }

    @Override
    public void onStart() {
        Log.e(TAG, "onStart()");

        // initialize the state
        state = new loginscreenState();

        // TODO: add code if is necessary

    }

    @Override
    public void onRestart() {
        Log.e(TAG, "onRestart()");
        // TODO: add code if is necessary

    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy()");

        // TODO: add code if is necessary

    }

    @Override
    public void onPause() {
        Log.e(TAG, "onPause()");

        // TODO: add code if is necessary

    }

    @Override
    public void login(String correo, String password){
        boolean comprueba = model.verificarcredenciales(correo,password);
       if( comprueba == true){
           Log.e(TAG,"Es " + comprueba);

           //view.get().navigateToMenuScreen();

       }else {
           Log.e(TAG, "es incorrecto");
           view.get().onLoginIncorret();
       }
    }
    @Override
    public void insertarUSER_PRESENTER (){
        User user = new User();
        user.setId(1);
        user.setNombre("Juan");
        user.setEmail("juansurf");
        user.setInfo("efrfrf");
        user.setPassword("juan");
        user.setTelefono(928);

        User user3 = new User();
        user3.setId(1111);
        user3.setNombre("Juan Prueba");
        user3.setEmail("ededed");
        user3.setInfo("efrfrf");
        user3.setPassword("rffrfr");
        user3.setTelefono(928);

        model.insertarUser_MODEL(user, new RepositoryContract.OnUsersUpdated() {
            @Override
            public void onUsersUpdated(List<User> users) {
                Log.e(TAG,"Lista de users " + users.size());

            }
        });
        model.insertarUser_MODEL(user3, new RepositoryContract.OnUsersUpdated() {
            @Override
            public void onUsersUpdated(List<User> users) {
                Log.e(TAG,"Lista de users " + users.size());
            }
        });

    }



}
