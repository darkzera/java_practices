import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class main {
    public static void main(String[] args) {
        AlunoController ac = new AlunoController();

        // Criar gerenciador de entidades db :: baseado em -> persistence.xml
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part2-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        // 2.1 Instancias
        Estado estadoAdd = new Estado("Minas gf", "MG");
        Aluno aluno1 = new Aluno ("Dani", 13, estadoAdd);
        Aluno aluno2 = new Aluno ("Almeidinha", 19, estadoAdd);
        Aluno aluno3 = new Aluno ("Dani", 15, estadoAdd);

        // 2.2 iniciar transacao p persistir os dados (obj -> db)
        entityManager.getTransaction().begin();
        entityManager.persist(estadoAdd);

        entityManager.persist(aluno1);
        entityManager.persist(aluno2);
        entityManager.persist(aluno3);
        entityManager.getTransaction().commit();
//        Esses erros nos logs sao normais ---> continuar


        // Consultas -- test

        // Basicas
        // O entity manager nao eh capaz de fazer consultas mais complexas
        // entao usamos alguns artificios: JQPL,
        Aluno alunoFound = entityManager.find(Aluno.class, 1);
        System.out.println(alunoFound);

        // JPQL
        String sqlString = "select a from Aluno a where a.estado.nome = :estado";

        List<Aluno> alunosFromEstado = entityManager
                .createQuery(sqlString, Aluno.class)
                .setParameter("estado", estadoAdd)
                .getResultList();

        alunosFromEstado.forEach(System.out::println);

        // # Finaliza o gerenciador
        entityManager.close();
        entityManagerFactory.close();





    }
}
