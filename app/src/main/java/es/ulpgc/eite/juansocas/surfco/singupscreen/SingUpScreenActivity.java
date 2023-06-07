package es.ulpgc.eite.juansocas.surfco.singupscreen;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.juansocas.surfco.R;
import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;


public class SingUpScreenActivity extends AppCompatActivity implements SingUpScreenContract.View  {

    SingUpScreenContract.Presenter presenter;

    @Override
    public  void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);


        if(savedInstanceState == null){
            CatalogMediator.resetInstance();
        }
        // do the setup
        SingUpScreenScreen.configure(this);

        if (savedInstanceState == null){
            presenter.onStart();
        } else{
            presenter.onRestart();
        }
    }

    @Override
    public void injectPresenter(SingUpScreenContract.Presenter presenter) {
        this.presenter = presenter;

    }
    @Override
    public void onStart(){
        super.onStart();
        presenter.onStart();
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
