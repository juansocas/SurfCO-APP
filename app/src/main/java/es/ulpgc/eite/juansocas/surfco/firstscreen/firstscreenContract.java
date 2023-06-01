package es.ulpgc.eite.juansocas.surfco.firstscreen;

import java.lang.ref.WeakReference;

public interface firstscreenContract {
    interface View{
        void injectPresenter(Presenter presenter);


    }
    interface Presenter{
        void injectView(WeakReference<View> view);
        void injectModel(Model model);
        void fetchFirstScreenData();

    }
    interface Model{
        //void fetchFirstScreenData();

    }
}
