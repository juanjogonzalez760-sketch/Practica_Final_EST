package Modelo;

public class CamionetaSUV extends Vehiculo {
    private String Traccion;
    private float CapacidadMaletero;

    public CamionetaSUV() {
    }

    @Override
    public String getTipo() {
        return "Camioneta SUV";
    }

    @Override
    public String detalleEspecifico() {
        return "Traccion: " + Traccion + " | Maletero: " + CapacidadMaletero + " L";
    }

    public String getTraccion() {
        return Traccion;
    }

    public String setTraccion(String traccion) {
        Traccion = traccion;
        return Traccion;
    }   

    public float getCapacidadMaletero() {
        return CapacidadMaletero;
    }

    public float setCapacidadMaletero(float capacidadMaletero) {
        CapacidadMaletero = capacidadMaletero;
        return CapacidadMaletero;
    }

}