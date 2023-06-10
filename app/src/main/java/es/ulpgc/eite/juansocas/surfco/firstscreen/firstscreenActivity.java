package es.ulpgc.eite.juansocas.surfco.firstscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.juansocas.surfco.R;
import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;
import es.ulpgc.eite.juansocas.surfco.loginscreen.loginscreenActivity;
import es.ulpgc.eite.juansocas.surfco.singupscreen.SingUpScreenActivity;


public class firstscreenActivity extends AppCompatActivity implements firstscreenContract.View {


    firstscreenContract.Presenter presenter;
    private  firstscreenAdapter listAdapter;
    Button login_button1;
    Button singup_button1;
    //@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firtscreen);
        //getActionBar().hide();
        login_button1 = findViewById(R.id.login_button);
        singup_button1 = findViewById(R.id.singup_button);

        //presenter.fetchFirstScreenData();






        //Toolbar toolbar = findViewById(R.id.toolbar);
/*
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("prueba");
        }
        listAdapter = new firstscreenAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //RecyclerView recyclerView = findViewById(R);
        //recyclerView.setAdapter(listAdapter);

        // do the setup
        firstscreenScreen.configure(this);

        // do some work
        //presenter.fetchFirstScreendata();



 */

        if(savedInstanceState == null){
            CatalogMediator.resetInstance();
        }
        // do the setup
        firstscreenScreen.configure(this);

        if (savedInstanceState == null){
            presenter.onStart();
        } else{
            presenter.onRestart();
        }

    }


    @Override
    public void injectPresenter(firstscreenContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void navigateToLoginScreen(View view) {
        Intent intent = new Intent(this, loginscreenActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToSingupScreen(View view) {
        Intent intent = new Intent(this, SingUpScreenActivity.class);
        startActivity(intent);

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
