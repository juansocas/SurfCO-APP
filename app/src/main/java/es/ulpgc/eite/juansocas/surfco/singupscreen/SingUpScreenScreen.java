package es.ulpgc.eite.juansocas.surfco.singupscreen;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;

public class SingUpScreenScreen {

    public static void configure(SingUpScreenContract.View view){

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        CatalogMediator mediator = CatalogMediator.getInstance();
        ///FALTA
        //RepositoryContract repository = CatalogRepository.getInstance(context.get());

        SingUpScreenContract.Presenter presenter = new SingUpScreenPresenter(mediator);


        view.injectPresenter(presenter);

    }

}
