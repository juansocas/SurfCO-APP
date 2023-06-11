package es.ulpgc.eite.juansocas.surfco.menuscreen;

import android.view.View;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.firstscreen.firstscreenContract;
import es.ulpgc.eite.juansocas.surfco.loginscreen.loginscreenContract;

public interface MenuScreenContract {

    interface View{


        void navigateToPicoCatlogoScreen(android.view.View view);

        void injectPresenter(Presenter presenter);
    }

    interface Presenter{
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

        void onStart();
        void onResume();
        void onRestart();
        void onDestroy();
        void onPause();
    }
    interface Model{

    }
}
