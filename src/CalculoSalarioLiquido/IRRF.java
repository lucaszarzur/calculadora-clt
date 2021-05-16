package CalculoSalarioLiquido;

public class IRRF {

    private Double baseDeCalculoDe;
    private Double baseDeCalculoAte;
    private Double aliquota;
    private Double deducao;

    public IRRF(Double baseDeCalculoDe, Double baseDeCalculoAte, Double aliquota, Double deducao) {
        this.baseDeCalculoDe = baseDeCalculoDe;
        this.baseDeCalculoAte = baseDeCalculoAte;
        this.aliquota = aliquota;
        this.deducao = deducao;
    }

    public Double getBaseDeCalculoDe() {
        return baseDeCalculoDe;
    }

    public void setBaseDeCalculoDe(Double baseDeCalculoDe) {
        this.baseDeCalculoDe = baseDeCalculoDe;
    }

    public Double getBaseDeCalculoAte() {
        return baseDeCalculoAte;
    }

    public void setBaseDeCalculoAte(Double baseDeCalculoAte) {
        this.baseDeCalculoAte = baseDeCalculoAte;
    }

    public Double getAliquota() {
        return aliquota;
    }

    public void setAliquota(Double aliquota) {
        this.aliquota = aliquota;
    }

    public Double getDeducao() {
        return deducao;
    }

    public void setDeducao(Double deducao) {
        this.deducao = deducao;
    }
}
