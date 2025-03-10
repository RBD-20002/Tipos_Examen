import java.util.ArrayList;
import java.util.Scanner;

public class Calculos {

    ArrayList<Alumno> alumnos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void Menu1() {
        System.out.println("|        OPCIONES       |");
        System.out.println("|1. Mostrar alumnos     |"); /*H*/
        System.out.println("|2. Añadir alumno       |"); /*H*/
        System.out.println("|3. Elimnar alumno      |"); /*H*/
        System.out.println("|4. Media de clase      |"); /*H*/
        System.out.println("|5. Mostrar mejor alumno|");
        System.out.println("|6. Salir               |"); /*H*/
    }

    public void MostarAlumnos() {
        if(alumnos.isEmpty()) {
            System.out.println("No hay alumnos para mostrar");
            return;
        }

        for(int i = 0; i < alumnos.size(); i++) {
            double media = 0;
            media += alumnos.get(i).getNota1()+alumnos.get(i).getNota2()+alumnos.get(i).getNota3()+alumnos.get(i).getNota4();
            System.out.println(alumnos.get(i).toString());
            System.out.println("Media: "+String.format("%.2f",(media/4)));
            System.out.println("--------------------------");
        }
    }

    public void MostrarAlumAbreviado() {
        if(alumnos.isEmpty()) {
            System.out.println("No hay alumnos para mostrar");
            return;
        }
        for(int i = 0; i < alumnos.size(); i++) {
            System.out.println((i+1)+" "+alumnos.get(i).getNombre()+alumnos.get(i).getApellidos());
        }
    }

    public void EliminarAlumno() {
        if(alumnos.isEmpty()) {
            System.out.println("No hay alumnos para eliminar");
            return;
        }
        MostrarAlumAbreviado();

        int indice = -1;
        while(indice < 1 || indice > alumnos.size()) {
            try{
                System.out.println("Elige que alumno quieres elimnar: ");
                indice = Integer.parseInt(sc.nextLine());
                if (indice < 1 || indice > alumnos.size()) {
                    System.out.println("Opcion invalida , vuelve a intentarlo");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa un indice valido");
            }
        }
        alumnos.remove(indice-1);
        System.out.println("Alumno eliminado correctamente");
    }

    public void AnadirAlumno() {
        String nombre = IngresarNombre().toUpperCase();
        String apellidos = IngresarApellidos().toUpperCase();
        double nota1 = IngresarNota();
        double nota2 = IngresarNota();
        double nota3 = IngresarNota();
        double nota4 = IngresarNota();
        alumnos.add(new Alumno(nombre, apellidos, nota1, nota2, nota3, nota4));
    }

    public String IngresarNombre() {
        String nombre = "";
        while(nombre.isBlank()) {
            System.out.println("Ingrese el nombre: ");
            nombre = sc.nextLine();
            if(nombre.isBlank()) {
                System.out.println("El nombre no se puede dejar en blanco");
            }
        } return nombre;
    }

    public String IngresarApellidos() {
        String apellidos = "";
        while(apellidos.isBlank()) {
            System.out.println("Ingrese el apellido: ");
            apellidos = sc.nextLine();
            if(apellidos.isBlank()) {
                System.out.println("El apellido no se puede dejar en blanco");
            }
        } return apellidos;
    }

    public double IngresarNota() {
        double nota = 0;
        while(nota <= 0 || nota > 10) {
            try{
                System.out.println("Ingrese el nota: ");

                nota = Double.parseDouble(sc.nextLine());
                if(nota <= 0 || nota > 10) {
                    System.out.println("La nota no puede ser negativa o ser mayor a 10");
                }

            } catch (NumberFormatException e) {
                System.out.println("EROR: El dato introducido es invalido");
            }
        } return nota;
    }

    public void MediaClase() {
        if(alumnos.isEmpty()) {
            System.out.println("No hay ningun alumno para hacer media");
            return;
        }

        double mediaTotal = 0;
        double media = 0;
        for(int i = 0; i < alumnos.size(); i++) {
            media = (alumnos.get(i).getNota1()+alumnos.get(i).getNota2()+alumnos.get(i).getNota3()+alumnos.get(i).getNota4())/4;
            mediaTotal += media;
        }

        double resultado = mediaTotal / alumnos.size();
        System.out.println("Media de la clase: " + String.format("%.2f",resultado));
    }

    public void MejorAlumno() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay ningún alumno almacenado.");
            return;
        }

        Alumno mejorAlumno = alumnos.get(0);
        double mejorPromedio = (mejorAlumno.getNota1() + mejorAlumno.getNota2() +
                mejorAlumno.getNota3() + mejorAlumno.getNota4()) / 4;

        for (Alumno alumno : alumnos) {
            double promedioActual = (alumno.getNota1() + alumno.getNota2() +
                    alumno.getNota3() + alumno.getNota4()) / 4;
            if (promedioActual > mejorPromedio) {
                mejorAlumno = alumno;
                mejorPromedio = promedioActual;
            }
        }

        System.out.println("\nMejor Alumno:");
        System.out.println(mejorAlumno);
        System.out.println("📊 Promedio: " + String.format("%.2f", mejorPromedio));
    }

}
