package cooksys.sbm.api.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.sbm.api.service.UserService;
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
	public String index() {
		return userService.index();
		}
	
	@PostMapping
	@ApiOperation(value = "", nickname = "getAllUsers")
	public String postUser() {
		return userService.index();
		}
	
	@GetMapping("@{Username}")
	public String getUser()
	{
		return "";
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
