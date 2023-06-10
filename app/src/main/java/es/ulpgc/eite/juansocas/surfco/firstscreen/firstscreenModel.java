package es.ulpgc.eite.juansocas.surfco.firstscreen;

import es.ulpgc.eite.juansocas.surfco.data.RepositoryContract;

public class firstscreenModel implements firstscreenContract.Model {

    RepositoryContract repository;

    public firstscreenModel(RepositoryContract repository) {
        this.repository = repository;
    }
}
