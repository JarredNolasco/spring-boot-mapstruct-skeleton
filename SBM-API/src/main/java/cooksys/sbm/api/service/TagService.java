package cooksys.sbm.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cooksys.component.ServiceUtilities;
import cooksys.component.ServiceUtilities.IdChecker;
import cooksys.sbm.db.entity.Tag;
import cooksys.sbm.db.entity.Tweet;
import cooksys.sbm.db.entity.User;
import cooksys.sbm.db.entity.repository.TagRepository;
import cooksys.sbm.db.entity.repository.UserRepository;
import cooksys.sbm.dto.dto.TagDto;
import cooksys.sbm.dto.mapper.TagMapper;
import cooksys.sbm.dto.mapper.UserMapper;

@Service
public class TagService {
	public class UserService {
		
		private final TagRepository tagRepository;
		private final TagMapper tagMapper;
		private final ServiceUtilities serviceUtilities;
		private final IdChecker idChecker;
		
		public UserService(TagRepository tagRepository, TagMapper tagMapper,ServiceUtilities serviceUtilities)
		{
			super();
			this.tagRepository = tagRepository;
			this.tagMapper = tagMapper;
			this.serviceUtilities = serviceUtilities;
			this.idChecker = serviceUtilities.buildIdChecker(Tag.class, this::has);
		}

		public boolean has(Long id) {
	        if (id != null)
	            return tagRepository.exists(id);
	        return false;
	    }

	public List<TagDto> getIndex() {
		 return tagRepository
	                .findAll()
	                .stream()
	                .map(tagMapper::toTagDto)
	                .collect(Collectors.toList());
	}

	public Boolean checkIfExist() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tweet> getTagLabels(String tag) {
		// TODO Auto-generated method stub
		return null;
	}

}
