package es.ulpgc.eite.juansocas.surfco.loginscreen;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;


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
        // TODO: add code if is necessary

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

}
