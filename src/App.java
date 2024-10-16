
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cantidadPersonas;

        System.out.println("Ingrese cuántas personas va a tomar: ");
        cantidadPersonas = scanner.nextInt();
        scanner.nextLine(); 
        
        Persona[] personas = new Persona[cantidadPersonas];

        for (int i = 0; i < cantidadPersonas; i++) {
            System.out.println("Ingrese el nombre de la persona " + (i + 1) + ":");
            String nombre = scanner.nextLine(); 
            System.out.println("Ingrese la edad de la persona " + (i + 1) + ":");
            int edad = scanner.nextInt();        
            scanner.nextLine();  
            personas[i] = new Persona(edad, nombre);
        }
        sortByEdad(personas);
        System.out.print("Ingrese la edad de la persona a buscar: ");
        int edadBuscada = scanner.nextInt();
        Persona resultado = busquedaBinaria(personas, edadBuscada);
        if (resultado != null) {
            System.out.println("La persona con la edad " + edadBuscada + " es " + resultado.getNombre());
        } else {
            System.out.println("No se encontró una persona con la edad " + edadBuscada);
        }
    }

    public static void sortByEdad(Persona[] personas) {
        for (int i = 0; i < personas.length; i++) {
            for (int j = i + 1; j < personas.length; j++) {
                if (personas[i].getEdad() > personas[j].getEdad()) {
                    Persona aux = personas[i];
                    personas[i] = personas[j];
                    personas[j] = aux;
                }
            }
        }
    }
    public static Persona busquedaBinaria(Persona[] personas, int edadBuscada) {
        int bajo = 0;
        int alto = personas.length - 1;

        while (bajo <= alto) {
            int centro = (bajo + alto) / 2;
            int valorCentro = personas[centro].getEdad();
            if (valorCentro == edadBuscada) {
                return personas[centro];  
            } else if (valorCentro < edadBuscada) {
                bajo = centro + 1;
            } else {
                alto = centro - 1; 
            }
        }
        return new Persona(-1, "No encontrado");
    }
}

