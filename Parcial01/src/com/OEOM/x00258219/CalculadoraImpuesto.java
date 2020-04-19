package com.OEOM.x00258219;

// Invariantes de la clase:
// always totalRenta >= 0
// always totalISSS >= 0
// always totalAFP >= 0
public final class CalculadoraImpuesto {
    private static double totalRenta = 0;
    private static double totalISSS = 0;
    private static double totalAFP = 0;

    private CalculadoraImpuesto(){}

    public static double calcularPago(Empleado emp){
        double salarioLiquido = 0;
        double renta = 0, afp = 0, isss = 0;

        if(emp instanceof ServicioProfesional){
            renta = 0.1 * emp.getSalario();

            salarioLiquido = emp.getSalario() - renta;
        }else if(emp instanceof PlazaFija){
            afp = 0.0625 * emp.getSalario();
            isss = 0.03 * emp.getSalario();
            double restante = emp.getSalario() - afp - isss;

            if(restante >= 0.01 && restante <= 472)
                renta = 0;
            else if(restante >= 472.01 && restante <= 895.24)
                renta = (0.1)*(restante - 472) + 17.67;
            else if(restante >= 895.25 && restante <= 2038.10)
                renta = (0.2)*(restante - 895.24) + 60;
            else if(restante >= 2038.11)
                renta = (0.3)*(restante - 2038.10) + 299.57;

            salarioLiquido = restante - renta;
            salarioLiquido = Math.round(salarioLiquido * 100.0) / 100.0;
        }

        totalRenta += renta;
        totalRenta = Math.round(totalRenta * 100.0) / 100.0;

        totalISSS += afp;
        totalISSS = Math.round(totalISSS * 100.0) / 100.0;

        totalAFP += isss;
        totalAFP = Math.round(totalAFP * 100.0) / 100.0;

        return salarioLiquido;
    }

    public static String mostrarTotales(){
        return "Total de renta: $"+totalRenta+"\nTotal de ISSS: $"+totalISSS+"\nTotal de AFP: $"+totalAFP;
    }

}