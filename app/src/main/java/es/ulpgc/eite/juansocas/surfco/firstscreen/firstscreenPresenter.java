package es.ulpgc.eite.juansocas.surfco.firstscreen;



import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;
import es.ulpgc.eite.juansocas.surfco.data.RepositoryContract;

public class firstscreenPresenter implements  firstscreenContract.Presenter{
    private static String TAG = "SurfCO.firstscreenPresenter";

    private WeakReference<firstscreenContract.View> view;
    private  firstscreenState state;
    private firstscreenContract.Model model;
    private CatalogMediator mediator;


    public firstscreenPresenter(CatalogMediator mediator){
        this.mediator = mediator;
        state = mediator.getFirstscreenState();
    }



    /*
        @Override
        public  void  fetchFirstScreendata(){
            model.fetchFirstScreendata(new );

            @Override
            public void set
        }

     */
    @Override
    public void injectView(WeakReference<firstscreenContract.View> view){
        this.view = view;
    }
    @Override
    public void injectModel(firstscreenContract.Model model){
        this.model = model;
    }

    @Override
    public void fetchFirstScreenData() {
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
        state = new firstscreenState();

        // TODO: add code if is necessary

    }

    @Override
    public void onRestart() {
        Log.e(TAG, "onRestart()");

        // TODO: add code if is necessary

    }

    @Override
    public void onPause() {
        Log.e(TAG, "onPause()");

        // TODO: add code if is necessary
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy()");

        // TODO: add code if is necessary
    }





}
