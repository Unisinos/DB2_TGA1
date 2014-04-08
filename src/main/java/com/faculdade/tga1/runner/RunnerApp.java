package com.faculdade.tga1.runner;

import java.util.ArrayList;
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
 * Trabalho DB2 - GA1
 *
 * Integrantes:
 *      Paulo Grabin - plgrabin@gmail.com
 *      Iuri Andreazza - iuri.andreazza@gmail.com
 *      Talita Audibert - tali.audibert@gmail.com
 *      Eduardo Pereira da Silva - eduardobursa@gmail.com
 *
 * Created by iuriandreazza on 13/03/14.
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
		Tamanho tamanho1 = new Tamanho();
		tamanho1.setNome("33");
		
		Tamanho tamanho2 = new Tamanho();
		tamanho2.setNome("34");		
		
		Tamanho tamanho3 = new Tamanho();
		tamanho3.setNome("35");
		
		Tamanho tamanho4 = new Tamanho();
		tamanho4.setNome("36");
		
		Tamanho tamanho5 = new Tamanho();
		tamanho5.setNome("37");
		
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
		emp1.setHolder(h);
		emp1.setRazaoSocial("Juca Sapato Feminino Ltda");
		emp1.setFantasia("Juca Sapato");
		emp1.setLogradouro("Rua Zé Teodoro, 666");
		
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
		dep4.setLoja(loja3);
		dep4.setNome("Feminino");

			/**
			 * DEPARTAMENTO TO LOJAS
			 */
			loja1.addDepartamento(dep1);
			loja1.addDepartamento(dep2);
			loja1.addDepartamento(dep3);
			loja2.addDepartamento(dep4);

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
		cat1.setNome("Rasteirinha");
		cat1.setSecao(sec1);

		Categoria cat3 = new Categoria();
		cat1.setNome("Bolsa de mão ");
		cat1.setSecao(sec2);

			/**
			 * CATEGORIA TO SEÇÃO
			 */
			sec1.addCategoria(cat1);
			sec1.addCategoria(cat2);
			sec2.addCategoria(cat3);

		/**
		 * GRADE
		 */
		Grade grade = new Grade();
		grade.setNome("Grade 1");

		/**
		 * PRODUTO
		 */
		Produto produto = new Produto();
		produto.setNome("Scarpin Velasquez");
		produto.setEstoqueAtual(10);
		produto.setEstoqueMinimo(10);
		produto.setCategoria(cat1);
		produto.setGrade(grade);

			/**
			 * PRODUTO TO CATEGORIA
			 */
			cat1.addProduto(produto);
	
			/**
			 * PRODUTO TO GRADE
			 */
			grade.addProduto(produto);



		/**
		 * GRADEITEM
		 */
		GradeItem gradeItem = new GradeItem();
		gradeItem.setNome("Nome Grade Item");
		gradeItem.setCor(cor2);
		gradeItem.setTamanho(tamanho);
		gradeItem.setGrade(grade);
		
		grade.addGradeItem(gradeItem);
		cor2.addGradeItem(gradeItem);
		tamanho.addGradeItem(gradeItem);

		/**
		 * ESTOQUEGRADEITEM
		 */
		EstoqueGradeItem egi = new EstoqueGradeItem();
		egi.setEmpresa(emp1);
		egi.setLoja(loja1);
		egi.setEstoqueAtual(200);
		egi.setEstoqueMinimo(0);
		egi.setGradeItem(gradeItem);
		egi.setProduto(produto);
		
		loja1.addEstoqueGradeItem(egi);
		produto.addEstoqueGradeItem(egi);

		if (args.length == 0) {
			System.out.println(" >>> HELP ");
			System.out.println("       - deve ser informado o parametro para qual metodo de persistencia deve ser usado ");
			System.out.println("       - DB4o|Hibernate ");
			return;
		}

		if ("DB4o".equals(args[0])) {
			ObjectContainer db = Db4o.openFile("DB2-TGA1.yap");
			db.set(h);
			db.set(sec);
			db.set(cat1);
			db.set(grade);
			db.set(cor2);
			db.set(tamanho);
			db.set(gradeItem);
			db.set(egi);

			System.out.println(" >>> Entity: " + ((Holding) db.get(h).next()).getNome());

			db.close();

		} else if ("mysql".equals(args[0])) {	

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("TGA1");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(h);
			em.persist(sec);
			em.persist(cat1);
			em.persist(grade);
			em.persist(cor2);
			em.persist(tamanho);
			em.persist(gradeItem);
			em.persist(egi);
			em.getTransaction().commit();
			
			em.close();
			System.exit(0);
			
		} else if ("pgsql".equals(args[0])) {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("brinks");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(h);
			em.persist(sec);
			em.persist(cat1);
			em.persist(grade);
			em.persist(cor2);
			em.persist(tamanho);
			em.persist(gradeItem);
			em.persist(egi);
			em.getTransaction().commit();
			
			em.close();
			System.exit(0);
		}
	}
}
