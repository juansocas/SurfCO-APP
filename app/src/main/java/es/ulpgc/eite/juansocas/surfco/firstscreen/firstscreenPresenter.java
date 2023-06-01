package es.ulpgc.eite.juansocas.surfco.firstscreen;



import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;

public class firstscreenPresenter implements  firstscreenContract.Presenter{

    private WeakReference<firstscreenContract.View> view;
    private  firstscreenState state;
    private firstscreenContract.Model model;
    private CatalogMediator mediator;


    public firstscreenPresenter(CatalogMediator mediator){
        this.mediator = mediator;
        state = mediator.getFirstscreenState();
    }



    /*
        @Override
        public  void  fetchFirstScreendata(){
            model.fetchFirstScreendata(new );

            @Override
            public void set
        }

     */
    @Override
    public void injectView(WeakReference<firstscreenContract.View> view){
        this.view = view;
    }
    @Override
    public void injectModel(firstscreenContract.Model model){
        this.model = model;
    }

    @Override
    public void fetchFirstScreenData() {

    }
}
