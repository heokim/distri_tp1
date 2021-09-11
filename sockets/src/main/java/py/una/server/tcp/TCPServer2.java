package py.una.server.tcp;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import py.una.entity.Cama;
import py.una.entity.Historial;

public class TCPServer2 {

    // Datos del Servidor
    // Lista de logs
    private static List<Historial> LOG_LIST;
    private static List<Cama> LISTA_CAMA;

    private static Integer SERVER_PORT = 4444;

    public static void main(String[] args) throws IOException {

        LOG_LIST = new ArrayList<>();
        LISTA_CAMA = new ArrayList<>();

        // Agregamos una lista de camas para simular una base de datos
        Cama cama01 = new Cama("1", "desocupado", "hospital 1");
        Cama cama02 = new Cama("2", "desocupado", "hospital 1");
        Cama cama03 = new Cama("3", "desocupado", "hospital 1");
        Cama cama04 = new Cama("4", "desocupado", "hospital 2");
        Cama cama05 = new Cama("5", "desocupado", "hospital 2");
        Cama cama06 = new Cama("6", "desocupado", "hospital 2");
        Cama cama07 = new Cama("7", "desocupado", "hospital 2");
        Cama cama08 = new Cama("8", "desocupado", "hospital 3");
        Cama cama09 = new Cama("9", "desocupado", "hospital 4");
        Cama cama10 = new Cama("10", "desocupado", "hospital 4");
        LISTA_CAMA.add(cama01);
        LISTA_CAMA.add(cama02);
        LISTA_CAMA.add(cama03);
        LISTA_CAMA.add(cama04);
        LISTA_CAMA.add(cama05);
        LISTA_CAMA.add(cama06);
        LISTA_CAMA.add(cama07);
        LISTA_CAMA.add(cama08);
        LISTA_CAMA.add(cama09);
        LISTA_CAMA.add(cama10);

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(SERVER_PORT);
        } catch (IOException e) {
            System.err.println("No se puede abrir el puerto: " + SERVER_PORT);
            System.exit(1);
        }

        System.out.println("Puerto abierto: " + SERVER_PORT);
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Fallo el accept().");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream())
        );

        out.println("Conexcion Exitosa. Bienvenido!");
        String inputLine, outputLine;
        // Servidor escuchando
        while (true) {

            // Lee mensajes del cliente
            inputLine = in.readLine();
            //procesarMensaje(inputLine);
            System.out.println("Mensaje recibido del Cliente: " + inputLine);

            // si leer Bye apaga el socket
            if (inputLine.equals("Bye")) {
                out.println(inputLine);
                break;
            }

            // Envio de datos al cliente
            outputLine = "Eco desdce el server: " + inputLine;
            out.println(outputLine);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

}
