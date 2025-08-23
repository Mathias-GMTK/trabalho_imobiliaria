

public class imovel {

    public enum Status{disponivel, indisponivel}

    private int idImovel;
    private String endereco;
    private String tipo;
    private int quartos;
    private double valor;
    private Status status = Status.disponivel;

    public imovel(){}

    public imovel(int idImovel, String endereco, String tipo, int quartos, int valor, Status status){
        this.idImovel = idImovel;
        this.endereco = endereco;
        this.tipo = tipo;
        this.quartos = quartos;
        this.valor = valor;
        this.status = status;
    }

    // Getters e Setters
    public int getId() {
        return idImovel;
    }
    public void setId(int id) {
        this.idImovel = id;
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

    public int getQuartos() {
        return quartos;
    }
    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public Status getStatus(Status status){
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }

    @Override public String toString(){
        return String.format("Imovel{id=%d, %s, %s, tipo=%s, q=%d, b=%d, m2=%.2f, valor=%.2f, status=%s}",
                idImovel, endereco, tipo, quartos, valor, status );
    }


}

