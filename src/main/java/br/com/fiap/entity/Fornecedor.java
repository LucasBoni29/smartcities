package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="tb_fornecedor")
public class Fornecedor {
	
	@Id
	@SequenceGenerator(name="fornecedor", sequenceName="sq_tb_fornecedor",allocationSize=1) // Parametrizar a sequência. O nome precisa ser igual do gerador para ele saber qual a sequence que será gerada e padronizada.
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="fornecedor") // Auto-Increment.
	@Column(name="dc_fornecedor")
	private int codigo;
	
	@Column(name="nm_fornecedor",nullable=false, length=50)
	private String nome;
	
	@CreationTimestamp
	@Column(name="dt_cadastro")
	private Calendar dataCadastro;
	
	@UpdateTimestamp
	@Column(name="dt_modificacao")
	private Calendar dataModificacao;
	
	
	
	public Fornecedor() { // Criando um construtor cheio, superclass.
		super();
	}

	public Fornecedor(int codigo, String nome, Calendar dataCadastro, Calendar dataModificacao) { //Criando um construtor fields. Esse generator precisa ser criado porque ele vai ser preenchido pelos setters.
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.dataModificacao = dataModificacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Calendar dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	
}
