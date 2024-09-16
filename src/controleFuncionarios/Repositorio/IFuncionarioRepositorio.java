package controleFuncionarios.Repositorio;
import controleFuncionarios.Entidades.Funcionario;
import java.util.List;

public interface IFuncionarioRepositorio {
	//add user 
	void adicionar(Funcionario funcionario);
	//buscar por cod
	Funcionario buscar(String cpf);
	//att user
	void atualizar(Funcionario funcionario);
	//remover user por cod
	void remover(String cpf);
	//listar
	List<Funcionario> listarTodos();
	
}
