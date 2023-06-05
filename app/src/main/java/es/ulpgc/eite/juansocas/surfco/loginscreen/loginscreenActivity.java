package es.ulpgc.eite.juansocas.surfco.loginscreen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.juansocas.surfco.R;
import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;
import es.ulpgc.eite.juansocas.surfco.firstscreen.firstscreenContract;
import es.ulpgc.eite.juansocas.surfco.firstscreen.firstscreenScreen;

public class loginscreenActivity extends AppCompatActivity implements loginscreenContract.View {

    loginscreenContract.Presenter presenter;
    private loginscreenAdapter listAdapter;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        if(savedInstanceState == null){
            CatalogMediator.resetInstance();
        }
        // do the setup
        loginscreenScreen.configure (this);

        if (savedInstanceState == null){
            presenter.onStart();
        } else{
            presenter.onRestart();
        }

    }

    @Override
    public void injectPresenter(loginscreenContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onLogInButtonPressed() {

    }

    @Override
    public void onResume(){
        super.onResume();
        presenter.onResume();

    }
    @Override
    public void onPause(){
        super.onPause();
        presenter.onPause();

    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        presenter.onDestroy();

    }
}
