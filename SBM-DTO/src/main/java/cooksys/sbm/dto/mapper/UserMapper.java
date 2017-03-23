package cooksys.sbm.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;



import cooksys.sbm.db.entity.User;
import cooksys.sbm.dto.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
	

	UserDto toUserDto(User user);

	User toUser(UserDto userDto);

}
