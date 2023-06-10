package es.ulpgc.eite.juansocas.surfco.singupscreen;

import es.ulpgc.eite.juansocas.surfco.data.RepositoryContract;

public class SingUpScreenModel implements  SingUpScreenContract.Model{

    RepositoryContract repository;

    public SingUpScreenModel(RepositoryContract repository){
        this.repository = repository;
    }
}
