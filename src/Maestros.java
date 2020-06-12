public class Maestros {
    private String nombre="";
    private String id="";
    private double salario= 0;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void impresion (){
        System.out.println("Id: "+ id + "\n"+
        "Nombre: " + nombre +"\n"+
        "Salario: " + salario);
    }
}
