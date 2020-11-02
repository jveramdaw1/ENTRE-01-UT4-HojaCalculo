
/**
 * Write a description of class hola here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto implements Cloneable{
    private int x;
    private int y;
//constructores ...

    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }
//otras funciones miembro
}