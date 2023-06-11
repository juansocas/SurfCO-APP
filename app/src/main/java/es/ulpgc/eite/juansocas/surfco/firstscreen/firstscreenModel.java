package es.ulpgc.eite.juansocas.surfco.firstscreen;

import android.util.Log;

import es.ulpgc.eite.juansocas.surfco.data.RepositoryContract;

public class firstscreenModel implements firstscreenContract.Model {
    public static String TAG = firstscreenModel.class.getSimpleName();

    RepositoryContract repository;

    public firstscreenModel(RepositoryContract repository) {
        this.repository = repository;
    }


    @Override
    public void fetchTODODATA_Model(final RepositoryContract.GetUsersListCallback callbackUser, final RepositoryContract.GetPicosListCallback callbackPicos, final RepositoryContract.GetTABLAIntermediaListCallback callbackIntermedia){

        Log.e(TAG,"fetchTODODATA_Model()");

        repository.loadTODO(true, new RepositoryContract.FetchUsersDataCallback() {
            @Override
            public void onUsersDataFetched(boolean error) {
                if(!error){
                    repository.getUsersList(callbackUser);
                }

            }
        }, new RepositoryContract.FetchPicosDataCallback() {
            @Override
            public void onPicosDataFetched(boolean error) {
                if (!error){
                    repository.getPicosList(callbackPicos);
                }

            }
        }, new RepositoryContract.FetchIntermediaDataCallback() {
            @Override
            public void onIntermedaDataFetched(boolean error) {
                if(!error){
                    repository.getIntermediaList(callbackIntermedia);
                }

            }
        });


    }
    @Override
    public void  fetchPicos_Model(final RepositoryContract.GetPicosListCallback callbackPicos){

        Log.e(TAG,"fetchPicos_Model()");

        //repository.cleanALltables(true);
        repository.loadPicos(true, new RepositoryContract.FetchPicosDataCallback() {
            @Override
            public void onPicosDataFetched(boolean error) {
                if (!error){
                    repository.getPicosList(callbackPicos);
                }
            }
        });
    }
}
