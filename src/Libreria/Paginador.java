
package Libreria;

import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author ¡Diego Andres Salas!
 */
public class Paginador <T> {
    private final List<T> _dataList;
    private final JLabel _label;
    private static int maxReg, _re_por_pagina, pageCount, numPagi = 1;
    public Paginador(List<T> dataList, JLabel label, int re_por_pagina){
        _dataList = dataList;
        _label = label;
        _re_por_pagina = re_por_pagina;
        cargarDatos();
    }
    
    private void cargarDatos(){
        numPagi = 1;
        maxReg = _dataList.size();
        pageCount = (maxReg / _re_por_pagina);
        if ((maxReg % _re_por_pagina) > 0) {
            pageCount += 1;
        }
        _label.setText("Paginas 1/" + pageCount);
        
    }
    public int primero(){
        numPagi = 1;
        _label.setText("Paginas "+ numPagi + "/" + pageCount);
        return numPagi;
    }
    public int anterior(){
        if (numPagi > 1) {
            numPagi -= 1;
            _label.setText("Paginas " + numPagi +"/"+ pageCount);
        }
        return numPagi;
    }
    public int siguiente(){
            if (numPagi == pageCount) {
                numPagi -= 1;
            }
            if (numPagi < pageCount) {
                numPagi += 1;
                _label.setText("Paginas " + numPagi +"/"+ pageCount);

            }
            return numPagi;
    }
    public int ultimo(){
        numPagi = pageCount;
        _label.setText("Paginas " + numPagi +"/"+ pageCount);
        return numPagi;
    }
}
