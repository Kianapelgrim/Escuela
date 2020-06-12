import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static Scanner lc = new Scanner(System.in);
    static ArrayList<Estudiantes> estudiantes = new ArrayList<>();
    static ArrayList<Maestros> maestros = new ArrayList<>();
    static ArrayList<Double> ingresos = new ArrayList<>();
    static ArrayList<Double> egresos = new ArrayList<>();

public static void main(String[] args) {
    int resp=0;
    do {
        System.out.println("\t\t\t\tADMINISTRACIÓN\n" +
                "***************************************\n" +
                "1.- Agregar alumnos\n" +
                "2.- Agregar maestros\n" +
                "3.- Mostrar ingresos\n" +
                "4.- Mostrar egresos\n" +
                "5.- Mostrar balance de alumnos\n" +
                "6.- Mostrar balance de escuela\n" +
                "7.- Aumentar deuda a estudiante\n" +
                "8.- Aumentar deuda hacia maestro\n" +
                "9.- Realizar pago a maestro\n" +
                "10.- Reducir deuda de estudiante\n" +
                "11.- Salir\n" +
                "***************************************\n" +
                "¿Qué desea realizar?");
        resp = lc.nextInt();
        switch (resp) {
            case 1:
                agregarAlumno();
                break;
            case 2:
                agregarMaestro();
                break;
            case 3:
                for (int i = 0; i < ingresos.size(); i++) {
                    System.out.println("1.- " + ingresos.get(i));
                }
                break;
            case 4:
                for (int i = 0; i < egresos.size(); i++) {
                    System.out.println("1.- " + egresos.get(i));
                }
                break;
            case 5:
                for (int i = 0; i < estudiantes.size(); i++) {
                    System.out.println(i + ".- ");
                    estudiantes.get(i).impresion(true);
                }
                break;
            case 7:
                deudaAlu();
                break;
            case 10:
                pagoEstu();
                break;
            case 6: for (int i = 0; i < maestros.size(); i++) {
                maestros.get(i).impresion();
            }break;
            case 8: deudaMaestro(); break;
            case 9: pagaMaestro(); break;

        }
    }while (resp!=11);
    }

    private static void pagaMaestro() {
        for (int i = 0; i < maestros.size(); i++) {
            System.out.println(i+".- ");maestros.get(i).impresion();
        }
        System.out.println("Seleccione el numero de maestro");
        int maestro = lc.nextInt();
        if (maestro < maestros.size() || maestro > -1) {
            System.out.println("Introduzca el pago que se le realizara al maestro");
            double paga =lc.nextInt();
            if (paga<= maestros.get(maestro).getSalario()) {
                maestros.get(maestro).setSalario(maestros.get(maestro).getSalario() - paga);
                egresos.add(paga);
            }else{
                System.out.println("Cantidad soprepasa lo que se debe a Maestro");
            }
        }
    }
    private static void deudaMaestro() {
        for (int i = 0; i < maestros.size(); i++) {
            System.out.print(i+".- ");  maestros.get(i).impresion();
        }
        System.out.println("Seleccione el numero de maestro");
        int maestro = lc.nextInt();
        if (maestro < maestros.size() || maestro > -1) {
            System.out.println("Introduzca la cantidad de paga que se le realizara el siguiente mes");
            double pagaFut = lc.nextDouble();
            maestros.get(maestro).setSalario(maestros.get(maestro).getSalario()+pagaFut);
        }else{
            System.out.println("Opción inválida");
        }

    }

    private static void pagoEstu () {
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println(i + ".- ");
            estudiantes.get(i).impresion(false);
        }
        System.out.println("Introduzca el número de estudiante que desea realizar el pago");
        int est = lc.nextInt();
        if (est < estudiantes.size() || est > -1) {
            System.out.println("Introduzca cantidad de pago que realizó");
            double pago = lc.nextDouble();
            if (pago <= estudiantes.get(est).getDeuda()) {
                estudiantes.get(est).setDeuda(estudiantes.get(est).getDeuda() - pago);
                ingresos.add(pago);
                estudiantes.get(est).agregarPago(pago);
            } else {
                System.out.println("El pago no puede ser mayor a la deuda");
            }
        }
    }

    private static void deudaAlu () {
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.print(i + ".- ");
            estudiantes.get(i).impresion(false);
        }
        System.out.println("Introduzca el número de estudiante");
        int est = lc.nextInt();
        if (est < estudiantes.size() || est > -1) {
            System.out.println("Introduzca cantidad de aumento de deuda");
            double deuda = lc.nextDouble();
            deuda = deuda + estudiantes.get(est).getDeuda();
            estudiantes.get(est).setDeuda(deuda);
        } else {
            System.out.println("Introduzca una opción válida");
        }
    }

    private static void agregarAlumno () {
        System.out.println("Introduzca la cantidad de alumnos que desea ingresar");
        int size = lc.nextInt();
        if (size >= 1) {
            String[] nombre = new String[size];
            String[] id = new String[size];
            int[] grado = new int[size];
            for (int i = 0; i < size; i++) {
                System.out.println("Introduzca el nombre del estudiante");
                nombre[i] = lc.next();
                System.out.println("Introduzca id del estudiante");
                id[i] = lc.next();
                System.out.println("Introduzca el grado del estudiante");
                grado[i] = lc.nextInt();
            }
            Estudiantes estudiante = new Estudiantes();
            for (int i = 0; i < size; i++) {
                estudiante.setNombre(nombre[i]);
                estudiante.setGrado(grado[i]);
                estudiante.setId(id[i]);
                estudiantes.add(estudiante);
            }
        } else {
            System.out.println("Debe de agregar una cantidad válida");
        }
    }
    private static void agregarMaestro () {
        System.out.println("Introduzca la cantidad de Maestros que desea ingresar");
        int size = lc.nextInt();
        if (size >= 1) {
            String nombre = "";
            String id = "";
            for (int i = 0; i < size; i++) {
                System.out.println("Introduzca el nombre del maestro");
                nombre = lc.next();
                System.out.println("Introduzca id del maestro");
                id = lc.next();
                Maestros maestro = new Maestros();
                maestro.setNombre(nombre);
                maestro.setId(id);
                maestros.add(maestro);
            }

        } else {
            System.out.println("Debe de agregar una cantidad válida");
        }

}
}