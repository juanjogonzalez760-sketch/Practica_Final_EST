package Modelo;

public class CamionetaSUV extends Vehiculo {
    private String Traccion; //4x2 o 4x4
    private float CapacidadMaletero; //en litros

    public CamionetaSUV() {
    }

    public String getTraccion() {
        return Traccion;
    }

    public void setTraccion(String traccion) {
        Traccion = traccion;
    }

    public float getCapacidadMaletero() {
        return CapacidadMaletero;
    }

    public void setCapacidadMaletero(float capacidadMaletero) {
        CapacidadMaletero = capacidadMaletero;
    }

    

} 
