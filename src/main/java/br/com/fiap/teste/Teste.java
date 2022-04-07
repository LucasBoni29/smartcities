package br.com.fiap.teste;

import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("smartcities").createEntityManager(); 
		// Fábrica que cria os EntityManager para nós. Com esse objeto da factory, podemos criar um objeto de criar um EntityManager (.createEntityManager)
		// A partir do momento que criarmos esse persistence, ele vai verificar se precisamos validar ou precisamos atualizar, ou criar algo que está no BD.
		// Ele pede o nome do persistence lá no persistence.xml, que no nosso caso é smartcities. 
		// Podemos ter várias persistence, por isso ele pede qual ele vai buscar.
	}

}
