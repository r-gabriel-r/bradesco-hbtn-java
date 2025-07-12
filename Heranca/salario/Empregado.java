public class Empregado {

    double salarioFixo;

    public Empregado(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }

    protected double calcularBonus(Departamento departamento) {
        if(departamento.alcancouMeta()) {
            return this.getSalarioFixo() * 0.1;
        }
        return 0;
    }

    public double calcularSalarioTotal(Departamento departamento) {
        return this.getSalarioFixo() + this.calcularBonus(departamento);
    }
    
}
