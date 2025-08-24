package Entidade;

import java.time.LocalDate;

public class Contrato {

    public Contrato(int idCliente, int idImovel, LocalDate inicio, LocalDate fim, double valorAluguel) {
    }


    public enum Status{ Ativo, Desativado}

    private Integer idContrato;
    private Integer idCliente;
    private Integer idImovel;
    private double valorAluguel;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Status status = Status.Ativo;

    public Contrato(int idContrato, int idCliente, int idImovel, String dataInicio, String dataFim, double valor){}

    public Contrato(Integer idContrato, Integer idCliente, Integer idImovel, double valorAluguel, LocalDate dataInicio, LocalDate dataFim, Status status){
        this.idContrato = idContrato;
        this.idCliente = idCliente;
        this.idImovel = idImovel;
        this.valorAluguel = valorAluguel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(Integer idImovel) {
        this.idImovel = idImovel;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override public String toString(){
        return String.format("Contrato{id=%d, clienteId=%d, imovelId=%d, R$%.2f, %s -> %s, %s}",
                idContrato, idCliente, idImovel, valorAluguel, dataInicio, dataFim, status);
    }
}
