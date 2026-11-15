package Modelo;

public class Vehiculo {
    private String Placa;
    private String Marca;
    private int Modelo;
    private float PrecioDiario;
    private String Estado;

    public Vehiculo() {
    }

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
}
