package com.faculdade.tga1.runner;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.faculdade.tga1.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Trabalho DB2 - GA1
 *
 * Integrantes:
 *      Paulo Grabin - plgrabin@gmail.com
 *      Iuri Andreazza - iuri.andreazza@gmail.com
 *      Talita Audibert - tali.audibert@gmail.com
 *      Eduardo Pereira da Silva - eduardobursa@gmail.com
 *
 *
 * Created by iuriandreazza on 13/03/14.
 */
public class RunnerApp {

	public static void main(String[] args) {


		Holding hl = new Holding();
		hl.setNome("Holding SXL");

		Empresa emp = new Empresa();
		emp.setHolder(hl);
		emp.setFantasia("Empresa 1");
		emp.setLogradouro("Rua Teste");
		emp.setRazaoSocial("Empresa JURIDICA X");

		hl.setEmpresas(new ArrayList<Empresa>());
		hl.getEmpresas().add(emp);

		Loja lj = new Loja();
		lj.setNome("Loja Y");
		lj.setEmpresa(emp);
		lj.setNroFuncionario(100);
		lj.setDataAbertura(Calendar.getInstance().getTime());


		emp.setLojas(new ArrayList<Loja>());
		emp.getLojas().add(lj);

		Departamento dep = new Departamento();
		dep.setEmpresa(emp);
		dep.setLoja(lj);
		dep.setNome("Departamento RH Teste");

		Departamento dep1 = new Departamento();
		dep1.setEmpresa(emp);
		dep1.setLoja(lj);
		dep1.setNome("Departamento RH Teste");

		lj.setDepartamentos(new ArrayList<Departamento>());
		lj.getDepartamentos().add(dep);
		lj.getDepartamentos().add(dep1);

		Secao sec = new Secao();
		sec.setNome("Secao T");
		sec.setLoja(lj);
		sec.setEmpresa(emp);
		sec.setDepartamento(dep);

		dep.setSecoes(new ArrayList<Secao>());
		dep.getSecoes().add(sec);


		Categoria categoria = new Categoria();
		categoria.setNome("Categoria");
		categoria.setSecao(sec);

		categoria.setProdutos(new ArrayList<Produto>());

		Produto produto = new Produto();
		produto.setCategoria(categoria);
		produto.setNome("Produto");
		produto.setEstoqueAtual(10);
		produto.setEstoqueMinimo(2);

		categoria.getProdutos().add(produto);


		Cor cor = new Cor();
		cor.setNome("Cor 1");

		Tamanho tamanho = new Tamanho();
		tamanho.setNome("GG");

		Grade gr = new Grade();
		gr.setNome("Grade 1");
		gr.setGradesItens(new ArrayList<GradeItem>());
		gr.setProdutos(new ArrayList<Produto>());
		gr.getProdutos().add(produto);
		produto.setGrade(gr);

		GradeItem gItem = new GradeItem();
		gItem.setNome("Nome Grade Item");
		gItem.setCor(cor);
		gItem.setTamanho(tamanho);
		gItem.setGrade(gr);

		EstoqueGradeItem egi = new EstoqueGradeItem();
		egi.setEmpresa(emp);
		egi.setLoja(lj);
		egi.setEstoqueAtual(200);
		egi.setEstoqueMinimo(0);
		egi.setGradeItem(gItem);
		egi.setProduto(produto);


		if (args.length == 0) {
			System.out.println(" >>> HELP ");
			System.out.println("       - deve ser informado o parametro para qual metodo de persistencia deve ser usado ");
			System.out.println("       - DB4o|Hibernate ");
			return;
		}

		if ("DB4o".equals(args[0])) {
			ObjectContainer db = Db4o.openFile("DB2-TGA1.yap");
			db.set(hl);
			db.set(sec);
			db.set(categoria);
			db.set(gr);
			db.set(cor);
			db.set(tamanho);
			db.set(gItem);
			db.set(egi);

			System.out.println(" >>> Entity: " + ((Holding) db.get(hl).next()).getNome());

			db.close();

		} else if ("mysql".equals(args[0])) {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("TGA1");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(hl);
			em.persist(sec);
			em.persist(categoria);
			em.persist(gr);
			em.persist(cor);
			em.persist(tamanho);
			em.persist(gItem);
			em.persist(egi);
			em.getTransaction().commit();
		} else if ("pgsql".equals(args[0])) {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("brinks");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(hl);
			em.persist(sec);
			em.persist(categoria);
			em.persist(gr);
			em.persist(cor);
			em.persist(tamanho);
			em.persist(gItem);
			em.persist(egi);
			em.getTransaction().commit();
		}


	}

}
