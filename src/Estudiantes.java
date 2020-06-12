import java.util.ArrayList;

public class Estudiantes {
    private String nombre="";
    private String id="";
    private double pagosRe= 0;
    private ArrayList<Double> pagos = new ArrayList<>();
    private int grado=0;
    private double deuda = 0;

    public void agregarPago(double pago) {
        pagos.add(pago);
    }
    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public double getPagosRe() {
        return pagosRe;
    }

    public void setPagosRe(double pagosRe) {
        this.pagosRe = pagosRe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void impresion(boolean info){
        System.out.println("Nombre: "+ nombre+ "\n" +
                "ID: "+id+"\n" +
                "Grado: "+grado);
        if (info) {
            if (pagosRe != 0){
                for (int i = 0; i < pagosRe; i++) {
                    System.out.println(pagos.get(i));
                }
            System.out.println("Cantidad de pagos: " + pagosRe);
            }else {
                System.out.println("No ha realizado ningun pago");
            }
            System.out.println("Deuda: "+ deuda);
        }
    }
}
