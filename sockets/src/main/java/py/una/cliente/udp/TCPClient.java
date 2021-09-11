package py.una.cliente.udp;

import java.io.*;
import java.net.*;
import org.json.JSONObject;
import py.una.entity.Cama;

public class TCPClient {

    public static void main(String[] args) throws IOException, Exception {

        Socket unSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            unSocket = new Socket("localhost", 4444);
            // enviamos nosotros
            out = new PrintWriter(unSocket.getOutputStream(), true);

            //viene del servidor
            in = new BufferedReader(new InputStreamReader(unSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Host desconocido");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Error de I/O en la conexion al host");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        while ((fromServer = in.readLine()) != null) {
            System.out.println("Respuesta del Servidor: " + fromServer);
            if (fromServer.equals("Bye")) {
                break;
            }

            // Lee la consola del Cliente
            fromUser = stdIn.readLine();

            if ("1".equals(fromUser)) {
                // ver_estado

                // enviar consulta
                // imprimir respuesta
            } else if ("2".equals(fromUser)) {
                // crear_cama
                String id, estado, hospital;
                
                // Leemos todos los datos de la nueva cama
                System.out.println("Ingrese los sig. datos de la nueva cama");
                System.out.println("Ingrese el ID:");
                id = stdIn.readLine();
                System.out.println("Ingrese el estado:");
                estado = stdIn.readLine();
                System.out.println("Ingrese el hospital al que pertence:");
                hospital = stdIn.readLine();
                
                // instanciamos la nueva cama
                Cama cama = new Cama(id, estado, hospital);

                // Creamos el Json para enviar al servidor
                JSONObject obj = new JSONObject();
                obj.put("tipo_operacion", "2"); // Tipo de operacion
                obj.put("cama", new JSONObject(cama)); // el dato de la cama
                
                // Enviamos Json al servidor
                out.println(obj.toString());

            } else if ("3".equals(fromUser)) {
                // eliminar_cama

            } else if ("4".equals(fromUser)) {
                // ocupar_cama

            } else if ("5".equals(fromUser)) {
                // desocupar_cama

            } else {
                System.out.println("Comando desconocido");
            }

            if (fromUser != null) {
                System.out.println("Cliente: " + fromUser);

                //escribimos al servidor
                out.println(fromUser);
            }
        }

        out.close();
        in.close();
        stdIn.close();
        unSocket.close();
    }
}
