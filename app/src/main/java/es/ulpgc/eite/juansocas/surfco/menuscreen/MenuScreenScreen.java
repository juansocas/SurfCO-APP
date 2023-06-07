package es.ulpgc.eite.juansocas.surfco.menuscreen;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;

public class MenuScreenScreen {
    public static void configure(MenuScreenContract.View view) {


        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        CatalogMediator mediator = CatalogMediator.getInstance();

        ///FALTA
        //RepositoryContract repository = CatalogRepository.getInstance(context.get());

        MenuScreenContract.Presenter presenter = new MenuScreenPresenter(mediator);
        //presenter.injectView(new WeakReference<>(view));
        //presenter.injectModel(model);
        view.injectPresenter(presenter);
        //presenter.injectModel(model);

    }
}
