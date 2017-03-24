package cooksys.sbm.dto.mapper;

import org.mapstruct.Mapper;

import cooksys.sbm.db.entity.Tag;
import cooksys.sbm.dto.dto.TagDto;

@Mapper(componentModel = "spring")
public interface TagMapper {

	TagDto toTagDto(Tag tag);
	
	Tag toTag(TagDto tagDto);
	
}
