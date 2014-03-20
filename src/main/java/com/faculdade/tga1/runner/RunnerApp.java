package com.faculdade.tga1.runner;

import com.faculdade.tga1.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TGA1");
        EntityManager em = emf.createEntityManager();

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

//        ArrayList<Dependente> d = new ArrayList<Dependente>();
//        Pessoa p = new Pessoa("Gilberto Müller");
//        Dependente d1 = new Dependente("Jamile");
//        Dependente d2 = new Dependente("Estéfane");
//        d1.setPessoa(p);
//        d2.setPessoa(p);
//        d.add(d1);
//        d.add(d2);
//        p.setDependentes(d);
//
//        em.getTransaction().begin();
//        em.persist(d1);
//        em.persist(d2);
//        em.persist(p);
//        em.getTransaction().commit();

        // Observe o id 50L
//        p = em.find(Pessoa.class, 50L);
//        for(Dependente dependentes: p.getDependentes())
//            System.out.println("Dependente: " + dependentes.getNome());
    }

}
