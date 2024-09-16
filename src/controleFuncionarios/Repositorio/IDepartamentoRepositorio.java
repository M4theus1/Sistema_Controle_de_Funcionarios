package controleFuncionarios.Repositorio;
import controleFuncionarios.Entidades.Departamento;
import java.util.List;

public interface IDepartamentoRepositorio {
	//add departamento
	void adicionar(Departamento departamento);
	//buscar por cod
	Departamento buscar(String codigo);
	//atualizar deparamento
	void atualizar(Departamento departamento);
	//remover por cod
	void remover(String codigo);
	//listar departamentos
	List<Departamento> listarTodos();
}
