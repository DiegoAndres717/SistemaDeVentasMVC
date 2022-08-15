
package Libreria;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author ¡Diego Andres Salas!
 */
public class Calendario {
    private DateFormat dateForma;
    private Date date = new  Date();
    private Calendar c = new GregorianCalendar();
    private final String Fecha;
    private final String Dia;
    private final String Mes;
    private final String Year;
    private final String Hora;
    private String am_pm;

    public Calendario() {
        switch (c.get(Calendar.AM_PM)){
            case 0:
                am_pm = "am";
                break;
            case 1:
                am_pm = "pm";
                break;
        }
        dateForma = new SimpleDateFormat("dd");
        Dia = dateForma.format(date);
        dateForma = new SimpleDateFormat("MM");
        Mes = dateForma.format(date);
        dateForma = new SimpleDateFormat("yyyy");
        Year = dateForma.format(date);
        dateForma = new SimpleDateFormat("dd/MM/YYYY");
        Fecha = dateForma.format(date);
        dateForma = new SimpleDateFormat("hh:mm:ss");
        Hora = dateForma.format(date) + " " + am_pm;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getDia() {
        return Dia;
    }

    public String getMes() {
        return Mes;
    }

    public String getYear() {
        return Year;
    }

    public String getHora() {
        return Hora;
    }
    
    
    
}
