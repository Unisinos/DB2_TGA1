package com.faculdade.tga1.runner;

import com.faculdade.tga1.entity.Holding;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by iuriandreazza on 13/03/14.
 */
public class RunnerApp {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TGA1");
        EntityManager em = emf.createEntityManager();

        Holding hl = new Holding();

        em.getTransaction().begin();
        em.persist(hl);
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
