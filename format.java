
/**
 * Write a description of class format here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class format
{
    // instance variables - replace the example below with your own
    private int x;



    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void sampleMethod()
    {
    int edad = 28;
    String nombre = "David";
    String patron = "El nombre de la persona es %s y tiene %d años";
    String resultado = String.format(patron,nombre,edad);   
    System.out.print(resultado);
    }
    
}
