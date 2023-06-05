package es.ulpgc.eite.juansocas.surfco.singupscreen;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.loginscreen.loginscreenContract;

public interface SingUpScreenContract {
    interface View{
        void injectPresenter(Presenter presenter);

    }
    interface Presenter{

        void onStart();

        void onRestart();
        void onResume();
        void onDestroy();
        void onPause();

        void injectView(WeakReference<View> view);
        void injectModel(Model model);
        void fetchLoginScreenData();
    }
    interface Model{

    }
}
