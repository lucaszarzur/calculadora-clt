package CalculoSalarioLiquido;

import java.text.DecimalFormat;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /* REFERENCIAS
            https://www.dicionariofinanceiro.com/calculo-salario-liquido/
            https://www.dicionariofinanceiro.com/desconto-inss/
            https://www.dicionariofinanceiro.com/calculadora-de-salario-liquido/
         */

        INSSService inssService = new INSSService();
        IRRFService irrfService = new IRRFService();

        Double salario = 9500.0;

        // INSS
        List<INSS> inssTable = inssService.getTabelaDeInss();

        Double descontoInss = inssService.calculateInss(inssTable, salario);
        printFormattedValue("INSS: ", descontoInss);


        // IRRF
        List<IRRF> irrfTable = irrfService.getTabelaDeIrrf();

        Double descontoIrrf = irrfService.calculateIRRF(irrfTable, salario, descontoInss, 0);
        printFormattedValue("IRRF: ", descontoIrrf);


        // SALARIO LIQUIDO
        printFormattedValue("SALARIO LIQUIDO: ", salario - descontoInss - descontoIrrf);
    }

    private static void printFormattedValue(String what, Double descontoInssIrrf) {
        DecimalFormat df = new DecimalFormat("####.##");
        System.out.println(what + df.format(descontoInssIrrf));
    }
}
