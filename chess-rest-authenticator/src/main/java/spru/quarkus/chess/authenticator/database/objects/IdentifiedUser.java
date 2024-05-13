package spru.quarkus.chess.authenticator.database.objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "identified_users")
public class IdentifiedUser { //todo faz com extends. é o que faz sentido
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL")
	private User user;
	
	public IdentifiedUser() {
		super();
	}
	
	public IdentifiedUser(User u) {
		user = u;
	}


	public long getId() {
		return id;
	}
	
	public User getUser() {
		return user;
	}
	
	public String toString() {
		return "ID " + id + user.toString(); 
	}
}