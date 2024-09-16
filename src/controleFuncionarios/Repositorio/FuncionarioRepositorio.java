package controleFuncionarios.Repositorio;

import java.util.ArrayList;
import java.util.List;
import controleFuncionarios.Entidades.Funcionario;

// Implementação do repositório para gerenciar Funcionários
public class FuncionarioRepositorio implements IFuncionarioRepositorio {

    // Lista para armazenar os funcionários
    private List<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public void adicionar(Funcionario funcionario) {
        // Adiciona um novo funcionário à lista
        funcionarios.add(funcionario);
    }

    @Override
    public Funcionario buscar(String cpf) {
        // Busca um funcionário pelo CPF
        // Usa stream para filtrar e encontrar o primeiro funcionário que tem o CPF correspondente
        return funcionarios.stream()
                            .filter(u -> u.getCpf().equals(cpf)) // Filtra pelo CPF
                            .findFirst() // Encontra o primeiro resultado
                            .orElse(null); // Retorna null se nenhum funcionário for encontrado
    }

    @Override
    public void atualizar(Funcionario funcionario) {
        // Atualiza um funcionário existente
        Funcionario u = buscar(funcionario.getCpf()); // Busca o funcionário existente pelo CPF
        if (u != null) {
            // Remove o funcionário antigo e adiciona o novo com as atualizações
            funcionarios.remove(u);
            funcionarios.add(funcionario);
        }
    }

    @Override
    public void remover(String cpf) {
        // Remove um funcionário pelo CPF
        Funcionario u = buscar(cpf); // Busca o funcionário a ser removido
        if (u != null) {
            // Remove o funcionário da lista
            funcionarios.remove(u);
        }
    }

    @Override
    public List<Funcionario> listarTodos() {
        // Retorna uma nova lista contendo todos os funcionários
        return new ArrayList<>(funcionarios);
    }
}
