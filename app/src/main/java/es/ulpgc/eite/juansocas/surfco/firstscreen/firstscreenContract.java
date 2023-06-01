package es.ulpgc.eite.juansocas.surfco.firstscreen;

import java.lang.ref.WeakReference;

public interface firstscreenContract {
    interface View{
        void injectPresenter(Presenter presenter);
        void navigateToLoginScreen();

        void navigateToSingupScreen();


        void onLoginButtonPressed();

        void onSingUpButtonPressed();
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
        void onLoginButtonPressed();
        void onSingUpButtonPressed();

    }
    interface Model{
        //void fetchFirstScreenData();

    }
}
