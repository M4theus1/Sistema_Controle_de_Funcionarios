package controleFuncionarios.Entidades;
import java.util.Date;

public class Departamento {
	private String nome;
	private String codigo;
	private Funcionario gerente;
	private double orcamento;
	private int numeroFuncionarios;
	private String localizacao;
	private Date dataCriacao;
	
	//Construtores
	public Departamento(String nome, String codigo, Funcionario gerente, double orcamento, int numeroFuncionarios, String localizacao, Date dataCriacao) {
		this.setNome(nome);
		this.setCodigo(codigo);
		this.setGerente(gerente);
		this.setOrcamento(orcamento);
		this.setNumeroFuncionarios(numeroFuncionarios);
		this.setLocalizacao(localizacao);
		this.setDataCriacao(dataCriacao);
	}

	//Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Funcionario getGerente() {
		return gerente;
	}

	public void setGerente(Funcionario gerente) {
		this.gerente = gerente;
	}

	public double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(double orcamento) {
		this.orcamento = orcamento;
	}

	public int getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(int numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
}
