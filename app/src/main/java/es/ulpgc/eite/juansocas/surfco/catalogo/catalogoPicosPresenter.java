package es.ulpgc.eite.juansocas.surfco.catalogo;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;

public class catalogoPicosPresenter implements  catalogoPicosContract.Presenter{
    private static String TAG = "SurfCO.catalogoPicosPresenter";
    private  WeakReference<catalogoPicosContract.View> view;

    private catalogoPicosState state;

    private catalogoPicosContract.Model model;
    private CatalogMediator mediator;




    public catalogoPicosPresenter(CatalogMediator mediator) {
        this.mediator = mediator;
        state = mediator.getCatalogoPicosState();
    }

    @Override
    public void injectView(WeakReference<catalogoPicosContract.View> view) {
        this.view = view;

    }

    @Override
    public void injectModel(catalogoPicosContract.Model model) {
        this.model = model;
    }

    @Override
    public void fetchFirstScreenData() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {
        state = new catalogoPicosState();

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy()");

        // TODO: add code if is necessary

    }

    @Override
    public void onPause() {

    }
}
