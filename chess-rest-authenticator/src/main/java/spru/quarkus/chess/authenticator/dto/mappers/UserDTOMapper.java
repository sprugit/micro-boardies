package spru.quarkus.chess.authenticator.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import spru.quarkus.chess.authenticator.database.objects.User;
import spru.quarkus.chess.authenticator.dto.objects.getUserDTO;

//https://camel.apache.org/camel-quarkus/3.8.x/reference/extensions/mapstruct.html include annotation processor
//Mapped classses must have getters and setters defined (at least getters when its relevant)
@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
//@Mapper(componentModel = "cdi")
public interface UserDTOMapper {

	//@Mapping(source = "id",target = "id")
	@Mapping(source = "first_name",target = "first_name")
	@Mapping(source = "last_name",target = "last_name")
	@Mapping(source = "nickname",target = "nickname")
	@Mapping(source = "last_online",target = "last_online")
	getUserDTO toResource(User u);
	
}
