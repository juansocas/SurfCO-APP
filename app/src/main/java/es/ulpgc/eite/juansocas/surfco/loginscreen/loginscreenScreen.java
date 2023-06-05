package es.ulpgc.eite.juansocas.surfco.loginscreen;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;

public class loginscreenScreen {
    public static void configure(loginscreenContract.View view) {
        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        CatalogMediator mediator = CatalogMediator.getInstance();

        ///FALTA
        //RepositoryContract repository = CatalogRepository.getInstance(context.get());

        loginscreenContract.Presenter presenter = new loginscreenPresenter(mediator);
        //presenter.injectView(new WeakReference<>(view));
        //presenter.injectModel(model);

        view.injectPresenter(presenter);

        //presenter.injectModel(model);

    }
}
