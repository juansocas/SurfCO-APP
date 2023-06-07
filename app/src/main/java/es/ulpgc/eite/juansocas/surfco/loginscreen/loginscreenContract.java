package es.ulpgc.eite.juansocas.surfco.loginscreen;

import android.view.View;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.firstscreen.firstscreenContract;

public interface loginscreenContract {
    interface View{

        void injectPresenter(Presenter presenter);

        void navigateToMenuScreen(android.view.View view);
    }
    interface Presenter{
        void injectView(WeakReference<View> view);
        void injectModel(Model model);
        void fetchLoginScreenData();
        void onResume();
        void onStart();
        void onRestart();
        void onDestroy();
        void onPause();

    }
    interface Model{

    }
}
