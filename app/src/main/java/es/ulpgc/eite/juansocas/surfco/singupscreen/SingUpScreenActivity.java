package es.ulpgc.eite.juansocas.surfco.singupscreen;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.juansocas.surfco.R;
import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;
import es.ulpgc.eite.juansocas.surfco.loginscreen.loginscreenActivity;


public class SingUpScreenActivity extends AppCompatActivity implements SingUpScreenContract.View  {

    SingUpScreenContract.Presenter presenter;


    Button button_singUP;

    EditText firstNameText_introducida, secondNameText_introducida, emailText_introducida, passwordText_introducida, descripcionText_introducida, telefonoText_introducida;
    Spinner listapicos;

    String firstNameText, secondNameText, emailText, passwordText, descripcionText, telefonoText;

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
        firstNameText_introducida = findViewById(R.id.first_name_text);
        secondNameText_introducida = findViewById(R.id.second_name_text);
        emailText_introducida = findViewById(R.id.email_text);
        passwordText_introducida = findViewById(R.id.password_text);
        descripcionText_introducida = findViewById(R.id.description_text);
        telefonoText_introducida = findViewById(R.id.telefono_text);

        listapicos = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item);

        listapicos.setAdapter(adapter);
        listapicos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        button_singUP = findViewById(R.id.signup_button2);

        button_singUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    firstNameText = firstNameText_introducida.getText().toString();
                    secondNameText = secondNameText_introducida.getText().toString();
                    emailText = emailText_introducida.getText().toString();
                    passwordText = passwordText_introducida.getText().toString();
                    descripcionText = descripcionText_introducida.getText().toString();
                    telefonoText = telefonoText_introducida.getText().toString();
                    int telefono = Integer.parseInt(telefonoText);

                    presenter.insertarNuevoUser(firstNameText,secondNameText,emailText,passwordText,descripcionText,telefono,listapicos);

                }catch (Exception e){
                    Toast.makeText(SingUpScreenActivity.this,"error",Toast.LENGTH_LONG).show();
                }

            }
        });




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
