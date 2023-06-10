package es.ulpgc.eite.juansocas.surfco.singupscreen;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;
import es.ulpgc.eite.juansocas.surfco.data.RepositoryContract;
import es.ulpgc.eite.juansocas.surfco.data.SurfandCoRepository;

public class SingUpScreenScreen {

    public static void configure(SingUpScreenContract.View view){

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        CatalogMediator mediator = CatalogMediator.getInstance();
        ///FALTA
        RepositoryContract repository = SurfandCoRepository.getInstance(context.get());

        SingUpScreenModel model = new SingUpScreenModel(repository);

        SingUpScreenContract.Presenter presenter = new SingUpScreenPresenter(mediator);
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);


        view.injectPresenter(presenter);
        presenter.injectModel(model);

    }

}
