package controleFuncionarios.Menu;

import controleFuncionarios.Entidades.Departamento;
import controleFuncionarios.Entidades.FuncMeioPer;
import controleFuncionarios.Entidades.FuncPerIntegral;
import controleFuncionarios.Entidades.Funcionario;
import controleFuncionarios.Repositorio.DepartamentoRepositorio;
import controleFuncionarios.Repositorio.FuncionarioRepositorio;
import controleFuncionarios.Servicos.FolhaPagamento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Repositórios e serviços necessários
    private static DepartamentoRepositorio departamentoRepo = new DepartamentoRepositorio();
    private static FuncionarioRepositorio funcionarioRepo = new FuncionarioRepositorio();
    private static FolhaPagamento folhaPagamento = new FolhaPagamento();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                // Exibe o menu principal
                System.out.println("\nSistema de Controle de Funcionários");
                System.out.println("1. Funcionários");
                System.out.println("2. Departamentos");
                System.out.println("3. Processar Folha de Pagamento");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                // Navega para o menu selecionado
                switch (opcao) {
                    case 1:
                        menuFuncionarios();
                        break;
                    case 2:
                        menuDepartamentos();
                        break;
                    case 3:
                        processarFolha();
                        break;
                    case 4:
                        System.out.println("Saindo do sistema...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                // Captura entradas inválidas (não numéricas)
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }
    }

    // Menu para gerenciamento de funcionários
    private static void menuFuncionarios() {
        while (true) {
            try {
                System.out.println("\nMenu Funcionários");
                System.out.println("1. Adicionar Funcionário");
                System.out.println("2. Atualizar Funcionário");
                System.out.println("3. Remover Funcionário");
                System.out.println("4. Listar Funcionários");
                System.out.println("5. Voltar ao Menu Principal");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                // Navega para a opção selecionada
                switch (opcao) {
                    case 1:
                        adicionarFuncionario();
                        break;
                    case 2:
                        atualizarFuncionario();
                        break;
                    case 3:
                        removerFuncionario();
                        break;
                    case 4:
                        listarFuncionarios();
                        break;
                    case 5:
                        return; // Voltar ao Menu Principal
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                // Captura entradas inválidas (não numéricas)
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }
    }

    // Menu para gerenciamento de departamentos
    private static void menuDepartamentos() {
        while (true) {
            try {
                System.out.println("\nMenu Departamentos");
                System.out.println("1. Adicionar Departamento");
                System.out.println("2. Atualizar Departamento");
                System.out.println("3. Remover Departamento");
                System.out.println("4. Listar Departamentos");
                System.out.println("5. Voltar ao Menu Principal");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                // Navega para a opção selecionada
                switch (opcao) {
                    case 1:
                        adicionarDepartamento();
                        break;
                    case 2:
                        atualizarDepartamento();
                        break;
                    case 3:
                        removerDepartamento();
                        break;
                    case 4:
                        listarDepartamentos();
                        break;
                    case 5:
                        return; // Voltar ao Menu Principal
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                // Captura entradas inválidas (não numéricas)
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }
    }

    // Adiciona um novo departamento
    private static void adicionarDepartamento() {
        try {
            System.out.print("Nome do Departamento: ");
            String nome = scanner.nextLine();
            System.out.print("Código do Departamento: ");
            String codigo = scanner.nextLine();
            // Gerente pode ser nulo para simplificação
            Departamento departamento = new Departamento(nome, codigo, null, 0, 0, "", new Date());
            departamentoRepo.adicionar(departamento);
            System.out.println("Departamento adicionado com sucesso!");
        } catch (Exception e) {
            // Captura e exibe erros durante a adição
            System.out.println("Erro ao adicionar departamento: " + e.getMessage());
        }
    }

    // Atualiza um departamento existente
    private static void atualizarDepartamento() {
        try {
            System.out.print("Código do Departamento para atualizar: ");
            String codigo = scanner.nextLine();
            Departamento departamento = departamentoRepo.buscar(codigo);
            if (departamento != null) {
                System.out.print("Novo Nome do Departamento: ");
                String nome = scanner.nextLine();
                System.out.print("Novo Orçamento: ");
                double orcamento = scanner.nextDouble();
                scanner.nextLine(); // Limpar o buffer do scanner
                System.out.print("Nova Localização: ");
                String localizacao = scanner.nextLine();
                System.out.print("Novo Número de Funcionários: ");
                int numeroFuncionarios = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
                departamento.setNome(nome);
                departamento.setOrcamento(orcamento);
                departamento.setLocalizacao(localizacao);
                departamento.setNumeroFuncionarios(numeroFuncionarios);
                departamentoRepo.atualizar(departamento);
                System.out.println("Departamento atualizado com sucesso!");
            } else {
                System.out.println("Departamento não encontrado!");
            }
        } catch (InputMismatchException e) {
            // Captura entradas inválidas (não numéricas)
            System.out.println("Entrada inválida. Por favor, insira um número.");
            scanner.nextLine(); // Limpar o buffer do scanner
        } catch (Exception e) {
            // Captura e exibe erros durante a atualização
            System.out.println("Erro ao atualizar departamento: " + e.getMessage());
        }
    }

    // Remove um departamento existente
    private static void removerDepartamento() {
        try {
            System.out.print("Código do Departamento para remover: ");
            String codigo = scanner.nextLine();
            Departamento departamento = departamentoRepo.buscar(codigo);
            if (departamento != null) {
                departamentoRepo.remover(codigo);
                System.out.println("Departamento removido com sucesso!");
            } else {
                System.out.println("Departamento não encontrado!");
            }
        } catch (Exception e) {
            // Captura e exibe erros durante a remoção
            System.out.println("Erro ao remover departamento: " + e.getMessage());
        }
    }

    // Adiciona um novo funcionário
    private static void adicionarFuncionario() {
        try {
            System.out.print("Nome do Funcionário: ");
            String nome = scanner.nextLine();
            System.out.print("CPF do Funcionário: ");
            String cpf = scanner.nextLine();
            System.out.print("Data de Nascimento (dd/MM/yyyy): ");
            String dataNascimentoStr = scanner.nextLine();
            Date dataNascimento = parseDate(dataNascimentoStr);
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Cargo: ");
            String cargo = scanner.nextLine();
            System.out.print("Salário: ");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer do scanner
            System.out.print("Data de Admissão (dd/MM/yyyy): ");
            String dataAdmissaoStr = scanner.nextLine();
            Date dataAdmissao = parseDate(dataAdmissaoStr);
            System.out.print("Número de Matrícula: ");
            String numeroMatricula = scanner.nextLine();
            System.out.print("Status: ");
            String status = scanner.nextLine();
            System.out.print("Supervisor (CPF, ou deixe vazio se não tiver): ");
            String supervisorCpf = scanner.nextLine();
            Funcionario supervisor = funcionarioRepo.buscar(supervisorCpf);

            System.out.print("Tipo de Funcionário (1 para Integral, 2 para Meio Período): ");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            Funcionario funcionario;

            if (tipo == 1) {
                System.out.print("Horas Trabalhadas por Semana: ");
                int horasTrabalhadas = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
                funcionario = new FuncPerIntegral(nome, cpf, dataNascimento, endereco, telefone, email, cargo, salario, dataAdmissao, null, numeroMatricula, status, supervisor, horasTrabalhadas);
            } else {
                System.out.print("Horas Trabalhadas por Semana: ");
                int horasTrabalhadas = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
                funcionario = new FuncMeioPer(nome, cpf, dataNascimento, endereco, telefone, email, cargo, salario, dataAdmissao, null, numeroMatricula, status, supervisor, horasTrabalhadas);
            }

            funcionarioRepo.adicionar(funcionario);
            System.out.println("Funcionário adicionado com sucesso!");
        } catch (InputMismatchException e) {
            // Captura entradas inválidas (não numéricas)
            System.out.println("Entrada inválida. Por favor, insira um número.");
            scanner.nextLine(); // Limpar o buffer do scanner
        } catch (ParseException e) {
            // Captura erros de formato de data
            System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
        } catch (Exception e) {
            // Captura e exibe erros durante a adição
            System.out.println("Erro ao adicionar funcionário: " + e.getMessage());
        }
    }

    // Atualiza os dados de um funcionário existente
    private static void atualizarFuncionario() {
        try {
            System.out.print("CPF do Funcionário para atualizar: ");
            String cpf = scanner.nextLine();
            Funcionario funcionario = funcionarioRepo.buscar(cpf);
            if (funcionario != null) {
                System.out.print("Novo Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Novo Endereço: ");
                String endereco = scanner.nextLine();
                System.out.print("Novo Telefone: ");
                String telefone = scanner.nextLine();
                System.out.print("Novo Email: ");
                String email = scanner.nextLine();
                System.out.print("Novo Cargo: ");
                String cargo = scanner.nextLine();
                System.out.print("Novo Salário: ");
                double salario = scanner.nextDouble();
                scanner.nextLine(); // Limpar o buffer do scanner
                System.out.print("Nova Data de Admissão (dd/MM/yyyy): ");
                String dataAdmissaoStr = scanner.nextLine();
                Date dataAdmissao = parseDate(dataAdmissaoStr);
                System.out.print("Novo Número de Matrícula: ");
                String numeroMatricula = scanner.nextLine();
                System.out.print("Novo Status: ");
                String status = scanner.nextLine();
                System.out.print("Novo Supervisor (CPF, ou deixe vazio se não tiver): ");
                String supervisorCpf = scanner.nextLine();
                Funcionario supervisor = funcionarioRepo.buscar(supervisorCpf);

                // Atualizar os atributos do funcionário
                funcionario.setNome(nome);
                funcionario.setEndereco(endereco);
                funcionario.setTelefone(telefone);
                funcionario.setEmail(email);
                funcionario.setCargo(cargo);
                funcionario.setSalario(salario);
                funcionario.setDataAdmissao(dataAdmissao);
                funcionario.setNumeroMatricula(numeroMatricula);
                funcionario.setStatus(status);
                funcionario.setSupervisor(supervisor);

                funcionarioRepo.atualizar(funcionario);
                System.out.println("Funcionário atualizado com sucesso!");
            } else {
                System.out.println("Funcionário não encontrado!");
            }
        } catch (InputMismatchException e) {
            // Captura entradas inválidas (não numéricas)
            System.out.println("Entrada inválida. Por favor, insira um número.");
            scanner.nextLine(); // Limpar o buffer do scanner
        } catch (ParseException e) {
            // Captura erros de formato de data
            System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
        } catch (Exception e) {
            // Captura e exibe erros durante a atualização
            System.out.println("Erro ao atualizar funcionário: " + e.getMessage());
        }
    }

    // Remove um funcionário existente
    private static void removerFuncionario() {
        try {
            System.out.print("CPF do Funcionário para remover: ");
            String cpf = scanner.nextLine();
            Funcionario funcionario = funcionarioRepo.buscar(cpf);
            if (funcionario != null) {
                funcionarioRepo.remover(cpf);
                System.out.println("Funcionário removido com sucesso!");
            } else {
                System.out.println("Funcionário não encontrado!");
            }
        } catch (Exception e) {
            // Captura e exibe erros durante a remoção
            System.out.println("Erro ao remover funcionário: " + e.getMessage());
        }
    }

    // Lista todos os funcionários cadastrados
    private static void listarFuncionarios() {
        try {
            List<Funcionario> funcionarios = funcionarioRepo.listarTodos();
            if (funcionarios.isEmpty()) {
                System.out.println("Nenhum funcionário cadastrado.");
            } else {
                for (Funcionario f : funcionarios) {
                    System.out.println(f.getNome() + " - " + f.getCpf());
                }
            }
        } catch (Exception e) {
            // Captura e exibe erros durante a listagem
            System.out.println("Erro ao listar funcionários: " + e.getMessage());
        }
    }

    // Lista todos os departamentos cadastrados
    private static void listarDepartamentos() {
        try {
            List<Departamento> departamentos = departamentoRepo.listarTodos();
            if (departamentos.isEmpty()) {
                System.out.println("Nenhum departamento cadastrado.");
            } else {
                for (Departamento d : departamentos) {
                    System.out.println(d.getNome() + " - " + d.getCodigo());
                }
            }
        } catch (Exception e) {
            // Captura e exibe erros durante a listagem
            System.out.println("Erro ao listar departamentos: " + e.getMessage());
        }
    }

    // Processa a folha de pagamento para todos os funcionários
    private static void processarFolha() {
        try {
            List<Funcionario> funcionarios = funcionarioRepo.listarTodos();
            if (funcionarios.isEmpty()) {
                System.out.println("Nenhum funcionário para processar a folha de pagamento.");
            } else {
                for (Funcionario f : funcionarios) {
                    double salario = folhaPagamento.calcularSalario(f);
                    System.out.println("Funcionário: " + f.getNome() + " - Salário Líquido: R$" + salario);
                }
            }
        } catch (Exception e) {
            // Captura e exibe erros durante o processamento da folha de pagamento
            System.out.println("Erro ao processar a folha de pagamento: " + e.getMessage());
        }
    }

    // Converte uma string para um objeto Date, lançando exceção se o formato estiver incorreto
    private static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Garante que a data seja estritamente válida
        return sdf.parse(dateStr);
    }
}
