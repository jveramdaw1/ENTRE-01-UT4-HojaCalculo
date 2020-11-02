
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author -   
 *  
 */
public class HojaCalculo
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
            System.out.print(fila1);
        }
        else{if(fila2==null){
                fila2=fila;
                System.out.print(fila2);
            }
            else{
                if(fila3==null){
                    fila3=fila;
                    System.out.print(fila3);
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
        double totalIngresos;
        totalIngresos=fila1.getIngresos()+fila2.getIngresos()+fila3.getIngresos();
        return totalIngresos;

    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double totalGastos;
        totalGastos=fila1.getGastos()+fila2.getGastos()+fila3.getGastos();
        return totalGastos;

    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        double totalBeneficio;
        totalBeneficio=fila1.getBeneficio()+fila2.getBeneficio()+fila3.getBeneficio();
        return totalBeneficio;
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String fila;
        String patron="%n%s%n%23s%15s%15s%15s";
        String resultado=String.format(patron,nombre,"Fecha","Ingresos","Gastos","Beneficio");
         switch(getNumeroFilas()){
            case 1: fila = fila1.toString();
            case 2: fila = fila2.toString(); 
            case 3: fila = fila3.toString();
        }
        String linea="--------------------------------------------------------------------------";
        String patron2="%n%s";
        String resultado2=String.format(patron2,linea);
        System.out.printf(resultado + fila1.toString() + fila2.toString() + fila3.toString()+resultado2);
        String patron3="%n%38.2f%15.2f%15.2f";
        String resultado3=String.format(patron3,this.getTotalIngresos(), this.getTotalGastos(), this.getBeneficio());
        System.out.printf(resultado3);
        return (resultado  + resultado2 + resultado3);
    }
      

    

    /**
    * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
       HojaCalculo duplicadoHoja = new HojaCalculo("Duplicado "+nombre);
       return duplicadoHoja;
    }

   
}
