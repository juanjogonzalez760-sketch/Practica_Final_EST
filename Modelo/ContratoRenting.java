public class ContratoRenting {
    private final String idContrato;
    private final String CedulaCliente;
    private final String PlacaVehiculo;
    private String FechaInicio;
    private String FechaFin;
    private int TotalDias;
    private float ValorTotal;

    public ContratoRenting(String idContrato, String CedulaCliente, String PlacaVehiculo, String FechaInicio, String FechaFin, int TotalDias, float ValorTotal) {
        this.idContrato = idContrato;
        this.CedulaCliente = CedulaCliente;
        this.PlacaVehiculo = PlacaVehiculo;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.TotalDias = TotalDias;
        this.ValorTotal = ValorTotal;
    }

    public String getIdContrato() {
        return idContrato;
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

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String fechaFin) {
        FechaFin = fechaFin;
    }

    public int getTotalDias() {
        return TotalDias;
    }

    public void setTotalDias(int totalDias) {
        TotalDias = totalDias;
    }

    public float getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(float valorTotal) {
        ValorTotal = valorTotal;
    }

    
}
