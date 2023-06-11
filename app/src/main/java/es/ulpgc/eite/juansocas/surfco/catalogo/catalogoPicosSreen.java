package es.ulpgc.eite.juansocas.surfco.catalogo;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.juansocas.surfco.app.CatalogMediator;
import es.ulpgc.eite.juansocas.surfco.data.RepositoryContract;
import es.ulpgc.eite.juansocas.surfco.data.SurfandCoRepository;

public class catalogoPicosSreen {

    public static void configure(catalogoPicosContract.View view){
        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        CatalogMediator mediator = CatalogMediator.getInstance();

        RepositoryContract repository = SurfandCoRepository.getInstance(context.get());
        catalogoPicosModel model = new catalogoPicosModel(repository);

        catalogoPicosContract.Presenter presenter = new catalogoPicosPresenter(mediator);
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        view.injectPresenter(presenter);
        presenter.injectModel(model);

    }
}
