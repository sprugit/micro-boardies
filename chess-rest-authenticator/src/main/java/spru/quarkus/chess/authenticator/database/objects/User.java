package spru.quarkus.chess.authenticator.database.objects;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import spru.quarkus.chess.authenticator.utils.PasswordHasher;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "EMAIL", length = 254, nullable = false)
	public String email;
	
	@Column(name = "USERNAME", length = 50, nullable = false)
	public String username;
	
	@Column(name = "PASSWORD", length = 50, nullable = false)
	public String password;
	
	@Column(name = "FIRST_NAME", length = 50, nullable = true)
	public String first_name;
	
	@Column(name = "LAST_NAME", length = 50, nullable = true)
	public String last_name;
	
	@Column(name = "SALT", length = 50, nullable = false)
	public String salt;
	
	@Column(name = "REGISTERED", nullable = false)
	public Timestamp registered;
	
	@Column(name = "LAST_ONLINE", nullable = true)
	public Timestamp last_online;
	
	@Column(name = "NICKNAME", length = 50, nullable = true)
	public String nickname;
	
	public User() {
	}
	
	public User(String username, String password, String email) {
		this.username = username;
		this.email = email;
		
		String[] hashed = PasswordHasher.hash(password);
		
		this.password = hashed[0];
		this.salt = hashed[1];
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", password=" + password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", salt=" + salt + ", registered=" + registered
				+ ", last_online=" + last_online + ", nickname=" + nickname + "]";
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getSalt() {
		return salt;
	}

	public Timestamp getRegistered() {
		return registered;
	}

	public Timestamp getLast_online() {
		return last_online;
	}

	public String getNickname() {
		return nickname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setLast_online(Timestamp last_online) {
		this.last_online = last_online;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}