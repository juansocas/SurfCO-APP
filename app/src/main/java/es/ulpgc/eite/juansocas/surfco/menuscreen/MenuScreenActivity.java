package es.ulpgc.eite.juansocas.surfco.menuscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.juansocas.surfco.R;
import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;
import es.ulpgc.eite.juansocas.surfco.catalogo.catalogoPicosActivity;

public class MenuScreenActivity  extends AppCompatActivity implements MenuScreenContract.View{

    MenuScreenContract.Presenter presenter;

    Button verLosPicos_button, verLosLocales_button;
    TextView userText;



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
        userText = findViewById(R.id.nombre_TextView);
        //FALTA recoger el nombre del usuario introducido
        userText.setText("Juan");
        verLosPicos_button = findViewById(R.id.picos_button);
        verLosLocales_button = findViewById(R.id.locales_button);

        verLosPicos_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navigateToPicoCatlogoScreen(view);
            }
        });

        verLosLocales_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
    @Override
    public void navigateToPicoCatlogoScreen(View view) {
        Intent intent = new Intent(this, catalogoPicosActivity.class);
        startActivity(intent);

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
