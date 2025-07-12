public class Gerente extends Empregado {

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    protected double calcularBonus(Departamento departamento) {
        if(departamento.alcancouMeta()) {
            return this.getSalarioFixo() * 0.2 + (departamento.getValorAtingidoMeta() - departamento.getValorMeta()) * 0.01;
        }
        return 0;
    }
    
}
