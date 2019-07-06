package edu.mum.cs544.bank.dao;

import edu.mum.cs544.bank.domain.Account;
import edu.mum.cs544.bank.domain.EntityManagerHelper;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;


public class JPAAccountDAO implements IAccountDAO {


    public void saveAccount(Account account) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.persist(account);
    }

    public void updateAccount(Account account) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.merge(account);

    }

    public Account loadAccount(long accountnumber) {

        EntityManager em = EntityManagerHelper.getCurrent();
        EntityGraph<Account> graph
                = em.createEntityGraph(Account.class);
        graph.addSubgraph("entryList");
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", graph);
        Account account = em.find(Account.class,accountnumber,properties);
        return account;
    }

    public Collection<Account> getAccounts()
    {
        EntityManager em = EntityManagerHelper.getCurrent();
        TypedQuery<Account> query = em.createQuery("FROM Account a JOIN FETCH a.entryList",Account.class);
        Collection<Account> accountlist = query.getResultList();
        return accountlist;
    }

}
