package principal;

import empleados.CargoMedio;
import empleados.Empleado;
import input.Input;
import output.Output;
import validador.Validador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Principal {

    private static final int AGREGAR = 1;
    private static final int MODIFICAR = 2;
    private static final int LISTAR = 3;
    private static final int ELIMINAR = 4;
    private static final int SALIR = 5;

    private static final int SUBORDINADO = 1;
    private static final int CARGOMEDIO = 2;





    private static int opcionMenu;


    private static HashMap<Integer,Empleado> listaEmpleados;
    private static int contadorEmpleados;
    private static boolean usuarioQuiereSalir;

    private static Output output;
    private static Input input;


    public static void main(String[] args) {
        output = new Output();
        input = new Input();

        listaEmpleados = new HashMap<>();

        usuarioQuiereSalir = false;



        do {
            boolean esValido;
            do {
                mostrarMenu();
                obtenerOpcionMenu();
                esValido = validarOpcionUsuario();
            } while (!esValido);


            ejecutarOpcionMenu(opcionMenu);

        } while (!usuarioQuiereSalir);

    }

    private static void mostrarMenu() {
        output.mostrarMenu();
    }
    private static void mostrarMenuEmpleado() {
        output.mostrarMenuEmpleado();
    }

    private static void obtenerOpcionMenu() {

        opcionMenu = input.obtenerOpcionMenu();


    }

    private static boolean validarOpcionUsuario() {

        Validador datoValido = new Validador();
        boolean esValido = datoValido.validarOpcionMenu(opcionMenu);

        return esValido;
    }

    private static void ejecutarOpcionMenu(int opcionMenu) {

        switch (opcionMenu) {

            case AGREGAR -> {


                solicitarDatosempleado();

            }
            case MODIFICAR -> {
                modificarUsuario();

            }
            case LISTAR -> {

                for (int i = 1 ; i<= contadorEmpleados;i++){

                    if (listaEmpleados.get(i)== null){

                    }else {
                        System.out.println(i + " " +listaEmpleados.get(i));
                    }




                }

                System.out.println(listaEmpleados.keySet());

            }
            case ELIMINAR -> {
                eliminarUsuario();



            }
            case SALIR -> {
                usuarioQuiereSalir = true;
            }

        }

    }



    private static void solicitarDatosempleado() {

        mostrarMenuEmpleado();


        int opcionEmpleado = input.obtenerInt();


        switch (opcionEmpleado){

            case SUBORDINADO->{
                output.mostrarMensajeNombre();
                String nombre = input.obtenerString();
                output.mostrarMensajeEdad();
                int edad = input.obtenerInt();
                output.mostrarMensajeFecha();
                String fechaAlta = input.obtenerString();
                output.mostrarMensajeSalario();
                double salario = input.obtenerDouble();
                contadorEmpleados ++;
                listaEmpleados.put(contadorEmpleados,new Empleado(nombre,edad,fechaAlta,salario));
            }
            case CARGOMEDIO->{
                output.mostrarMensajeNombre();
                String nombre = input.obtenerString();
                output.mostrarMensajeEdad();
                int edad = input.obtenerInt();
                output.mostrarMensajeFecha();
                String fechaAlta = input.obtenerString();
                output.mostrarMensajeSalario();
                double salario = input.obtenerDouble();
                output.mostrarMensajeComision();
                int comision = input.obtenerInt();
                contadorEmpleados ++;
                listaEmpleados.put(contadorEmpleados,new CargoMedio(nombre,edad,fechaAlta,salario,comision));
            }
        }



    }

    private static void modificarUsuario() {



        for (int i = 1 ; i<= contadorEmpleados;i++){

            if (listaEmpleados.get(i)== null){

            }else {
                output.mostrarEmpleadoModificar(listaEmpleados.get(i).getNombreCompleto(), listaEmpleados.get(i).getSalario());
            }

        }

        output.mostrarMensajeNombre();
        String nombre = input.obtenerString();
        output.mostrarMensajeSalarioActualizado();
        double salarioActualizado = input.obtenerDouble();
        int i =0;
        do {
            i++;
        }while (!listaEmpleados.get(i).getNombreCompleto().equals(nombre));

        listaEmpleados.get(i).setSalario(salarioActualizado);

    }

    private static void eliminarUsuario(){


        for (int i = 0 ; i<= contadorEmpleados;i++){

            if (listaEmpleados.get(i)== null){

            }else {
                output.mostrarEmpleadoEliminar(i,listaEmpleados.get(i).getNombreCompleto());
            }

        }

        System.out.println("ingrese numero de empleado a eliminar");
        int numeroEmpleadoAEliminar = input.obtenerInt();
        listaEmpleados.remove(numeroEmpleadoAEliminar);


    }
}
