package Modelo;

public class CarroSedan extends Vehiculo {
    private String TipoCombustible; //gasolina, diésel o eléctrico.
    private String Transmision; //automática o manual
    public CarroSedan() {
    }
    public String getTipoCombustible() {
        return TipoCombustible;
    }
    public void setTipoCombustible(String tipoCombustible) {
        TipoCombustible = tipoCombustible;
    }
    public String getTransmision() {
        return Transmision;
    }
    public void setTransmision(String transmision) {
        Transmision = transmision;
    }
    
}