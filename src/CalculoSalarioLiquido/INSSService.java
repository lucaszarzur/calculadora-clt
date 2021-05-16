package CalculoSalarioLiquido;

import java.util.ArrayList;
import java.util.List;

public class INSSService {

    private static final Double TETO_INSS = 751.97;

    public static List<INSS> getTabelaDeInss() {
        List<INSS> inssTable = new ArrayList<>();
        inssTable.add(new INSS(0.0, 1100.0, 7.5));
        inssTable.add(new INSS(1100.01, 2203.48, 9.0));
        inssTable.add(new INSS(2203.49, 3305.22, 12.0));
        inssTable.add(new INSS(3305.23, 6433.57, 14.0));

        return inssTable;
    }

    public static Double calculateInss(List<INSS> inssTable, Double salario) {

        Double faixa1 = 0.0;
        Double faixa2 = 0.0;
        Double faixa3 = 0.0;
        Double faixa4 = 0.0;

        if (salario <= 1100.0) {
            faixa1 = calculateFaixa1(inssTable, salario);

        } else if (salario <= 2203.48) {
            faixa1 = calculateFaixa1(inssTable, null);
            faixa2 = calculateFaixa2(inssTable, salario);

        } else if (salario <= 3305.22) {
            faixa1 = calculateFaixa1(inssTable, null);
            faixa2 = calculateFaixa2(inssTable, null);
            faixa3 = calculateFaixa3(inssTable, salario);

        } else {
            faixa1 = calculateFaixa1(inssTable, null);
            faixa2 = calculateFaixa2(inssTable, null);
            faixa3 = calculateFaixa3(inssTable, null);
            faixa4 = calculateFaixa4(inssTable, salario);

        }

        Double descontoInss = faixa1 + faixa2 + faixa3 + faixa4;

        if (descontoInss > TETO_INSS) {
            descontoInss = TETO_INSS;
        }

        return descontoInss;
    }

    public static Double calculateFaixa1(List<INSS> inssTable, Double salario) {
        INSS tableObject1 = inssTable.get(0);
        if (salario != null) {
            tableObject1.setSalarioAte(salario);
        }
        return (tableObject1.getSalarioAte() - tableObject1.getSalarioDe()) * (tableObject1.getAliquota()/100);
    }

    public static Double calculateFaixa2(List<INSS> inssTable, Double salario) {
        INSS tableObject2 = inssTable.get(1);
        if (salario != null) {
            tableObject2.setSalarioAte(salario);
        }
        return (tableObject2.getSalarioAte() - tableObject2.getSalarioDe()) * (tableObject2.getAliquota()/100);
    }

    public static Double calculateFaixa3(List<INSS> inssTable, Double salario) {
        INSS tableObject3 = inssTable.get(2);
        if (salario != null) {
            tableObject3.setSalarioAte(salario);
        }
        return (tableObject3.getSalarioAte() - tableObject3.getSalarioDe()) * (tableObject3.getAliquota()/100);
    }

    public static Double calculateFaixa4(List<INSS> inssTable, Double salario) {
        INSS tableObject4 = inssTable.get(3);
        if (salario != null) {
            tableObject4.setSalarioAte(salario);
        }
        return (tableObject4.getSalarioAte() - tableObject4.getSalarioDe()) * (tableObject4.getAliquota()/100);
    }
}
