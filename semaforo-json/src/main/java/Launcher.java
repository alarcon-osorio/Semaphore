
import co.com.ud.semaforo.presentacion.SemaforoModel;

/**
 *
 * @author Usuario
 */
public class Launcher {

    private final SemaforoModel miApp;

    public Launcher() {
        miApp = new SemaforoModel();
        miApp.iniciar();
    }

    public static void main(String[] args) {
        new Launcher();
    }
}
    