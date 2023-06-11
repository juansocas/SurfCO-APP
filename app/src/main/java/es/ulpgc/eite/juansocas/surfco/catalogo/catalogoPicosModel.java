package es.ulpgc.eite.juansocas.surfco.catalogo;

import es.ulpgc.eite.juansocas.surfco.data.RepositoryContract;


public class catalogoPicosModel implements  catalogoPicosContract.Model{

    public static String TAG = catalogoPicosModel.class.getSimpleName();
    RepositoryContract repository;

    public catalogoPicosModel(RepositoryContract repository) {
        this.repository = repository;
    }
}
