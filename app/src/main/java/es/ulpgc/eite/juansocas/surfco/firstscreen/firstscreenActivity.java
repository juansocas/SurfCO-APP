package es.ulpgc.eite.juansocas.surfco.firstscreen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.juansocas.surfco.R;


public class firstscreenActivity extends AppCompatActivity implements firstscreenContract.View {


    firstscreenContract.Presenter presenter;
    private  firstscreenAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firtscreen);
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




    }


    @Override
    public void injectPresenter(firstscreenContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
