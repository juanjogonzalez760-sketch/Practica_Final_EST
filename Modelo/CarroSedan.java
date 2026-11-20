package Modelo;

public class CarroSedan extends Vehiculo {
    private String TipoCombustible;
    private String Transmision;

    public CarroSedan() {
    }

    public String getTipoCombustible() {
        return TipoCombustible;
    }

    public String setTipoCombustible(String tipoCombustible) {
        TipoCombustible = tipoCombustible;
        return TipoCombustible;
    }

    public String getTransmision() {
        return Transmision;
    }

    public String setTransmision(String transmision) {
        Transmision = transmision;
        return Transmision;
    }

} 
