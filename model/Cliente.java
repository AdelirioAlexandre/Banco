package Bancogeek.model;
import java.util.Date;
public class Cliente {
    public static int contador = 1;

    //Atributos
    private int codigo;
    private String nome;
    private String cpf;
    private String gmail;
    private Date dataNascimento;
    private Date dataCadastro;

    

    public Cliente(String nome, String cpf, Date dataNascimento, String gmail) {
        this.codigo = Cliente.contador;
        this.nome = nome;
        this.gmail = gmail;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = new Date();
        Cliente.contador += 1;
    }
    //Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getGmail(){
        return gmail;
    }
    public void setGmail(String gmail){
        this.gmail = gmail;
    }
    public int getCodigo() {
        return codigo;
    }
    public Date getDataCadastro() {
        return dataCadastro;
    }

    //Apresentação do objeto
    public String toString(){
        return "Codigo " +getCodigo() +
                "\nNome: " + getNome() +
                "\nCPF: " + getDataNascimento() +
                "\nGmail: " + getGmail() +
                "\nData de Nascimento: " +getDataNascimento() +
                "Data de Cadastro: " +getDataCadastro();
    }
}
