package es.ulpgc.eite.juansocas.surfco.singupscreen;

import android.util.Log;
import android.widget.Spinner;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;
import es.ulpgc.eite.juansocas.surfco.data.User;

public class SingUpScreenPresenter implements SingUpScreenContract.Presenter {


    private static  String TAG = "SurfCO.SingUpScreenPresenter";
    private WeakReference<SingUpScreenContract.View> view;
    private SingUpScreenState state;
    private SingUpScreenContract.Model model;
    private CatalogMediator mediator;

    public SingUpScreenPresenter(CatalogMediator mediator){
        this.mediator = mediator;
        state = mediator.getSingUpScreenState();
    }
    @Override
    public void onStart() {
        Log.e(TAG, "onStart()");

        // initialize the state
        state = new SingUpScreenState();

        // TODO: add code if is necessary

    }

    @Override
    public void onRestart() {
        Log.e(TAG, "onRestart()");

        // TODO: add code if is necessary

    }

    @Override
    public void onResume() {
        Log.e(TAG, "onResume()");

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
    public void injectView(WeakReference<SingUpScreenContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(SingUpScreenContract.Model model) {
        this.model = model;
    }

    @Override
    public void fetchLoginScreenData() {
        // TODO: add code if is necessary

    }

    @Override
    public void insertarNuevoUser(String firstNameText, String secondNameText, String emailText, String passwordText, String descripcionText, int telefonoText, Spinner ola){
        User user = new User();
        user.setNombre( firstNameText +" "+ secondNameText);
        user.setEmail(emailText);
        user.setPassword(passwordText);
        user.setInfo(descripcionText);
        user.setTelefono(telefonoText);




    }
}
