package Entidade;

public class Imovel {

    private Integer idImovel;
    private String endereco;
    private String tipo;
    private double valor;
    private int quartos;
    private Status status;

    // Enum para status do imóvel
    public enum Status {
        ATIVO,
        INATIVO
    }

    // Construtor vazio
    public Imovel() {
        this.status = Status.INATIVO; // default
    }

    // Construtor completo com ID
    public Imovel(Integer idImovel, String endereco, String tipo, double valor, int quartos, Status status) {
        this.idImovel = idImovel;
        this.endereco = endereco;
        this.tipo = tipo;
        this.valor = valor;
        this.quartos = quartos;
        this.status = status != null ? status : Status.INATIVO;
    }

    // Construtor sem ID (para salvar novos imóveis)
    public Imovel(String endereco, String tipo, double valor, int quartos, Status status) {
        this.endereco = endereco;
        this.tipo = tipo;
        this.valor = valor;
        this.quartos = quartos;
        this.status = status != null ? status : Status.INATIVO;
    }

    // Getters e Setters
    public Integer getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(Integer idImovel) {
        this.idImovel = idImovel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuartos() {
        return quartos;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status != null ? status : Status.INATIVO;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "idImovel=" + idImovel +
                ", endereco='" + endereco + '\'' +
                ", tipo='" + tipo + '\'' +
                ", valor=" + valor +
                ", quartos=" + quartos +
                ", status=" + status +
                '}';
    }
}
