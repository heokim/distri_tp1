package py.una.entity;

import java.util.Date;

public class Historial {

    Date fechaHora;
    String origenIP;
    String destinoIP;
    String tipoOperacion;

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getOrigenIP() {
        return origenIP;
    }

    public void setOrigenIP(String origenIP) {
        this.origenIP = origenIP;
    }

    public String getDestinoIP() {
        return destinoIP;
    }

    public void setDestinoIP(String destinoIP) {
        this.destinoIP = destinoIP;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

}
