
package Models;

/**
 *
 * @author ¡Diego Andres Salas!
 */
public class treportes_clientes {
    private int idReporte;
    private double deudaActual;
    private String fechaDeuda;
    private double ultimoPago;
    private String fechaPago;
    private String Ticket;
    private String fechaLimite;
    private int idCliente;

    public treportes_clientes() {
    }
    
    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public double getDeudaActual() {
        return deudaActual;
    }

    public void setDeudaActual(double deudaActual) {
        this.deudaActual = deudaActual;
    }

    public String getFechaDeuda() {
        return fechaDeuda;
    }

    public void setFechaDeuda(String fechaDeuda) {
        this.fechaDeuda = fechaDeuda;
    }

    public double getUltimoPago() {
        return ultimoPago;
    }

    public void setUltimoPago(double ultimoPago) {
        this.ultimoPago = ultimoPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        this.Ticket = ticket;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
}
