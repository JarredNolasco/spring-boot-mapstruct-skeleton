package cooksys.sbm.api.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.sbm.api.service.TagService;
import cooksys.sbm.api.service.TweetService;
import io.swagger.annotations.ApiOperation;

@RestController
@Validated
@RequestMapping("tweets")
public class TweetController {
	
	private TweetService tweetSerivce; 
	
	public TweetController(TweetService tweetSerivce)
	{
		super();
		this.tweetSerivce = tweetSerivce;
	}

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllTweets")
	public String index() {
		return tweetSerivce.index();
		}
	
	@PostMapping
	@ApiOperation(value = "", nickname = "postTweet")
	public String postTweet() {
		return "";
		}
	
	@GetMapping("{id}")
	public String getTweet()
	{
		return "";
	}
	
	@DeleteMapping("{id}")
	public String deleteTweet()
	{
		return "";
	}
	
	@PostMapping("{id}/like")
	public String postTweetLike()
	{
		return "";
	}
	
	
	@PostMapping("{id}/reply")
	public String postTweetReply()
	{
		return "";
	}
	
	@PostMapping("{id}/repost")
	public String postTweetRepost()
	{
		return "";
	}
	
	@GetMapping("{id}/tags")
	public String getTagsFromTweet()
	{
		return "";
	}
	
	@GetMapping("{id}/likes")
	public String getLikesFromTweet()
	{
		return "";
	}
	
	@GetMapping("{id}/context")
	public String getContextFromTweet()
	{
		return "";
	}
	
	@GetMapping("{id}/replies")
	public String getRepliesFromTweet()
	{
		return "";
	}
	
	@GetMapping("{id}/repost")
	public String getRepostFromTweet()
	{
		return "";
	}
}
