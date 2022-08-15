
package Models;

/**
 *
 * @author ¡Diego Andres Salas!
 */
public class TClientes {
    private int ID;
    private String Identificacion;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private String Email;
    private String Telefono;
    private String Fecha;
    private boolean Credito;
    private byte[] Imagen;

    public TClientes() {
        this.Identificacion = "";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.Identificacion = identificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccio) {
        this.Direccion = Direccio;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public boolean isCredito() {
        return Credito;
    }

    public void setCredito(boolean Credito) {
        this.Credito = Credito;
    }

    public byte[] getImagen() {
        return Imagen;
    }

    public void setImagen(byte[] Imagen) {
        this.Imagen = Imagen;
    }
    
    
    
}
