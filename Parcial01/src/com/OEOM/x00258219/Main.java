package com.OEOM.x00258219;

import java.util.Scanner;

public class Main {

    static Scanner in = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        boolean restart = false;

        do{
            try{
                restart = false;
                System.out.println("--Empleado de Servicio Profesional:");

                System.out.print("nombre: ");
                String nombre = in.nextLine();

                if(nombre == null || nombre.isEmpty())
                    throw new isEmptyException("No has escribiste nada");
                else if(esUnNumero(nombre)){
                    throw new invalidInputException("Lo que ingresaste es invalido");
                }


                System.out.print("puesto: ");
                String puesto = in.nextLine();
                System.out.print("salario: ");
                double salario = in.nextDouble(); in.nextLine();
                System.out.print("meses de contrato: ");
                int meses = in.nextInt(); in.nextLine();

                ServicioProfesional sp = new ServicioProfesional(nombre, puesto, salario, meses);

                System.out.println("--Empleado de Plaza Fija:");
                System.out.print("nombre: ");
                String name = in.nextLine();
                if(name == null || name.isEmpty())
                    throw new isEmptyException("No has escribiste nada");
                else if(esUnNumero(name)){
                    throw new invalidInputException("Lo que ingresaste es invalido");
                }
                System.out.print("puesto: ");
                String job = in.nextLine();
                System.out.print("salario: ");
                double salary = in.nextDouble(); in.nextLine();
                System.out.print("numero de extension: ");
                int extension = in.nextInt(); in.nextLine();

                PlazaFija pf = new PlazaFija(name, job, salary, extension);

                System.out.println("El pago respectivo de "+sp.getNombre()+" es de: $"+CalculadoraImpuesto.calcularPago(sp));

                System.out.println("El pago respectivo de "+pf.getNombre()+" es de: $"+CalculadoraImpuesto.calcularPago(pf));

                System.out.println(CalculadoraImpuesto.mostrarTotales());

            }
            catch(isEmptyException | invalidInputException ex){
                System.out.println(ex.getMessage());
                System.out.println("reiniciando...");
                restart = true;
            }

        }while(restart);

    }

    public static boolean esUnNumero(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

}
