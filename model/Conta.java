package Bancogeek.model;
import Bancogeek.helper.Utils;

public class Conta {
    private static int codigo = 1;

    //Atributos
    private int numero;
    private Cliente cliente;
    private Double saldo = 0.0;
    private Double limite = 0.0;
    private Double saldoTotal;

    //Construtor
    public Conta(Cliente cliente){
        this.numero = Conta.codigo;
        this.cliente = cliente;
        Conta.codigo = +1;
        this.atualizaSaldoTotal();
    }

    //Getters e Setters
    public int getNumero() {
        return numero;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public Double getLimite() {
        return limite;
    }
    public void setLimite(Double limite) {
        this.limite = limite;
    }
    public Double getSaldoTotal() {
        return saldoTotal;
    }

    //Metodo para atualizar o saldo total
    private void atualizaSaldoTotal(){
        this.saldoTotal = this.limite + this.saldo;
    }

    //Apresentando os Dados da conta
    public String toString(){
        return "Numero da Conta: " +this.getNumero() +
                "\nCliente: " +this.cliente.getNome() +
                "\nSalto Total: " +Utils.doubleParaString(this.saldoTotal);
    }

    //Metodos
    //Depositar
    public void depositar(Double valor){
        if(valor >0){
            this.saldo = this.getSaldo() + valor;
            this.atualizaSaldoTotal();
            System.out.println("Valor depositado com sucesso !");
        }else{
            System.out.println("Errou ao depositar, tente novamente !");
        }
    }
    //Sacar
    public void sacar(Double valor){
        if(valor > 0 && this.getSaldoTotal() >= valor){
            if(this.getSaldo() >= valor){
            this.saldo = this.getSaldo() - valor;
            this.atualizaSaldoTotal();
            System.out.println("Dinheiro sacado com sucesso");
            }else{
                Double restante = this.getSaldo() - valor;
                this.limite = this.getLimite() + restante;
                this.saldo = 0.0;
                this.atualizaSaldoTotal();
                System.out.println("Saque efetuado com sucesso !") ;
            }
        }else{
            System.out.println("Voce esta tentando sacar um valor inexistente");
        }
    }
    //Tranferencia
    public void tranferir(Conta destino, Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            if(this.getSaldo() >= valor){
                this.saldo = this.getSaldo() - valor;
                destino.saldo = destino.getSaldo() + valor;
                this.atualizaSaldoTotal();
                destino.atualizaSaldoTotal();
                System.out.println("Tranferencia realizada com sucesso!");
            }else{
                Double restante = this.getSaldo() - valor;
                this.limite = this.getLimite() + restante;
                this.saldo = 0.0;
                destino.saldo = destino.getSaldo() + valor;
                this.atualizaSaldoTotal();
                destino.atualizaSaldoTotal();
                System.out.println("Tranferencia realizada com sucesso!");
            }
        }else{
            System.out.println("Tranferencia na realizada, tente novamente");
        }
    }
}
