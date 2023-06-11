package es.ulpgc.eite.juansocas.surfco.catalogo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.juansocas.surfco.R;
import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;
import es.ulpgc.eite.juansocas.surfco.menuscreen.MenuScreenScreen;

public class catalogoPicosActivity extends AppCompatActivity implements catalogoPicosContract.View {

    private static String TAG = "SurfCO.catalogoPicosActivity";
    catalogoPicosContract.Presenter presenter;

    Button lanzarote, furteventura, grancanaria, tenerife;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
        if(savedInstanceState == null){
            CatalogMediator.resetInstance();
        }
        // do the setup
        catalogoPicosSreen.configure (this);

        if (savedInstanceState == null){
            presenter.onStart();
        } else{
            presenter.onRestart();
        }

        lanzarote = findViewById(R.id.Lanzarote_button);
        furteventura = findViewById(R.id.Fuerteventura_button);
        grancanaria = findViewById(R.id.Gran_Canaria_button);
        tenerife = findViewById(R.id.Tenerife_button);

        lanzarote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    @Override
    public void injectPresenter(catalogoPicosContract.Presenter presenter) {
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




}
