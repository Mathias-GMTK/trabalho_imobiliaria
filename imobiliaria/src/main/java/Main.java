import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import Entidade.Imovel;
import Entidade.Cliente;
import Entidade.Contrato;
import DAO.ImovelDAO;
import DAO.ImovelDAOImpl;
import DAO.ClienteDAO;
import DAO.ContratoDAO;
import DAO.ContratoDAOImpl;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ClienteDAO clienteDAO = new ClienteDAO() {
            @Override
            public void salvar(Cliente cliente) {

            }

            @Override
            public List<Cliente> listarTodos(int idCliente) {
                return List.of();
            }
        };
        ImovelDAO imovelDAO = new ImovelDAOImpl();
        ContratoDAO contratoDAO = new ContratoDAOImpl();

        int opcao;
        do {
            System.out.println("\n===== SISTEMA IMOBILIÁRIA =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Imóvel");
            System.out.println("3 - Cadastrar Contrato");
            System.out.println("4 - Listar Imóveis Disponíveis");
            System.out.println("5 - Listar Contratos Ativos");
            System.out.println("6 - Clientes com mais contratos");
            System.out.println("7 - Contratos expirando em 30 dias");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1: // Cadastrar Cliente
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    Cliente cliente = new Cliente(nome, cpf, telefone, email);
                    clienteDAO.salvar(cliente);
                    System.out.println("✅ Cliente cadastrado com sucesso!");
                    break;

                case 2: // Cadastrar Imóvel
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();
                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();
                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();
                    System.out.print("Número de quartos: ");
                    int quartos = sc.nextInt();
                    sc.nextLine(); // limpar buffer

                    Imovel imovel = new Imovel(endereco, tipo, valor, quartos, Imovel.Status.ATIVO);
                    imovelDAO.salvar(imovel);
                    System.out.println("✅ Imóvel cadastrado com sucesso!");
                    break;

                case 3: // Cadastrar Contrato
                    try {
                        System.out.print("ID do Cliente: ");
                        int idCliente = sc.nextInt();
                        System.out.print("ID do Imóvel: ");
                        int idImovel = sc.nextInt();
                        sc.nextLine(); // limpar buffer

                        // Validação de existência
                        if (clienteDAO.listarTodos(idCliente) == null) {
                            System.out.println("❌ Cliente não encontrado!");
                            break;
                        }
                        if (imovelDAO.listarTodos(idImovel) == null) {
                            System.out.println("❌ Imóvel não encontrado!");
                            break;
                        }

                        System.out.print("Data início (AAAA-MM-DD): ");
                        LocalDate inicio = LocalDate.parse(sc.nextLine());

                        System.out.print("Data fim (AAAA-MM-DD): ");
                        LocalDate fim = LocalDate.parse(sc.nextLine());

                        System.out.print("Valor aluguel: ");
                        double valorAluguel = sc.nextDouble();
                        sc.nextLine(); // limpar buffer

                        Contrato contrato = new Contrato(idCliente, idImovel, inicio, fim, valorAluguel);
                        contratoDAO.salvar(contrato);
                        System.out.println("✅ Contrato cadastrado com sucesso!");
                    } catch (DateTimeParseException e) {
                        System.out.println("❌ Formato de data inválido. Use AAAA-MM-DD.");
                    } catch (Exception e) {
                        System.out.println("❌ Erro ao cadastrar contrato: " + e.getMessage());
                    }
                    break;

                case 4: // Listar imóveis disponíveis
                    System.out.println("📋 Imóveis disponíveis:");
                    imovelDAO.listarDisponiveis().forEach(System.out::println);
                    break;

                case 5: // Listar contratos ativos
                    System.out.println("📋 Contratos ativos:");
                    contratoDAO.listarAtivos().forEach(System.out::println);
                    break;

                case 6: // Clientes com mais contratos
                    System.out.println("📊 Clientes com mais contratos:");
                    contratoDAO.clientesComMaisContratos().forEach(System.out::println);
                    break;

                case 7: // Contratos expirando nos próximos 30 dias
                    System.out.println("⏳ Contratos expirando nos próximos 30 dias:");
                    contratoDAO.contratosExpirando30Dias().forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("👋 Saindo do sistema...");
                    break;

                default:
                    System.out.println("❌ Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
