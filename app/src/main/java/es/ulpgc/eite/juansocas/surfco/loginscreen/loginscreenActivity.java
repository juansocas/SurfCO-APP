package es.ulpgc.eite.juansocas.surfco.loginscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

import es.ulpgc.eite.juansocas.surfco.R;
import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;
import es.ulpgc.eite.juansocas.surfco.data.Picos;
import es.ulpgc.eite.juansocas.surfco.data.RepositoryContract;
import es.ulpgc.eite.juansocas.surfco.data.SurfandCoRepository;
import es.ulpgc.eite.juansocas.surfco.data.User;
import es.ulpgc.eite.juansocas.surfco.database.PicosDAO;
import es.ulpgc.eite.juansocas.surfco.database.SurfandCODatabase;
import es.ulpgc.eite.juansocas.surfco.database.UserDAO;
import es.ulpgc.eite.juansocas.surfco.menuscreen.MenuScreenActivity;

public class loginscreenActivity extends AppCompatActivity implements loginscreenContract.View {

    loginscreenContract.Presenter presenter;
    private loginscreenAdapter listAdapter;
    EditText correo_introducida, password_introducida;
    Button loginbutton;
    String correo, password;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        correo_introducida = findViewById(R.id.email_text);
        password_introducida = findViewById(R.id.password_text);
        loginbutton = findViewById(R.id.Log_in_button);


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


        //CARGA EL JSON
        presenter.fetchLoginScreenData();

        //presenter.insertarUSER_PRESENTER();




        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    correo = correo_introducida.getText().toString();
                    password = password_introducida.getText().toString();

                    presenter.login(correo, password);


                    //Toast.makeText(loginscreenActivity.this,"Los valores son incorrectos",Toast.LENGTH_LONG).show();

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
    public void onLoginIncorret(){
        correo_introducida.setText("");
        password_introducida.setText("");
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
