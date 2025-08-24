package DAO;

import java.util.List;
import Entidade.Contrato; // ajuste o pacote

public interface ContratoDAO {
    void salvar(Contrato contrato);
    List<Contrato> listarAtivos();
    List<String> clientesComMaisContratos();
    List<Contrato> contratosExpirando30Dias();
}

