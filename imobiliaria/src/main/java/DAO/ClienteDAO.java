package DAO;

import java.util.List;
import Entidade.Cliente;

public interface ClienteDAO{
    void salvar(Cliente cliente);
    List<Cliente> listarTodos(int idCliente);
}
