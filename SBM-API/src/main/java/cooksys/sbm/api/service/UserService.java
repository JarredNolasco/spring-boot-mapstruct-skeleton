package cooksys.sbm.api.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cooksys.component.ServiceUtilities;
import cooksys.component.ServiceUtilities.IdChecker;
import cooksys.sbm.db.entity.Tweet;
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
	
    public void delete(String username) {
        //idChecker.exists(id);
    	User user = userRepository.findByUsername(username);
        user.setExist(false);
    }
    
    public void patch(String username, UserDto userDto) {
        //idChecker.exists(id);
        userRepository.save(serviceUtilities.copyNonNullProperties(userMapper.toUser(userDto), userRepository.findByUsername(username)));
    }

	public void postUserFollow(String username, UserDto userDto) {
		// TODO Auto-generated method stub
		User userToFollow = userRepository.findByUsername(username);
		User currentUser = userRepository.findByUsername(userDto.getUsername());
		currentUser.getFollowing().add(userToFollow);
		userRepository.save(currentUser);
	}

	public void postUserUnfollow(String username, UserDto userDto) {
		
		User userToFollow = userRepository.findByUsername(username);
		User currentUser = userRepository.findByUsername(userDto.getUsername());
		currentUser.getFollowing().remove(userToFollow);
		userRepository.save(currentUser);
		
	}

	public Boolean userNameExist(String username) {
		
		User user = userRepository.findByUsername(username);
		if(user.getExist() == true)
		{
			return true;
		}
		return false;
	}

	public Boolean userNameAvailable(String username) {
		User user = userRepository.findByUsername(username);
		
		if(user == null )
		{
			return true;
		}
		return false;
	}

	public Set<User> getUserFollowers(String username) {
		User user = userRepository.findByUsername(username);
		return user.getFollowers();
	}

	public Set<User> getUserFollowing(String username) {
		User user = userRepository.findByUsername(username);
		return user.getFollowing();
	}

	public Set<Tweet> getMentions(String username) {
		User user = userRepository.findByUsername(username);
		return user.getMentionedtweets();
	}

	
    
    
    
}
