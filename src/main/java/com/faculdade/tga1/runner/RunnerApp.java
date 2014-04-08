package com.faculdade.tga1.runner;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.faculdade.tga1.entity.Categoria;
import com.faculdade.tga1.entity.Cor;
import com.faculdade.tga1.entity.Departamento;
import com.faculdade.tga1.entity.Empresa;
import com.faculdade.tga1.entity.EstoqueGradeItem;
import com.faculdade.tga1.entity.Grade;
import com.faculdade.tga1.entity.GradeItem;
import com.faculdade.tga1.entity.Holding;
import com.faculdade.tga1.entity.Loja;
import com.faculdade.tga1.entity.Produto;
import com.faculdade.tga1.entity.Secao;
import com.faculdade.tga1.entity.Tamanho;

/**
 * Trabalho - GA1
 * Banco de Dados II - 2014/1
 * Gilberto Irajá Müller
 *
 * Integrantes:
 *      Paulo Grabin - plgrabin@gmail.com
 *      Iuri Andreazza - iuri.andreazza@gmail.com
 *      Talita Audibert - tali.audibert@gmail.com
 *      Eduardo Pereira da Silva - eduardobursa@gmail.com
 *
 */
/**
	SQL para testar os relacionamentos.
		
	SELECT  h.id, h.nome,
		e.id, e.razaosocial, e.fantasia, e.logradouro,
		l.id, l.dataabertura, l.nome, l.nrofuncionario,
		d.id, d.nome,
		s.id, s.nome,
		c.id, c.nome,
		p.id, p.nome, p.estoqueatual, p.estoqueminimo,
		g.id, g.nome,
		gi.id, gi.nome,
		egi.id, egi.estoqueAtual, egi.estoqueMinimo,
		t.nome,
		cor.nome
	FROM holding h
		LEFT JOIN empresa e
		ON h.id = e.holder_id
			LEFT JOIN loja l
			ON e.id = l.empresa_id
				LEFT JOIN departamento d
				ON l.id = d.loja_id
					LEFT JOIN secao s
					ON d.id = s.departamento_id
						LEFT JOIN categoria c
						ON s.id = c.secao_id
							LEFT JOIN produto p
							ON c.id = p.categoria_id
								LEFT JOIN grade g
								ON p.grade_id = g.id
									LEFT JOIN gradeItem gi
									ON g.id = gi.grade_id
										LEFT JOIN estoqueGradeItem egi
										ON gi.id = egi.codigogradeitem
											LEFT JOIN tamanho t
											ON gi.tamanho_id = t.id
												LEFT JOIN cor
												ON gi.cor_id = cor.id
	ORDER BY h.id, e.id, l.id, d.id, s.id, c.id, p.id, g.id, gi.id, egi.id, t.id, cor.id
 */
public class RunnerApp {

	public static void main(String[] args) {

		/**
		 * 	CORES
		 */
		Cor cor1 = new Cor();
		cor1.setNome("Azul");
		
		Cor cor2 = new Cor();
		cor2.setNome("Preto");

		/**
		 * 	TAMANHOS
		 */
		Tamanho tam1 = new Tamanho();
		tam1.setNome("33");
		
		Tamanho tam2 = new Tamanho();
		tam2.setNome("34");		
		
		Tamanho tam3 = new Tamanho();
		tam3.setNome("35");
		
		Tamanho tam4 = new Tamanho();
		tam4.setNome("36");
		
		Tamanho tam5 = new Tamanho();
		tam5.setNome("37");
		
		/**
		 * HOLDING
		 */
		Holding h = new Holding();
		h.setNome("Grupo MasBahTchê");

		/**
		 * EMPRESAS
		 */
		Empresa emp1 = new Empresa();
		emp1.setHolder(h);
		emp1.setRazaoSocial("Tchê Sapatos Ltda");
		emp1.setFantasia("Tchê");
		emp1.setLogradouro("Rua João Vedelino, 145");
		
		Empresa emp2 = new Empresa();
		emp2.setHolder(h);
		emp2.setRazaoSocial("Juca Sapato Feminino Ltda");
		emp2.setFantasia("Juca Sapato");
		emp2.setLogradouro("Rua Zé Teodoro, 666");
		
			/**
			 * EMPRESAS TO HOLDING
			 */
			h.addEmpresa(emp1);
			h.addEmpresa(emp2);

		/**
		 * LOJAS
		 */
		Loja loja1 = new Loja();
		loja1.setNome("Filial 01");
		loja1.setEmpresa(emp1);
		loja1.setNroFuncionario(16);
		loja1.setDataAbertura(Calendar.getInstance().getTime());

		Loja loja2 = new Loja();
		loja2.setNome("Filial 02");
		loja2.setEmpresa(emp1);
		loja2.setNroFuncionario(30);
		loja2.setDataAbertura(Calendar.getInstance().getTime());
		
		Loja loja3 = new Loja();
		loja3.setNome("Filial 01");
		loja3.setEmpresa(emp2);
		loja3.setNroFuncionario(15);
		loja3.setDataAbertura(Calendar.getInstance().getTime());
		
			/**
			 * LOJAS TO EMPRESAS
			 */
			emp1.addLoja(loja1);
			emp1.addLoja(loja2);
			emp2.addLoja(loja3);
		
		/**
		 * DEPARTAMENTO
		 */
		Departamento dep1 = new Departamento();
		dep1.setEmpresa(emp1);
		dep1.setLoja(loja1);
		dep1.setNome("Feminino");

		Departamento dep2 = new Departamento();
		dep2.setEmpresa(emp1);
		dep2.setLoja(loja1);
		dep2.setNome("Masculino");
		
		Departamento dep3 = new Departamento();
		dep3.setEmpresa(emp1);
		dep3.setLoja(loja1);
		dep3.setNome("Infantil");

		Departamento dep4 = new Departamento();
		dep4.setEmpresa(emp2);
		dep4.setLoja(loja1);
		dep4.setNome("Feminino");

			/**
			 * DEPARTAMENTO TO LOJAS
			 */
			loja1.addDepartamento(dep1);
			loja1.addDepartamento(dep2);
			loja1.addDepartamento(dep3);
			loja1.addDepartamento(dep4);

		/**
		 * SEÇÃO
		 */
		Secao sec1 = new Secao();
		sec1.setNome("Sapato");
		sec1.setLoja(loja1);
		sec1.setEmpresa(emp1);
		sec1.setDepartamento(dep1);
		
		Secao sec2 = new Secao();
		sec2.setNome("Bolsa");
		sec2.setLoja(loja1);
		sec2.setEmpresa(emp1);
		sec2.setDepartamento(dep2);

			/**
			 * SEÇÃO TO DEPARTAMENTO
			 */
			dep1.addSecao(sec1);
			dep2.addSecao(sec2);		

		/**
		 * CATEGORIA
		 */
		Categoria cat1 = new Categoria();
		cat1.setNome("Scarpin");
		cat1.setSecao(sec1);

		Categoria cat2 = new Categoria();
		cat2.setNome("Rasteirinha");
		cat2.setSecao(sec1);

		Categoria cat3 = new Categoria();
		cat3.setNome("Bolsa de mão ");
		cat3.setSecao(sec2);

			/**
			 * CATEGORIA TO SEÇÃO
			 */
			sec1.addCategoria(cat1);
			sec1.addCategoria(cat2);
			sec2.addCategoria(cat3);

		/**
		 * GRADE
		 */
		Grade grade1 = new Grade();
		grade1.setNome("Grade Brasil Feminino");

		Grade grade2 = new Grade();
		grade2.setNome("Grade Brasil Masculino");
		
		Grade grade3 = new Grade();
		grade3.setNome("Grade Bolsa");
		
		/**
		 * PRODUTO
		 */
		Produto produto = new Produto();
		produto.setNome("Scarpin Velasquez");
		produto.setEstoqueAtual(10);
		produto.setEstoqueMinimo(10);
		produto.setCategoria(cat1);
		produto.setGrade(grade1);

			/**
			 * PRODUTO TO CATEGORIA
			 */
			cat1.addProduto(produto);
	
			/**
			 * PRODUTO TO GRADE
			 */
			grade1.addProduto(produto);



		/**
		 * GRADEITEM
		 */
		GradeItem gradeItem1 = new GradeItem();
		gradeItem1.setNome("Azul tamanho 33");
		gradeItem1.setCor(cor1);
		gradeItem1.setTamanho(tam1);
		gradeItem1.setGrade(grade1);
			/**
			 * GRADEITEM TO GRADE, COR AND TAMANHO
			 */
			grade1.addGradeItem(gradeItem1);
			cor1.addGradeItem(gradeItem1);
			tam1.addGradeItem(gradeItem1);

		
		GradeItem gradeItem2 = new GradeItem();
		gradeItem2.setNome("Azul tamanho 34");
		gradeItem2.setCor(cor1);
		gradeItem2.setTamanho(tam2);
		gradeItem2.setGrade(grade1);
			/**
			 * GRADEITEM TO GRADE, COR AND TAMANHO
			 */
			grade1.addGradeItem(gradeItem2);
			cor1.addGradeItem(gradeItem2);
			tam2.addGradeItem(gradeItem2);
		
		
		GradeItem gradeItem3 = new GradeItem();
		gradeItem3.setNome("Azul tamanho 35");
		gradeItem3.setCor(cor1);
		gradeItem3.setTamanho(tam3);
		gradeItem3.setGrade(grade1);
			/**
			 * GRADEITEM TO GRADE, COR AND TAMANHO
			 */
			grade1.addGradeItem(gradeItem3);
			cor1.addGradeItem(gradeItem3);
			tam3.addGradeItem(gradeItem3);
		
		
		GradeItem gradeItem4 = new GradeItem();
		gradeItem4.setNome("Azul tamanho 36");
		gradeItem4.setCor(cor1);
		gradeItem4.setTamanho(tam4);
		gradeItem4.setGrade(grade1);
			/**
			 * GRADEITEM TO GRADE, COR AND TAMANHO
			 */
			grade1.addGradeItem(gradeItem4);
			cor1.addGradeItem(gradeItem4);
			tam4.addGradeItem(gradeItem4);
		
		
		GradeItem gradeItem5 = new GradeItem();
		gradeItem5.setNome("Azul tamanho 37");
		gradeItem5.setCor(cor1);
		gradeItem5.setTamanho(tam5);
		gradeItem5.setGrade(grade1);
			/**
			 * GRADEITEM TO GRADE, COR AND TAMANHO
			 */
			grade1.addGradeItem(gradeItem5);
			cor1.addGradeItem(gradeItem5);
			tam5.addGradeItem(gradeItem5);
		
		/**
		 * 
		 * 
		 * ESTOQUEGRADEITEM
		 */
		EstoqueGradeItem egi1 = new EstoqueGradeItem();
		egi1.setProduto(produto);
		egi1.setGradeItem(gradeItem1);
		egi1.setLoja(loja1);
		egi1.setEmpresa(emp1);
		egi1.setEstoqueAtual(5);
		egi1.setEstoqueMinimo(2);
		
			loja1.addEstoqueGradeItem(egi1);
			produto.addEstoqueGradeItem(egi1);
		
		
		EstoqueGradeItem egi2 = new EstoqueGradeItem();
		egi2.setProduto(produto);
		egi2.setGradeItem(gradeItem2);
		egi2.setLoja(loja1);
		egi2.setEmpresa(emp1);
		egi2.setEstoqueAtual(2);
		egi2.setEstoqueMinimo(5);
		
			loja1.addEstoqueGradeItem(egi2);
			produto.addEstoqueGradeItem(egi2);
		
		
		EstoqueGradeItem egi3 = new EstoqueGradeItem();
		egi3.setProduto(produto);
		egi3.setGradeItem(gradeItem3);
		egi3.setLoja(loja1);
		egi3.setEmpresa(emp1);
		egi3.setEstoqueAtual(3);
		egi3.setEstoqueMinimo(3);
		
			loja1.addEstoqueGradeItem(egi3);
			produto.addEstoqueGradeItem(egi3);
		
		
		

		if (args.length == 0) {
			System.out.println(" >>> HELP ");
			System.out.println("       - deve ser informado o parametro para qual metodo de persistencia deve ser usado ");
			System.out.println("       - DB4o|Hibernate ");
			return;
		}

		if ("DB4o".equals(args[0])) {
			ObjectContainer db = Db4o.openFile("DB2-TGA1.yap");
			// CORES
			db.set(cor1);
			db.set(cor2);
			// TAMANHOS
			db.set(tam1);
			db.set(tam2);
			db.set(tam3);
			db.set(tam4);
			db.set(tam5);
			// HOLDING
			db.set(h);
			// EMPRESAS
			db.set(emp1);
			db.set(emp2);
			// LOJAS
			db.set(loja1);
			db.set(loja2);
			db.set(loja3);
			// DEPARTAMENTOS
			db.set(dep1);
			db.set(dep2);
			db.set(dep3);
			db.set(dep4);
			// SEÇÕES
			db.set(sec1);
			db.set(sec2);
			// CATEGORIAS
			db.set(cat1);
			db.set(cat2);
			db.set(cat3);
			// PRODUTO
			db.set(produto);
			// GRADES
			db.set(grade1);
			db.set(grade2);
			db.set(grade3);
			// GRADEITENS
			db.set(gradeItem1);
			db.set(gradeItem2);
			db.set(gradeItem3);
			db.set(gradeItem4);
			db.set(gradeItem5);
			// ESTOQUEGRADEITENS
			db.set(egi1);
			db.set(egi2);
			db.set(egi3);

			System.out.println("Dados armazenados no DB4O. >>> Entity: " + ((Holding) db.get(h).next()).getNome());

			db.close();
			System.exit(0);

		} else if ("mysql".equals(args[0])) {	

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("TGA1");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			// CORES
			em.persist(cor1);
			em.persist(cor2);
			// TAMANHOS
			em.persist(tam1);
			em.persist(tam2);
			em.persist(tam3);
			em.persist(tam4);
			em.persist(tam5);
			// HOLDING
			em.persist(h);
			// EMPRESAS
			em.persist(emp1);
			em.persist(emp2);
			// LOJAS
			em.persist(loja1);
			em.persist(loja2);
			em.persist(loja3);
			// DEPARTAMENTOS
			em.persist(dep1);
			em.persist(dep2);
			em.persist(dep3);
			em.persist(dep4);
			// SEÇÕES
			em.persist(sec1);
			em.persist(sec2);
			// CATEGORIAS
			em.persist(cat1);
			em.persist(cat2);
			em.persist(cat3);
			// PRODUTO
			em.persist(produto);
			// GRADES
			em.persist(grade1);
			em.persist(grade2);
			em.persist(grade3);
			// GRADEITENS
			em.persist(gradeItem1);
			em.persist(gradeItem2);
			em.persist(gradeItem3);
			em.persist(gradeItem4);
			em.persist(gradeItem5);
			// ESTOQUEGRADEITENS
			em.persist(egi1);
			em.persist(egi2);
			em.persist(egi3);
			
			System.out.println(" Dados armazenados no MySQL. " + '\n' + " Entity: " + h.getNome());
			
			em.getTransaction().commit();
			em.close();
			System.exit(0);
			
		} else if ("pgsql".equals(args[0])) {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("brinks");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			
			// CORES
			em.persist(cor1);
			em.persist(cor2);
			// TAMANHOS
			em.persist(tam1);
			em.persist(tam2);
			em.persist(tam3);
			em.persist(tam4);
			em.persist(tam5);
			// HOLDING
			em.persist(h);
			// EMPRESAS
			em.persist(emp1);
			em.persist(emp2);
			// LOJAS
			em.persist(loja1);
			em.persist(loja2);
			em.persist(loja3);
			// DEPARTAMENTOS
			em.persist(dep1);
			em.persist(dep2);
			em.persist(dep3);
			em.persist(dep4);
			// SEÇÕES
			em.persist(sec1);
			em.persist(sec2);
			// CATEGORIAS
			em.persist(cat1);
			em.persist(cat2);
			em.persist(cat3);
			// PRODUTO
			em.persist(produto);
			// GRADES
			em.persist(grade1);
			em.persist(grade2);
			em.persist(grade3);
			// GRADEITENS
			em.persist(gradeItem1);
			em.persist(gradeItem2);
			em.persist(gradeItem3);
			em.persist(gradeItem4);
			em.persist(gradeItem5);
			// ESTOQUEGRADEITENS
			em.persist(egi1);
			em.persist(egi2);
			em.persist(egi3);
			
			System.out.println(" Dados armazenados no PostgreSQL. " + '\n' + " Entity: " + h.getNome());
			
			em.getTransaction().commit();
			em.close();
			System.exit(0);
		}
	}
}