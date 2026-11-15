package Modelo;

public class ContratoRenting {
    private final String IdContrato;
    private final String CedulaCliente;
    private final String PlacaVehiculo;
    private String FechaInicio;
    private String FechaFin;
    private int TotalDias;
    private float ValorTotal;
    private boolean Activo;

    public ContratoRenting(String idContrato, String cedulaCliente, String placaVehiculo) {
        IdContrato = idContrato;
        CedulaCliente = cedulaCliente;
        PlacaVehiculo = placaVehiculo;
        Activo = true;
    }

    public String getIdContrato() {
        return IdContrato;
    }

    public String getCedulaCliente() {
        return CedulaCliente;
    }

    public String getPlacaVehiculo() {
        return PlacaVehiculo;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public String setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
        return FechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public String setFechaFin(String fechaFin) {
        FechaFin = fechaFin;
        return FechaFin;
    }

    public int getTotalDias() {
        return TotalDias;
    }

    public int setTotalDias(int totalDias) {
        TotalDias = totalDias;
        return TotalDias;
    }

    public float getValorTotal() {
        return ValorTotal;
    }

    public float setValorTotal(float valorTotal) {
        ValorTotal = valorTotal;
        return ValorTotal;
    }

    public boolean getActivo() {
        return Activo;
    }

    public boolean setActivo(boolean activo) {
        Activo = activo;
        return Activo;
    }
}
