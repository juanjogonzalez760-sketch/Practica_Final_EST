package Modelo;

public class CamionetaSUV {
    private String Placa;
    private String Marca;
    private int Modelo;
    private float PrecioDiario;
    private String Estado;


    public String getPlaca() {
        return Placa;
    }

    public String setPlaca(String placa) {
        Placa = placa;
        return Placa;
    }

    public String getMarca() {
        return Marca;
    }

    public String setMarca(String marca) {
        Marca = marca;
        return Marca;
    }

    public int getModelo() {
        return Modelo;
    }

    public int setModelo(int modelo) {
        Modelo = modelo;
        return Modelo;
    }

    public float getPrecioDiario() {
        return PrecioDiario;
    }

    public float setPrecioDiario(float precioDiario) {
        PrecioDiario = precioDiario;
        return PrecioDiario;
    }

    public String getEstado() {
        return Estado;
    }

    public String setEstado(String estado) {
        Estado = estado;
        return Estado;
    }

    private String Traccion;
    private float CapacidadMaletero;

    public CamionetaSUV() {
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
