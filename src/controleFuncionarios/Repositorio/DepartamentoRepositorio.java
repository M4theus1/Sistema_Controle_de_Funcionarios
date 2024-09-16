package controleFuncionarios.Repositorio;

import java.util.ArrayList;
import java.util.List;
import controleFuncionarios.Entidades.Departamento;

// Implementação do repositório para gerenciar Departamentos
public class DepartamentoRepositorio implements IDepartamentoRepositorio {

    // Lista para armazenar os departamentos
    private List<Departamento> departamentos = new ArrayList<>();

    @Override
    public void adicionar(Departamento departamento) {
        // Adiciona um novo departamento à lista
        departamentos.add(departamento);
    }

    @Override
    public Departamento buscar(String codigo) {
        // Busca um departamento pelo código
        // Usa stream para filtrar e encontrar o primeiro departamento que tem o código correspondente
        return departamentos.stream()
                            .filter(u -> u.getCodigo().equals(codigo)) // Filtra pelo código
                            .findFirst() // Encontra o primeiro resultado
                            .orElse(null); // Retorna null se nenhum departamento for encontrado
    }

    @Override
    public void atualizar(Departamento departamento) {
        // Atualiza um departamento existente
        Departamento u = buscar(departamento.getCodigo()); // Busca o departamento existente pelo código
        if (u != null) {
            // Remove o departamento antigo e adiciona o novo com as atualizações
            departamentos.remove(u);
            departamentos.add(departamento);
        }
    }

    @Override
    public void remover(String codigo) {
        // Remove um departamento pelo código
        Departamento u = buscar(codigo); // Busca o departamento a ser removido
        if (u != null) {
            // Remove o departamento da lista
            departamentos.remove(u);
        }
    }

    @Override
    public List<Departamento> listarTodos() {
        // Retorna uma nova lista contendo todos os departamentos
        return new ArrayList<>(departamentos);
    }
}
