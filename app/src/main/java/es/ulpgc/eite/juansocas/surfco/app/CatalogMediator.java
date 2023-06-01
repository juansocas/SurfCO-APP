package es.ulpgc.eite.juansocas.surfco.app;



import es.ulpgc.eite.juansocas.surfco.firstscreen.firstscreenState;

public class CatalogMediator {

    private static CatalogMediator INSTANCE;

    private es.ulpgc.eite.juansocas.surfco.firstscreen.firstscreenState firstscreenState = new firstscreenState();


    private CatalogMediator() {

    }

    public static void resetInstance() {
        INSTANCE = null;
    }


    public static CatalogMediator getInstance() {
        if(INSTANCE == null){
            INSTANCE = new CatalogMediator();
        }

        return INSTANCE;
    }

    public firstscreenState getFirstscreenState(){
        return firstscreenState;
    }
}
