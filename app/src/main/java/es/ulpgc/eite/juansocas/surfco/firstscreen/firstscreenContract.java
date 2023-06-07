package es.ulpgc.eite.juansocas.surfco.firstscreen;

import android.view.View;

import java.lang.ref.WeakReference;

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
        //void fetchFirstScreenData();

    }
}
