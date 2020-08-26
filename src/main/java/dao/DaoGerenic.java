package dao;



import conexao.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;


public class DaoGerenic<E> {

    private EntityManager entityManager = HibernateUtil.getEntityManger();

    public void salvar(E entidade){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entidade);
        transaction.commit();
    }

    public E pesquisar(E entidade){
        Object id = HibernateUtil.getPrimaryKey(entidade);
        E e = (E)entityManager.find(entidade.getClass(),id);
        return  e;
    }

    public E pesquisarComId(long id, Class<E> entidade){

        E e = (E) entityManager.find(entidade,id);
        return  e;
    }

    public E updateMerge(E entidade){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        E entidadeSalva = entityManager.merge(entidade);
        transaction.commit();
        return entidade;
    }

    public void deleteID(E entidade){

        Object id = HibernateUtil.getPrimaryKey(entidade);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String sql = "delete from"+entidade.getClass().getSimpleName().toLowerCase()+
                " where id="+id;
        System.out.println(sql);
        entityManager.createNativeQuery("delete from "+entidade.getClass().getSimpleName().toLowerCase()+
                " where id="+id).executeUpdate();
        transaction.commit();

    }

    public List<E> listar(Class<E> entidade){

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<E> lista = entityManager.createQuery("from "+entidade.getName()).getResultList();
        transaction.commit();

        return lista;



    }

    public EntityManager getEntityManager(){
        return entityManager;
    }



}
