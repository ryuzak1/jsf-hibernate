package conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    public static EntityManagerFactory factory = null;

    static {
        init();
    }

    public static void init() {

        try {
            if (factory == null) {
                factory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
                System.out.println("Conectado");

            }
        } catch (Exception e) {
            System.out.println("Erro na conexão");
            System.out.println(e.getMessage());
            System.out.println("_____");
            System.out.println(e.getCause());

        }

    }

    public static EntityManager getEntityManger() {
        return factory.createEntityManager();
    }

    public static Object getPrimaryKey(Object entity){
        return factory.getPersistenceUnitUtil().getIdentifier(entity);

    }

}
