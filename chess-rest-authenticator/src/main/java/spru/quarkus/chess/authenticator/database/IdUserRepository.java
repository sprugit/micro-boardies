package spru.quarkus.chess.authenticator.database;

import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import spru.quarkus.chess.authenticator.database.objects.IdentifiedUser;

@ApplicationScoped
public class IdUserRepository {
	
	@Inject
	Logger logger;
	
	@Inject
	EntityManager em;
	
	public void persist(IdentifiedUser user) throws Exception {
		em.persist(user);
	}
	
	public IdentifiedUser findById(Long id) {
		return em.find(IdentifiedUser.class, id);
	}
}
