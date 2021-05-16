package CalculoSalarioLiquido;

public class INSS {

    private Double salarioDe;
    private Double salarioAte;
    private Double aliquota;

    public INSS(Double salarioDe, Double salarioAte, Double aliquota) {
        this.salarioDe = salarioDe;
        this.salarioAte = salarioAte;
        this.aliquota = aliquota;
    }

    public Double getSalarioDe() {
        return salarioDe;
    }

    public void setSalarioDe(Double salarioDe) {
        this.salarioDe = salarioDe;
    }

    public Double getSalarioAte() {
        return salarioAte;
    }

    public void setSalarioAte(Double salarioAte) {
        this.salarioAte = salarioAte;
    }

    public Double getAliquota() {
        return aliquota;
    }

    public void setAliquota(Double aliquota) {
        this.aliquota = aliquota;
    }
}
