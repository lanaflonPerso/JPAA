import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Hristo on 28.07.2016 г..
 */
public class CreateNewUser {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("blog-db");
        EntityManager em = emf.createEntityManager();
        try {
            Query allPostsQuery = em.createQuery(
                    "SELECT p FROM Post p JOIN FETCH p.author");
            List<Post> posts =
                    allPostsQuery.getResultList();
            for (Post post : posts) {
                System.out.println(post);
            }

        }
        finally {
            em.close();
            emf.close();
        }
    }

}
