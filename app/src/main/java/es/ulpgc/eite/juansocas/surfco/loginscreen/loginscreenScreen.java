package es.ulpgc.eite.juansocas.surfco.loginscreen;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;
import es.ulpgc.eite.juansocas.surfco.data.RepositoryContract;
import es.ulpgc.eite.juansocas.surfco.data.SurfandCoRepository;

public class loginscreenScreen {
    public static void configure(loginscreenContract.View view) {
        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        CatalogMediator mediator = CatalogMediator.getInstance();

        ///FALTA
        RepositoryContract repository = SurfandCoRepository.getInstance(context.get());

        loginscreenModel model = new loginscreenModel(repository);

        loginscreenContract.Presenter presenter = new loginscreenPresenter(mediator);
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);

        view.injectPresenter(presenter);
        presenter.injectModel(model);

    }
}
