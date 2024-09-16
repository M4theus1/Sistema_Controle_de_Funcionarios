package controleFuncionarios.Entidades;
import java.util.Date;

public class Funcionario {
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private String endereco;
	private String telefone;
	private String email;
	private String cargo;
	private double salario;
	private Date dataAdmissao;
	private Departamento departamento;
	private String numeroMatricula;
	private String status;
	private Funcionario supervisor;
	
	//Construtores
	public Funcionario(String nome, String cpf, Date dataNascimento, String endereco, String telefone, String email, String cargo, double salario, Date dataAdmissao, Departamento departamento, String numeroMatricula, String status, Funcionario supervisor) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setDataNascimento(dataNascimento);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		this.setEmail(email);
		this.setCargo(cargo);
		this.setSalario(salario);
		this.setDataAdmissao(dataAdmissao);
		this.setDepartamento(departamento);
		this.setNumeroMatricula(numeroMatricula);
		this.setStatus(status);
		this.setSupervisor(supervisor);
	}

	
	//Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Funcionario getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Funcionario supervisor) {
		this.supervisor = supervisor;
	}
	
	
	
	
}
