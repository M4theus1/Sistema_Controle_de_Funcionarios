package controleFuncionarios.Entidades;
import java.util.Date;;

public class FuncMeioPer extends Funcionario {
	//classe de identificacao de funcionario meio periodo
	private int horasTrabalhadasPorDia;
	
	//herança da classe funcionario
	public FuncMeioPer(String nome, String cpf, Date dataNascimento, String endereco, String telefone, String email, String cargo, Double salario, Date dataAdmissao, Departamento departamento, String numeroMatricula, String status, Funcionario supervisor, int horasTrabalhadasPorDia) {
		super(nome, cpf, dataNascimento, endereco, telefone, email, cargo, salario, dataAdmissao, departamento, numeroMatricula, status, supervisor);
		this.horasTrabalhadasPorDia = horasTrabalhadasPorDia;
	}
	//getter e setter pra horas trabalhadas por dia
	public int getHorasTrabalhadasPorDia() {
		return horasTrabalhadasPorDia;
	}
	
	public void setHorasTrabalhadasPorDia(int horasTrabalhadasPorDia) {
		this.horasTrabalhadasPorDia = horasTrabalhadasPorDia;
	}
	
	public double getSalario() {
		return super.getSalario() / 2;
	}
}
