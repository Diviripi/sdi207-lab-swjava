import org.codehaus.jackson.node.ObjectNode;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.client.ClientBuilder.*;

public class ActualizarMemoriaThread extends Thread {
    Ventana ventana;

    public ActualizarMemoriaThread(Ventana ventana) {
        this.ventana = ventana;
    }
    public void run(){
        ObjectNode respuestaJSON;
        respuestaJSON = newClient()
                .target("http://localhost:3000/memoria")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(ObjectNode.class);

        String memoria = respuestaJSON.get("memoria").toString();
        ventana.actualizarMemoria(memoria);
    }

}
