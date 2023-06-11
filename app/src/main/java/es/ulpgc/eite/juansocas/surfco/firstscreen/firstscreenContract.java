package es.ulpgc.eite.juansocas.surfco.firstscreen;

import android.view.View;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.data.RepositoryContract;

public interface firstscreenContract {
    interface View{
        void injectPresenter(Presenter presenter);
        void navigateToLoginScreen(android.view.View view);
        void navigateToSingupScreen(android.view.View view);
    }
    interface Presenter{
        void injectView(WeakReference<View> view);
        void injectModel(Model model);
        void fetchFirstScreenData();
        void onResume();
        void onStart();
        void onRestart();
        void onDestroy();
        void onPause();


    }
    interface Model{
        void fetchTODODATA_Model(RepositoryContract.GetUsersListCallback callback, RepositoryContract.GetPicosListCallback callback2, RepositoryContract.GetTABLAIntermediaListCallback callback3);

        void  fetchPicos_Model(RepositoryContract.GetPicosListCallback callbackPicos);
        //void fetchFirstScreenData();

    }
}
