package spru.quarkus.chess.authenticator;

import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import spru.quarkus.chess.authenticator.database.IdUserRepository;
import spru.quarkus.chess.authenticator.database.UserRepository;
import spru.quarkus.chess.authenticator.database.objects.IdentifiedUser;
import spru.quarkus.chess.authenticator.dto.mappers.UserDTOMapper;
import spru.quarkus.chess.authenticator.dto.objects.getUserDTO;

@Path("/api/v1/users")
@ApplicationScoped
public class UserResource {
	
	@Inject
	UserDTOMapper userFetchMapper;
	
	@Inject
	UserRepository ur;
	
	@Inject
	IdUserRepository idr;
	
	@Inject
	Logger logger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public getUserDTO getUser(@PathParam("id") long id) {
    	logger.debug("Requested user " + id);
    	IdentifiedUser u = idr.findById(id);
    	logger.debug("Found " + u.toString());
    	logger.info(u);
        getUserDTO ret = userFetchMapper.toResource(u.getUser());
        ret.setId(id);
        return ret;
    }
    
    /*
    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/signup")
    public Response signup(User u) {
    	try {
    		ur.persist(u);
    		return Response.status(201).entity(u).build();
    	} catch(Exception e) {
    		return Response.status(409).build();
    	}
    }
    
    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(LoginUser u) {
    	return Response.status(0).build();
    }*/
    
}
