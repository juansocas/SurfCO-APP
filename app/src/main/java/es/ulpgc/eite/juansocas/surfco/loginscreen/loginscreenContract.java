package es.ulpgc.eite.juansocas.surfco.loginscreen;

import android.view.View;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.juansocas.surfco.data.RepositoryContract;
import es.ulpgc.eite.juansocas.surfco.data.User;
import es.ulpgc.eite.juansocas.surfco.firstscreen.firstscreenContract;

public interface loginscreenContract {
    interface View{

        void injectPresenter(Presenter presenter);

        void navigateToMenuScreen(android.view.View view);

        void onLoginIncorret();
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
        void login(String correo, String password);
        void insertarUSER_PRESENTER ();

    }
    interface Model{
        boolean verificarcredenciales(String correo, String password, RepositoryContract.GetUsersListCallback callback);
        void insertarUser_MODEL(User user1, RepositoryContract.OnUsersUpdated callback);

        void fetchUsersListData_MODEL(RepositoryContract.GetUsersListCallback callback);
    }
}
