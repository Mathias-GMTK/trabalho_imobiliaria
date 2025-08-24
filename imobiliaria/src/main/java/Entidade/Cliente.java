package Entidade;

public class Cliente {

    private Integer idCliente;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public Cliente(String nome, String email, String telefone, String s){}

    public Cliente(Integer idCliente, String nome, String cpf, String telefone, String email){
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override public String toString(){
        return String.format("Cliente{id=%d, nome='%s', cpf='%s', telefone='%s', email='%s'}", idCliente, nome, cpf, telefone, email);
    }
}
