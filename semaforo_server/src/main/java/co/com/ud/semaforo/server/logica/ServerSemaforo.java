package co.com.ud.semaforo.server.logica;

import co.com.ud.semaforo.server.dto.PlanSemaforicoDto;
import co.com.ud.semaforo.server.vista.VistaServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

/**
 *
 * @author sierraj
 */
public class ServerSemaforo {
    
    private Logger log = Logger.getLogger(ServerSemaforo.class);
    private int puerto = 1234;
    private int maximoConexiones = 10; // Maximo de conexiones simultaneas
    private ServerSocket servidor = null; 
    private Socket socket = null;
    @Getter
    private VistaServer vistaServer;
    //Objetos usados para leer el archivo Json
    private ReadFileJsonlogica readFileJsonlogica;
    @Setter @Getter
    private PlanSemaforicoDto planSemaforicoDto;
    @Setter
    private int numConexiones;
    
    
    private EnvioMensajesLogica envioMensajesLogica;
    

    public ServerSemaforo() {
        this.envioMensajesLogica = new EnvioMensajesLogica();
        this.numConexiones = 1;
        if(Objects.isNull(vistaServer)){
            this.vistaServer = new VistaServer(this, this.envioMensajesLogica);
            getVistaServer().setTitle("Vista Semaforo");
            getVistaServer().setVisible(true);
        }
        this.readFileJsonlogica = new ReadFileJsonlogica();
    }
    
    
    public void execute(){        
        try {
            // Se crea el serverSocket
            servidor = new ServerSocket(puerto, maximoConexiones);
            // Bucle infinito para esperar conexiones
            for (int i = 0 ;i < numConexiones + 1 ; i++ ) {
                System.out.println("Servidor a la espera de conexiones.");
                socket = servidor.accept();
                System.out.println("Cliente con la IP " + socket.getInetAddress().getHostName() + " conectado.");
                
                ConexionClienteSemaforo cc = new ConexionClienteSemaforo(socket);
                cc.setIdCliente(getPlanSemaforicoDto().getGrpSemaforico().get(i).getNro());
                cc.setNombre(getPlanSemaforicoDto().getGrpSemaforico().get(i).getNombre());
                cc.setSemaforos(getPlanSemaforicoDto().getGrpSemaforico().get(i).getSemaforos());
                cc.start();
                envioMensajesLogica.adicionarConexion(cc);  
                getVistaServer().getConectadosTextArea().append("Cliente " + envioMensajesLogica.getCentralesSemaforicas().size() + " con el id: " + cc.getIdCliente());
                getVistaServer().getConectadosTextArea().append(System.lineSeparator());
            }
            System.out.println("Se han vinculado los grupos necesarios");
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally{
            try {
                socket.close();
                servidor.close();
            } catch (IOException ex) {
                System.err.println("Error al cerrar el servidor: " + ex.getMessage());
            }
        }
    }
}
