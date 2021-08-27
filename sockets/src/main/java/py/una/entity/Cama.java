package py.una.entity;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Cama {

    String id;
    String estado;
    String hospital;

    /**
     * Contructor basico de un Objeto cama
     *
     * @param id : el id de la cama
     * @param estado : el estado de la cama(ocupado, desocupado)
     * @param hospital : nombre del hospital al que pertenece la cama
     */
    public Cama(String id, String estado, String hospital) {
        this.id = id;
        this.estado = estado;
        this.hospital = hospital;
    }

    /**
     * Contructor de Cama apartir de un String con formato Json
     *
     * @param JSONString cadena String en formato json del objeto
     * @throws Exception error al convertir el json
     */
    public Cama(String JSONString) throws Exception {
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(JSONString.trim());
        JSONObject jsonObject = (JSONObject) obj;

        this.id = (String) jsonObject.get("id");
        this.estado = (String) jsonObject.get("estado");
        this.hospital = (String) jsonObject.get("hospital");
    }

    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
    // </editor-fold>

    /**
     * Metodo de Retorna el mismo objeto pero con formato de Json
     *
     * @return JSON String format
     */
    public String convertJSONString() {

        JSONObject obj = new JSONObject();
        obj.put("id", this.id);
        obj.put("estado", this.estado);
        obj.put("hospital", this.hospital);

        return obj.toJSONString();
    }
}
