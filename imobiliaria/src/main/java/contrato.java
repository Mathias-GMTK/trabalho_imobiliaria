

import java.util.Date;
import java.time.LocalDate;

public class contrato {

    public enum Status{ Ativo, ENCERRADO}


    private int idContrato;
    private int idCliente;
    private int idImovel;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double valor;
    private Status status = Status.Ativo;

    public contrato(){}

    public contrato(int idContrato, int idCliente, int idImovel,LocalDate dataInicio, LocalDate dataFim, Status status){
        this.idContrato = idContrato;
        this.idCliente = idCliente;
        this.idImovel = idImovel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
    }


    // Getters e Setters
    public int getId() {
        return idContrato;
    }
    public void setId(int id) {
        this.idContrato = id;
    }

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdImovel() {
        return idImovel;
    }
    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override public String toString(){
        return String.format("Contrato{id=%d, clienteId=%d, imovelId=%d, R$%.2f, %s -> %s, %s}",
        idContrato, idCliente, idImovel, dataInicio, dataFim, valor, status);
    }
}

