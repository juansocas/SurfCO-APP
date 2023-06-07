package es.ulpgc.eite.juansocas.surfco.app;



import es.ulpgc.eite.juansocas.surfco.firstscreen.firstscreenState;
import es.ulpgc.eite.juansocas.surfco.loginscreen.loginscreenState;
import es.ulpgc.eite.juansocas.surfco.menuscreen.MenuScreenState;
import es.ulpgc.eite.juansocas.surfco.singupscreen.SingUpScreenState;

public class CatalogMediator {

    private static CatalogMediator INSTANCE;

    private firstscreenState firstscreenState = new firstscreenState();

    private loginscreenState loginscreenstate = new loginscreenState();

    private SingUpScreenState singUpScreenState = new SingUpScreenState();

    private MenuScreenState menuScreenState = new MenuScreenState();


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
    public loginscreenState getLoginScreenState(){
        return loginscreenstate;
    }
    public MenuScreenState getMenuScreenState(){
        return menuScreenState;
    }

    public SingUpScreenState getSingUpScreenState() {
        return singUpScreenState;
    }
}
