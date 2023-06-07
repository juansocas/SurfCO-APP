package es.ulpgc.eite.juansocas.surfco.loginscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.juansocas.surfco.R;
import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;
import es.ulpgc.eite.juansocas.surfco.menuscreen.MenuScreenActivity;

public class loginscreenActivity extends AppCompatActivity implements loginscreenContract.View {

    loginscreenContract.Presenter presenter;
    private loginscreenAdapter listAdapter;
    EditText correo_introducida, password_introducida;
    String correo, password;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        correo_introducida = findViewById(R.id.email_text);
        password_introducida = findViewById(R.id.password_text);


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

        Button loginbutton = findViewById(R.id.Log_in_button);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    correo = correo_introducida.getText().toString();
                    password = password_introducida.getText().toString();

                    if(1==1){
                        Toast.makeText(loginscreenActivity.this,"Los valores son correctos",Toast.LENGTH_LONG).show();
                        navigateToMenuScreen(view);

                    }else {
                        Toast.makeText(loginscreenActivity.this,"Los valores son incorrectos",Toast.LENGTH_LONG).show();
                    }

                }catch (Exception e){
                    Toast.makeText(loginscreenActivity.this,"error",Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    @Override
    public void injectPresenter(loginscreenContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void navigateToMenuScreen(View view){
        Intent intent = new Intent(this, MenuScreenActivity.class);
        intent.addCategory(correo);
        intent.addCategory(password);
        startActivity(intent);

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
