package cooksys.sbm.api.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cooksys.sbm.api.service.UserService;
import cooksys.sbm.db.entity.Tweet;
import cooksys.sbm.db.entity.User;
import cooksys.sbm.db.entity.repository.UserRepository;
import cooksys.sbm.dto.dto.UserDto;
import cooksys.sbm.dto.validation.group.RequiredFieldsNotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@Validated
@RequestMapping("users")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService)
	{
		super();
		this.userService = userService;
	}
	
	@GetMapping("validate/username/exists/@{username}")
	public Boolean UsernameExist(@RequestParam String username){
		return userService.userNameExist(username);
	}
	
	@GetMapping("validate/username/available/@{username}")
	public Boolean UsernameAvailable(@RequestParam String username){
		return userService.userNameAvailable(username);
		
	}
	
	@GetMapping
	@ApiOperation(value = "", nickname = "getAllUsers")
	public List<UserDto> index() {
		return userService.index();
		}
	
	@PostMapping
	@ApiOperation(value = "", nickname = "createUser")
	public UserDto postUser(@RequestBody @Validated(RequiredFieldsNotNull.class) UserDto userDto, HttpServletResponse httpResponse) {
		String username = userService.post(userDto);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
		return userService.get(username);
		}
	
	@GetMapping("@{Username}")
	@ApiOperation(value = "", nickname = "getUser")
	public UserDto getUser(@RequestParam String username)
	{
		return userService.get(username);
	}
	
	@PatchMapping("@{Username}")
	@ApiOperation(value = "", nickname = "updateUser")
	public void patchUser(@RequestParam String username, @RequestBody @Validated UserDto userDto, HttpServletResponse httpResponse)
	{
		userService.patch(username, userDto);
	}
	
	@DeleteMapping("@{Username}") //Needs to be changed so when called it just changes the exist variable to true
	@ApiOperation(value = "", nickname = "deleteUser")
	public String deleteUser(@RequestParam String username)
	{
		userService.delete(username);
		return "userDeleted";
	}
	
	@PostMapping("@{Username}/follow")
	public String PostUserFollow(@RequestParam String username, @RequestBody @Validated UserDto userDto, HttpServletResponse httpResponse)
	{
		userService.postUserFollow(username,userDto);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
		return "Follwed User";
	}
	
	@DeleteMapping("@{Username}/unfollow")
	public String PostUserUnfollow(@RequestParam String username, @RequestBody @Validated UserDto userDto, HttpServletResponse httpResponse)
	{
		userService.postUserUnfollow(username,userDto);
		return "Person Unfollowed";
	}
	
	@GetMapping("@{Username}/feed")
	public String GetUserFeed()
	{
		return ""; // This will come come fron the tweet rep
	}
	
	@GetMapping("@{Username}/tweets")
	public String GetUserTweets()
	{
		return ""; // This will come come fron the tweet repo
	}
	
	@GetMapping("@{Username}/mentions")
	public Set<Tweet> GetUserMentions(@RequestParam String username)
	{
		return userService.getMentions(username);
	}
	
	@GetMapping("@{Username}/followers")
	public Set<User> GetUserFollowers(@RequestParam String username)
	{
		 return userService.getUserFollowers(username);
		
		
	}
	
	@GetMapping("@{Username}/following")
	public Set<User> GetUserFollowing(@RequestParam String username)
	{
		return userService.getUserFollowing(username);
	}
	
	
}
