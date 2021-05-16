package CalculoSalarioLiquido;

import java.util.ArrayList;
import java.util.List;

public class IRRFService {

    public static List<IRRF> getTabelaDeIrrf() {
        List<IRRF> IRRFTable = new ArrayList<>();
        IRRFTable.add(new IRRF(0.0, 1903.98, 0.0, 0.0));
        IRRFTable.add(new IRRF(1903.99, 2826.65, 7.5, 142.80));
        IRRFTable.add(new IRRF(2826.66, 3751.05, 15.0, 354.80));
        IRRFTable.add(new IRRF(3751.06, 4664.68, 22.5, 636.13));
        IRRFTable.add(new IRRF(4664.68, null, 27.5, 869.36));

        return IRRFTable;
    }

    public static Double calculateIRRF(List<IRRF> IRRFTable, Double salario, Double descontoINSS, int dependentes) {

        Double baseDeCalculo = (salario - descontoINSS) - (dependentes * 189.59);

        for (IRRF irrf : IRRFTable) {
            if (irrf.getBaseDeCalculoAte() != null) {
                if (baseDeCalculo <= irrf.getBaseDeCalculoAte()) {
                    Double aliquota = irrf.getAliquota();
                    Double deducao = irrf.getDeducao();

                    return (baseDeCalculo * (aliquota / 100)) - deducao;
                }
            } else {
                Double aliquota = irrf.getAliquota();
                Double deducao = irrf.getDeducao();

                return (baseDeCalculo * (aliquota / 100)) - deducao;
            }
        }
        return 0.0;
    }
}
