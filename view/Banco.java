package Bancogeek.view;
import java.util.ArrayList;
import java.util.Scanner;
import Bancogeek.helper.Utils;
import Bancogeek.model.Cliente;
import Bancogeek.model.Conta;

public class Banco {
    //Iniciando as importações
    static String nome = "Banco Geek";
    static Scanner ler = new Scanner(System.in);
    static ArrayList<Conta>contas;
    public static void main(String[] args) {
        Banco.contas = new ArrayList<Conta>();
        Banco.menu();
    }

    //Menu
    public static void menu(){
        int opcao = 0;
        System.out.println();
        System.out.println("========= "+Banco.nome+" ========");
        System.out.println("Selecione uma opcao no menu!");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Efetuar saque");
        System.out.println("3 - Efetuar deposito");
        System.out.println("4 - Efetuar Tranferencia");
        System.out.println("5 - Lista Contas");
        System.out.println("6 - Sair");

        try{
            opcao = Integer.parseInt(Banco.ler.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Informe uma opcao valida");
            Utils.pausar(1);
            Banco.menu();
        }

        //
        switch (opcao) {
            case 1:
                Banco.criarConta();
                break;
            case 2:
                Banco.efetuarSaque();
                break;
            case 3:
                Banco.efetuarDeposito();
                break;
            case 4:
                Banco.efetuarTransferencia();
                break;
            case 5:
                Banco.listarContas();
                break;
            case 6:
                System.out.println("Obrigado pela preferencia, volte sempre!");
                System.exit(0);
                Utils.pausar(3);
            default:
                System.out.println("Digite uma opcao valida");
                Utils.pausar(2);
                Banco.menu();
                break;
        }while (opcao != 0); 
    }
    
    //Criando os metodos;
    //Criar conta
    public static void criarConta(){
        System.out.println("Vamos começar...");
        System.out.println("Atencao na hora de informa seu dados");
        Utils.pausar(3);
        System.out.println("Qual o seu nome !");
        String nome = Banco.ler.nextLine();
        System.out.println("Qual o seu CPF");
        String cpf = Banco.ler.nextLine();
        System.out.println("Qual o seu Gmail");
        String gmail = Banco.ler.nextLine();
        System.out.println("Qual sua Data de Nascimento");
        String dataNascimento = Banco.ler.nextLine(); 

        //Instaciando o objeto cliente
        Cliente cliente = new Cliente(nome, cpf, Utils.StringParaDate(dataNascimento), gmail);
        //Instaciando o objeto conta do cliente
        Conta conta = new Conta(cliente);
        //Adicionando a conta
        Banco.contas.add(conta);

        //Resultado;
        System.out.println();
        System.out.println("------------------------");
        System.out.println("Conta criada com sucesso");
        System.out.println(conta);
        System.out.println("------------------------");
        System.out.println();
        Utils.pausar(3);
        Banco.menu();
    
    }
    //Efetuar um Saque
    public static void efetuarSaque(){
        System.out.println("Informe o numero da conta");
        int numero = Banco.ler.nextInt();
        
        //Sistema de buscar
        Conta conta = Banco.buscarContaPorNumero(numero);

        //Condiçao para saque
        if(conta != null){
            System.out.println("Informe o valor para saque");
            Double valor = Banco.ler.nextDouble();
            conta.sacar(valor);
        }else{
            System.out.println("Essa conta nao existe");         
        }
        Utils.pausar(3);
        Banco.menu();
    }
    //Efetuar um saque
    public static void efetuarDeposito(){
        System.out.println("Informe o numero da conta!");
        int numero = Banco.ler.nextInt();

        //Sistema de busca
        Conta conta = Banco.buscarContaPorNumero(numero);

        //Condição de deposito
        if(conta != null){
            System.out.println("Qual o valor que o senhor(a) deseja depositar !");
            Double valor = Banco.ler.nextDouble();
            conta.depositar(valor);
        }else{
            System.out.println("Conta nao encontrada !");
        }
        Utils.pausar(3);
        Banco.menu();
    }
    //Efetuar uma Tranferencia
    public static void efetuarTransferencia(){
        System.out.println("Informe o numero da sua conta");
        int numero_o = Banco.ler.nextInt();
        
        //Sistema de busca
        Conta conta_o = Banco.buscarContaPorNumero(numero_o);

        //Condiçao
        if(conta_o != null){
            System.out.println("Qual o numero da conta que recebera o valor");
            int numero_d = Banco.ler.nextInt();

            //Sistema de bunca
            Conta conta_d = Banco.buscarContaPorNumero(numero_d);

            //Condição de tranferencia
            if(conta_d != null){
                System.out.println("Qual o valor quee deseja trasnferir !");
                Double valor = Banco.ler.nextDouble();    
                conta_o.tranferir(conta_d, valor);
                
                System.out.println("Valor trasferido com sucesso !");
                Utils.pausar(3);
                Banco.menu();
            }else{
                //Caso a donta destino nao exista
                System.out.println("Essa conta nao existe");
                Utils.pausar(3);
                Banco.menu();
            }
        }else{
            //Caso a conta origem nao exista
            System.out.println("Essa conta nao existe");
            Utils.pausar(3);
            Banco.menu();
        }
    }
    //Listar contas cadastradas
    public static void listarContas(){
        if(Banco.contas.size() > 0){
            System.out.println("Contas cadastradas !");
            System.out.println();
            for(Conta C: Banco.contas){
                System.out.println(C);
                System.out.println();
            }
        }else{
            System.out.println("Nenhuma conta cadastrada");
            Utils.pausar(3);
            Banco.menu();
        }
    }
    //Buscar contas
    public static Conta buscarContaPorNumero(int numero){
        Conta c = null;
        if(Banco.contas.size() > 0){
            for(Conta conta : Banco.contas){
                if(conta.getNumero() == numero){
                    c = conta;
                }
            }
        }
        return c;
    }
}


