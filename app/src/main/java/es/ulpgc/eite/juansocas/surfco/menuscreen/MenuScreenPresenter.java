package es.ulpgc.eite.juansocas.surfco.menuscreen;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;
import es.ulpgc.eite.juansocas.surfco.loginscreen.loginscreenState;

public class MenuScreenPresenter implements  MenuScreenContract.Presenter{
    private static  String TAG = "SurfCO.MenuScreenPresenter";

    private WeakReference<MenuScreenContract.View> view;

    private MenuScreenState state;
    private MenuScreenContract.Model model;
    private CatalogMediator mediator;

    public MenuScreenPresenter(CatalogMediator mediator) {
        this.mediator = mediator;
        state = mediator.getMenuScreenState();
    }


    @Override
    public void injectView(WeakReference<MenuScreenContract.View> view) {
        this.view = view;

    }

    @Override
    public void injectModel(MenuScreenContract.Model model) {
        this.model = model;

    }

    @Override
    public void onStart() {
        Log.e(TAG, "onStart()");

        // initialize the state
        state = new MenuScreenState();

        // TODO: add code if is necessary

    }

    @Override
    public void onResume() {
        Log.e(TAG, "onResume()");
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
}
