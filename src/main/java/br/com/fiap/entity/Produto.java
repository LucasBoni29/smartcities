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

@Entity // *Obrigatório* Todas as nossas Entity, precisam ser mapeadas no arquivo persistence.xml
@Table(name="tb_produto") // Nome da tabela -se não for nomeado, ele vai colocar o nome da classe.
public class Produto {
	
	@Id // *Obrigatório*
	@SequenceGenerator(name="produto", sequenceName="sq_tb_produto", allocationSize=1) //Auto-increment. 3 parâmetros: 1º Name (Nome referenciado no java), 
	//2º sequenceName (Nome da sequence ser gerada no BD), 3º allocationSize (Incrementando de 1 em 1).
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="produto") //Nome vai ser referenciado acima e que vai aparecer no BD (produto).
	
	@Column(name="cd_produto")
	private int id;
	
	@Column(name="nm_produto",nullable = false, length=100) // Não pode ser nulo e seu varchar é 100 (100 caracteres). Na mesma lógica que escrevemos no Terminal do XAMPP.
	private String nome;
	
	@Column(name="vl_preco")
	private double preco;
	
	@Temporal(TemporalType.DATE) // Se irá gravar somente a hora (Temporal.DATE), se irá gravar a data e hora (Temporal.TIMESTAMPP) ou se irá gravar somente a hora (Temporal.TIME).
	@Column(name="dt_data_validade")
	private Calendar dataValidade;
	
	@Enumerated(EnumType.STRING) // Permitirá eu usar o valor exato abaixo, sem ser valor numérico.
	private Estado estado; // Estará sendo usado valor numérico (1)
	
	@Column(name="dt_cadastro")
	@CreationTimestamp // Vai colocar a data que aquele dado foi criado. Automático.
	private Calendar dataCadastro;
	
	@Column(name="dt_modificacao")
	@UpdateTimestamp // Vai mostrar a última atualização que aquele dado teve. Automático.
	private Calendar dataModificacao;
	
	@Column(name="vl_precoDesconto")
	@Formula("vl_preco*0.9") // Literalmente uma fórmula. Você vai dizer qual coluna será implementada essa fórmula para esse valor ser colocado nessa nova variável.
	private double precoDesconto;
	
	
}
