package controleFuncionarios.Entidades;

import java.util.Date;

public class FuncPerIntegral extends Funcionario{
	//classe de identificacao de funcionario meio periodo
	private int horasTrabalhadasPorSemana;
	//herança da classe funcionario
	public FuncPerIntegral(String nome, String cpf, Date dataNascimento, String endereco, String telefone, String email,
			String cargo, double salario, Date dataAdmissao, Departamento departamento, String numeroMatricula,
			String status, Funcionario supervisor, int horasTrabalhadasPorSemana) {
		super(nome, cpf, dataNascimento, endereco, telefone, email, cargo, salario, dataAdmissao, departamento, numeroMatricula,
				status, supervisor);
		this.setHorasTrabalhadasPorSemana(horasTrabalhadasPorSemana);
	}
	//getter e setter pra horas trabalhadas por semana
	public int getHorasTrabalhadasPorSemana() {
		return horasTrabalhadasPorSemana;
	}
	public void setHorasTrabalhadasPorSemana(int horasTrabalhadasPorSemana) {
		this.horasTrabalhadasPorSemana = horasTrabalhadasPorSemana;
	}
	
	public double getSalario() {
		return super.getSalario();
	}

}
