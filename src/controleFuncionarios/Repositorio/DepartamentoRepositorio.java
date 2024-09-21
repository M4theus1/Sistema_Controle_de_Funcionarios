package controleFuncionarios.Repositorio;

import controleFuncionarios.Entidades.Departamento;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoRepositorio implements IDepartamentoRepositorio {
    // Lista para armazenar os departamentos
    private List<Departamento> departamentos = new ArrayList<>();

    @Override
    public void adicionar(Departamento departamento) {
        // Verifica se o departamento a ser adicionado é nulo
        if (departamento == null) {
            throw new IllegalArgumentException("Departamento não pode ser nulo.");
        }
        // Verifica se já existe um departamento com o mesmo código
        if (buscar(departamento.getCodigo()) != null) {
            throw new IllegalArgumentException("Departamento com código já cadastrado.");
        }
        // Adiciona o departamento à lista
        departamentos.add(departamento);
    }

    @Override
    public Departamento buscar(String codigo) {
        // Percorre a lista de departamentos para encontrar o com o código especificado
        for (Departamento d : departamentos) {
            if (d.getCodigo().equals(codigo)) {
                return d; // Retorna o departamento encontrado
            }
        }
        // Lança uma exceção se o departamento não for encontrado
        throw new IllegalArgumentException("Departamento não encontrado.");
    }

    @Override
    public void atualizar(Departamento departamento) {
        // Verifica se o departamento a ser atualizado é nulo
        if (departamento == null) {
            throw new IllegalArgumentException("Departamento não pode ser nulo.");
        }
        // Busca o departamento existente com o mesmo código
        Departamento existente = buscar(departamento.getCodigo());
        // Atualiza os dados do departamento existente com os novos valores
        existente.setNome(departamento.getNome());
        existente.setOrcamento(departamento.getOrcamento());
        existente.setLocalizacao(departamento.getLocalizacao());
        existente.setNumeroFuncionarios(departamento.getNumeroFuncionarios());
        existente.setGerente(departamento.getGerente());
    }

    @Override
    public void remover(String codigo) {
        // Busca o departamento a ser removido pelo código
        Departamento departamento = buscar(codigo);
        // Remove o departamento da lista
        departamentos.remove(departamento);
    }

    @Override
    public List<Departamento> listarTodos() {
        // Retorna uma nova lista com todos os departamentos
        return new ArrayList<>(departamentos);
    }
}
