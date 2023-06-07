package es.ulpgc.eite.juansocas.surfco.menuscreen;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.juansocas.surfco.R;
import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;
import es.ulpgc.eite.juansocas.surfco.loginscreen.loginscreenContract;
import es.ulpgc.eite.juansocas.surfco.loginscreen.loginscreenScreen;

public class MenuScreenActivity  extends AppCompatActivity implements MenuScreenContract.View{

    MenuScreenContract.Presenter presenter;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if(savedInstanceState == null){
            CatalogMediator.resetInstance();
        }
        // do the setup
        MenuScreenScreen.configure (this);

        if (savedInstanceState == null){
            presenter.onStart();
        } else{
            presenter.onRestart();
        }
    }




    @Override
    public void injectPresenter(MenuScreenContract.Presenter presenter) {
        this.presenter = presenter;
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
    public void onBackPressed(View view){
        finish();

    }


}
