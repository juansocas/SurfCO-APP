package es.ulpgc.eite.juansocas.surfco.catalogo;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.firstscreen.firstscreenContract;

public interface catalogoPicosContract {
    interface View {

        void injectPresenter(Presenter presenter);
    }
    interface Presenter {

        void injectView(WeakReference<catalogoPicosContract.View> view);

        void injectModel(Model model);

        void fetchFirstScreenData();
        void onResume();
        void onStart();
        void onRestart();
        void onDestroy();
        void onPause();

    }
    interface Model {

    }
}
