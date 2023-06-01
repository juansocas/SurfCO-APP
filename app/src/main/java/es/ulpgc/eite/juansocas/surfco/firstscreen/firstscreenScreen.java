package es.ulpgc.eite.juansocas.surfco.firstscreen;

import androidx.fragment.app.FragmentActivity;



import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;

public class firstscreenScreen {

    public static void configure(firstscreenContract.View view){

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        CatalogMediator mediator = CatalogMediator.getInstance();

        ///FALTA
        //RepositoryContract repository = CatalogRepository.getInstance(context.get());


        firstscreenContract.Presenter presenter = new firstscreenPresenter(mediator);
        //presenter.injectView(new WeakReference<>(view));
        //presenter.injectModel(model);
        view.injectPresenter(presenter);


        //presenter.injectModel(model);

    }
}
