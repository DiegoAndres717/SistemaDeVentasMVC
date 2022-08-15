
package Libreria;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ¡Diego Andres Salas!
 */
public class textFieldEvents {
    public void textKeyPress(KeyEvent evt){
        //declaramos una varable y le asignamos un evento
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && 
                (c != (char) KeyEvent.VK_BACK_SPACE) &
                (c != (char) KeyEvent.VK_SPACE)){
            evt.consume();  
        }
    }
    public void numberKeyPress(KeyEvent evt){
        char ca = evt.getKeyChar();
        if( (ca < '0' || ca > '9') && (ca != (char) KeyEvent.VK_BACK_SPACE)){
            evt.consume();
        }
    }
    public boolean isEmail(String correo){
        Pattern pat = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
       Matcher mat = pat.matcher(correo);
       
       return mat.find();
    }
}
