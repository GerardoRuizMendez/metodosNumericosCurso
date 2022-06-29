
package newton_raphson.Funciones;

import javax.swing.JOptionPane;
import jme.Expresion;
import jme.excepciones.ExpresionException;

/**
 *
 * @author vladi
 */
public class Funcion implements Ifuntion{
    
    private String definicion = "";
    Expresion expresion;

    public Funcion(String definicion) {
        this.definicion = definicion;        
    }                        
    
    @Override
    public double eval(double x) {
        try {
            expresion = new Expresion(this.definicion);            
            expresion.setVariable("x", x);
            return Double.parseDouble(String.valueOf(expresion.evaluar()));
        } catch (ExpresionException ex) {
            JOptionPane.showMessageDialog(null, "Error en la función.", "Error", JOptionPane.ERROR_MESSAGE);
            return Double.NaN; 
        }
    }  
        public boolean contieneX(String cad) {
        for (int i = 0; i < cad.length(); i++) {
            if (cad.substring(i, i + 1).equals("x")) 
                return true;                
        }
        return false;
    }

    
}








