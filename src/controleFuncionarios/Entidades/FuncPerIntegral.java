package controleFuncionarios.Entidades;

import java.util.Date;

public class FuncPerIntegral extends Funcionario{
	//classe de identificacao de funcionario meio periodo
	private TipoContrato tipoContrato;
	//herança da classe funcionario
	public FuncPerIntegral(String nome, String cpf, Date dataNascimento, String endereco, String telefone, String email,
			String cargo, double salario, Date dataAdmissao, Departamento departamento, String numeroMatricula,
			String status, Funcionario supervisor, TipoContrato tipoContrato) {
		super(nome, cpf, dataNascimento, endereco, telefone, email, cargo, salario, dataAdmissao, departamento, numeroMatricula,
				status, supervisor);
		this.tipoContrato = tipoContrato;
	}
	//getter e setter pra horas trabalhadas por semana
	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	
	public double getSalario() {
		return super.getSalario();
	}

}
