package spru.quarkus.chess.authenticator.database;

import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import spru.quarkus.chess.authenticator.database.objects.User;

@ApplicationScoped
public class UserRepository {
	
	@Inject
	Logger logger;
	
	@Inject
	EntityManager em;
	
	public void persist(User user) throws Exception {
		em.persist(user);
	}
	
	public User findById(Long id) {
		return em.find(User.class, id);
	}
}