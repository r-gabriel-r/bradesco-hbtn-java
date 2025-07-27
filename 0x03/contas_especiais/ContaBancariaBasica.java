import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {
    protected String numeracao;
    protected double saldo;
    protected double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0;
    }
    public String getNumeracao() {
        return numeracao;
    }
    public double getSaldo() {
        return saldo;
    }
    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    void depositar(double valor) throws OperacaoInvalidaException{
        if(valor > 0 ) {
            this.saldo+=valor;
        } else {
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        }
    }

    void sacar(double valor) throws OperacaoInvalidaException {
        if(valor > 0) {
            if(this.saldo >= valor) {
                this.saldo-=valor;
            } else {
                throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
            }
        } else {
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        }
    }
    
    double calcularTarifaMensal() {
        return this.saldo * 0.1 > 10 ? 10 : this.saldo * 0.1; 
    }

    double calcularJurosMensal() {
        if(this.saldo > 0) {
            return this.saldo * (this.taxaJurosAnual/12) / 100;
        }
        return 0;
    }

    void aplicarAtualizacaoMensal() {
        this.saldo = this.saldo + this.calcularJurosMensal() - this.calcularTarifaMensal();
    }
}
