package cooksys.sbm.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cooksys.component.ServiceUtilities;
import cooksys.component.ServiceUtilities.IdChecker;
import cooksys.sbm.db.entity.User;
import cooksys.sbm.db.entity.repository.UserRepository;
import cooksys.sbm.dto.dto.UserDto;
import cooksys.sbm.dto.mapper.UserMapper;




@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final ServiceUtilities serviceUtilities;
	private final IdChecker idChecker;
	
	public UserService(UserRepository userRepository, UserMapper userMapper,ServiceUtilities serviceUtilities)
	{
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.serviceUtilities = serviceUtilities;
		this.idChecker = serviceUtilities.buildIdChecker(User.class, this::has);
	}

	public String post(UserDto userDto) {
        return userRepository.save(userMapper.toUser(userDto)).getUsername();
    }
	
	 public boolean has(Long id) {
	        if (id != null)
	            return userRepository.exists(id);
	        return false;
	    }
	 
	 public List<UserDto> index() {
	        return userRepository
	                .findAll()
	                .stream()
	                .map(userMapper::toUserDto)
	                .collect(Collectors.toList());
	    }

	public UserDto get(String username) {
		//return userMapper.toUserDto(userRepository.findOne(id));
		return userMapper.toUserDto(userRepository.findByUsername(username));
	}
	
    public void delete(Long id) {
        idChecker.exists(id);
        userRepository.delete(id);
    }
}
