package es.ulpgc.eite.juansocas.surfco.firstscreen;

import androidx.fragment.app.FragmentActivity;



import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;
import es.ulpgc.eite.juansocas.surfco.data.RepositoryContract;
import es.ulpgc.eite.juansocas.surfco.data.SurfandCoRepository;

public class firstscreenScreen {

    public static void configure(firstscreenContract.View view){

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        CatalogMediator mediator = CatalogMediator.getInstance();

        ///FALTA
        RepositoryContract repository = SurfandCoRepository.getInstance(context.get());

        firstscreenModel model = new firstscreenModel(repository);


        firstscreenContract.Presenter presenter = new firstscreenPresenter(mediator);
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);

        view.injectPresenter(presenter);
        presenter.injectModel(model);

    }
}
