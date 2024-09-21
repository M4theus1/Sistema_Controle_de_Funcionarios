package controleFuncionarios.Repositorio;

import controleFuncionarios.Entidades.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositorio implements IFuncionarioRepositorio {
    // Lista para armazenar os funcionários
    private List<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public void adicionar(Funcionario funcionario) {
        // Verifica se o funcionário a ser adicionado é nulo
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo.");
        }
        // Verifica se já existe um funcionário com o mesmo CPF
        if (buscar(funcionario.getCpf()) != null) {
            throw new IllegalArgumentException("Funcionário com CPF já cadastrado.");
        }
        // Adiciona o funcionário à lista
        funcionarios.add(funcionario);
    }

    @Override
    public Funcionario buscar(String cpf) {
        // Percorre a lista de funcionários para encontrar o com o CPF especificado
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) {
                return f; // Retorna o funcionário encontrado
            }
        }
        // Lança uma exceção se o funcionário não for encontrado
        throw new IllegalArgumentException("Funcionário não encontrado.");
    }

    @Override
    public void atualizar(Funcionario funcionario) {
        // Verifica se o funcionário a ser atualizado é nulo
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo.");
        }
        // Busca o funcionário existente com o mesmo CPF
        Funcionario existente = buscar(funcionario.getCpf());
        // Atualiza os dados do funcionário existente com os novos valores
        existente.setNome(funcionario.getNome());
        existente.setEndereco(funcionario.getEndereco());
        existente.setTelefone(funcionario.getTelefone());
        existente.setEmail(funcionario.getEmail());
        existente.setCargo(funcionario.getCargo());
        existente.setSalario(funcionario.getSalario());
        existente.setDataAdmissao(funcionario.getDataAdmissao());
        existente.setNumeroMatricula(funcionario.getNumeroMatricula());
        existente.setStatus(funcionario.getStatus());
        existente.setSupervisor(funcionario.getSupervisor());
    }

    @Override
    public void remover(String cpf) {
        // Busca o funcionário a ser removido pelo CPF
        Funcionario funcionario = buscar(cpf);
        // Remove o funcionário da lista
        funcionarios.remove(funcionario);
    }

    @Override
    public List<Funcionario> listarTodos() {
        // Retorna uma nova lista com todos os funcionários
        return new ArrayList<>(funcionarios);
    }
}
