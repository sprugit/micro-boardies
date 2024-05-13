package spru.quarkus.chess.authenticator.dto.objects;

import java.sql.Timestamp;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.json.bind.annotation.JsonbNillable;
import jakarta.json.bind.annotation.JsonbProperty;

@Schema(description = "Fetch Other User Profile Data")
public class getUserDTO {
	
	@JsonbProperty
	@Schema(required = true, nullable = false)
	private long id;
	@JsonbProperty
	@JsonbNillable
	@Schema(required = true, nullable = true)
	private String first_name;
	@JsonbProperty
	@JsonbNillable
	@Schema(required = true, nullable = true)
	private String last_name;
	@JsonbProperty
	@JsonbNillable
	@Schema(required = true, nullable = true)
	private String nickname;
	@JsonbProperty
	@JsonbNillable
	@Schema(required = true, nullable = true)
	private Timestamp last_online;
	
	public void getUser() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Timestamp getLast_online() {
		return last_online;
	}

	public void setLast_online(Timestamp last_online) {
		this.last_online = last_online;
	}

	@Override
	public String toString() {
		return "getUserDTO [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", nickname="
				+ nickname + ", last_online=" + last_online + "]";
	}
}
