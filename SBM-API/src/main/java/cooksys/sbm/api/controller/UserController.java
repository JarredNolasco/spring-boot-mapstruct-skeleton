package cooksys.sbm.api.controller;

import java.util.List;

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
	public String ValidateUsername(){
		return "";
	}
	
	@GetMapping("validate/username/available/@{username}")
	public String AvailableUsername(){
		return "";
		
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
	public String patchUser()
	{
		return "";
	}
	
	@DeleteMapping("@{Username}")
	public String deleteUser()
	{
		return "";
	}
	
	@PostMapping("@{Username}/follow")
	public String PostUserFollow()
	{
		return "";
	}
	
	@PostMapping("@{Username}/unfollow")
	public String PostUserUnfollow()
	{
		return "";
	}
	
	@GetMapping("@{Username}/feed")
	public String GetUserFeed()
	{
		return "";
	}
	
	@GetMapping("@{Username}/tweets")
	public String GetUserTweets()
	{
		return "";
	}
	
	@GetMapping("@{Username}/mentions")
	public String GetUserMentions()
	{
		return "";
	}
	
	@GetMapping("@{Username}/followers")
	public String GetUserFollowers()
	{
		return "";
	}
	
	@GetMapping("@{Username}/following")
	public String GetUserFollowing()
	{
		return "";
	}
	
	
}
