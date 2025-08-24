
package DAO;

import java.util.List;
import Entidade.Imovel;

public interface ImovelDAO {
    int salvar(Imovel imovel);
    List<Imovel> listarDisponiveis();

    void atualizar(Imovel imovel);

    void excluir(int id);

    List<Imovel> listarTodos(int idImovel);
}
