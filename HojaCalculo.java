
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author -Jhon Vera   
 *  
 */
public class HojaCalculo implements Cloneable
{
    private String nombre;
    private Fila fila1;
    private Fila fila2;
    private Fila fila3;

    /**
     * Constructor  
     * Crea la hoja de cálculo con el nombre indicado 
     * e inicializa las filas al valor null (inicialmente
     * la hoja se crea sin filas)
     */
    public HojaCalculo(String nombre)    {
        this.nombre = nombre;
        this.fila1 = null;
        this.fila1 = null;
        this.fila1 = null;

    }

    /**
     * accesor para el nombre de la hoja
     */
    public String getNombre() {
        return this.nombre;

    }

    /**
     * accesor para la fila1
     */
    public Fila getFila1() {
        return fila1;

    }

    /**
     * accesor para la fila2
     */
    public Fila getFila2() {
        return fila2;

    }

    /**
     * accesor para la fila3
     */
    public Fila getFila3() {
        return fila3;

    }

    /**
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas() {
        int filas=0;
        if(fila1!=null){
            filas=++filas;
        }
        if(fila2!=null){
            filas=++filas;
        }
        if(fila3!=null){
            filas=++filas;
        }
        if(filas==3){
            filas=++filas;
        }
        return filas;
    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        if(getNumeroFilas()==3){
            return true;
        }
        else {return false;}
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        if(fila1==null){
            fila1=fila;
        }
        else{if(fila2==null){
                fila2=fila;
            }
            else{
                if(fila3==null){
                    fila3=fila;
                }
                else{if(getNumeroFilas()>3){
                     System.out.printf("%n"  + "Fila " + getNumeroFilas() + " no se puede añadir en  " + nombre);}
                }
            }
        }
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        Fila fila;
        fila = new Fila( id, fecha, ingresos, gastos);
        this.addFila(fila);
        
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        double totalIngresos=0;
        if(fila1!=null){
            totalIngresos+=fila1.getIngresos();
        }
        else{if(fila2!=null){
                totalIngresos+=fila2.getIngresos();
            }
            else{if(fila3!=null){
                totalIngresos+=fila3.getIngresos();
            }
        }}
        return totalIngresos;

    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double totalGastos=0;
        if(fila1!=null){
            totalGastos+=fila1.getGastos();
        }
        else{if(fila2!=null){
                totalGastos+=fila2.getGastos();
            }
            else{if(fila3!=null){
                totalGastos+=fila3.getGastos();
            }
        }}
        return totalGastos;

    }


    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        double totalBeneficio=0;
        if(fila1!=null){
            totalBeneficio+=fila1.getBeneficio();
        }
        else{if(fila2!=null){
                totalBeneficio+=fila2.getBeneficio();
            }
            else{if(fila3!=null){
                totalBeneficio+=fila3.getBeneficio();
            }
        }}
        return totalBeneficio;
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String fila= (fila1.toString()+fila2.toString()+fila3.toString());
        String patron="%n%s%n%23s%18s%15s%16s";
        String resultado=String.format(patron,nombre,"Fecha","Ingresos","Gastos","Beneficio");
        String linea="--------------------------------------------------------------------------";
        String patron2="%n%s";
        String resultado2=String.format(patron2,linea);
        String patron3="%n%39.2f€%15.2f€%15.2f€";
        String resultado3=String.format(patron3,this.getTotalIngresos(), this.getTotalGastos(), this.getBeneficio());
        return (resultado + fila +resultado2 + resultado3);
    }
      

    

    /**
    * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public Object duplicarHoja() {
       HojaCalculo obj=null;
        try{
            obj=(HojaCalculo)super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        obj.nombre="Duplicado "+nombre;
        return obj;
    }

   
}
