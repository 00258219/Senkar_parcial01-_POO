package com.OEOM.x00258219;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner in = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        boolean restart;

        do{
            try{
                restart = false;

                //Solicitando los datos para el Empleado de Servicio Profesional
                System.out.println("--Empleado de Servicio Profesional");

                System.out.print("nombre: ");
                String nombre = in.nextLine();
                if(nombre == null || nombre.isEmpty() || nombre.replaceAll("\\s+","").isEmpty())
                    throw new isEmptyException("*No has escrito nada");
                else if(esUnNumero(nombre))
                    throw new invalidInputException("*Lo que ingresaste es invalido");

                System.out.print("puesto: ");
                String puesto = in.nextLine();
                if(puesto == null || puesto.isEmpty() || puesto.replaceAll("\\s+","").isEmpty())
                    throw new isEmptyException("*No has escrito nada");
                else if(esUnNumero(puesto))
                    throw new invalidInputException("*Lo que ingresaste es invalido");

                System.out.print("salario: ");
                double salario = in.nextDouble(); in.nextLine();
                if(salario <= 0.00)
                    throw new invalidInputException("*Lo que ingresaste es invalido");

                System.out.print("meses de contrato: ");
                int meses = in.nextInt(); in.nextLine();
                if(meses <= 0.00)
                    throw new invalidInputException("*Lo que ingresaste es invalido");

                ServicioProfesional sp = new ServicioProfesional(nombre, puesto, salario, meses);

                //Solicitando los datos para el Empleado de Plaza Fija
                System.out.println("--Empleado de Plaza Fija");

                System.out.print("nombre: ");
                String name = in.nextLine();
                if(name == null || name.isEmpty() || name.replaceAll("\\s+","").isEmpty())
                    throw new isEmptyException("*No has escrito nada");
                else if(esUnNumero(name))
                    throw new invalidInputException("*Lo que ingresaste es invalido");

                System.out.print("puesto: ");
                String job = in.nextLine();
                if(job == null || job.isEmpty() || job.replaceAll("\\s+","").isEmpty())
                    throw new isEmptyException("*No has escrito nada");
                else if(esUnNumero(job))
                    throw new invalidInputException("*Lo que ingresaste es invalido");

                System.out.print("salario: ");
                double salary = in.nextDouble(); in.nextLine();
                if(salary <= 0.00)
                    throw new invalidInputException("*Lo que ingresaste es invalido");

                System.out.print("numero de extension: ");
                int extension = in.nextInt(); in.nextLine();
                if(extension <= 0.00)
                    throw new invalidInputException("*Lo que ingresaste es invalido");

                PlazaFija pf = new PlazaFija(name, job, salary, extension);

                System.out.println("El pago respectivo de "+sp.getNombre()+" es de: $"+CalculadoraImpuesto.calcularPago(sp));
                System.out.println("El pago respectivo de "+pf.getNombre()+" es de: $"+CalculadoraImpuesto.calcularPago(pf));

                System.out.println(CalculadoraImpuesto.mostrarTotales());

                System.out.println("PROGRAMA FINALIZADO");
            }
            catch(isEmptyException | invalidInputException ex){
                System.out.println(ex.getMessage());
                System.out.println("reiniciando...");
                restart = true;
            }
            catch(InputMismatchException ex){
                in.nextLine();
                System.out.println("*Entrada erronea");
                System.out.println("reiniciando...");
                restart = true;
            }

        }while(restart);
    }

    public static boolean esUnNumero(String s) {
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

}
