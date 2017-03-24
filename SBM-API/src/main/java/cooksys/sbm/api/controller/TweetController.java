package cooksys.sbm.api.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cooksys.sbm.api.service.TweetService;
import cooksys.sbm.db.entity.embeddable.Credentials;
import cooksys.sbm.dto.dto.TweetDto;
import cooksys.sbm.dto.validation.group.RequiredFieldsNotNull;
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
	public List<TweetDto> index() {
		return tweetSerivce.index();
		}
	
	@PostMapping
	@ApiOperation(value = "", nickname = "postTweet")
	public TweetDto postTweet(@RequestBody @Validated(RequiredFieldsNotNull.class) TweetDto tweetDto, HttpServletResponse httpResponse) {
		Long Id = tweetSerivce.post(tweetDto);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
		return tweetSerivce.get(Id);
		
		}
	
	@GetMapping("{id}")
	public TweetDto getTweet(@RequestParam Long id)
	{
		return tweetSerivce.get(id);
	}
	
	@DeleteMapping("{id}")
	public void deleteTweet(@RequestParam Long id)
	{
		tweetSerivce.delete(id);
	}
	
	@PostMapping("{id}/like")
	public void postTweetLike(@RequestBody @Validated(RequiredFieldsNotNull.class) Credentials cred,@RequestParam Long id)
	{
		tweetSerivce.postTweetLike(cred,id);
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
	public String getTagsFromTweet(@RequestParam Long id)
	{
		return tweetSerivce.getTagFromTweet(id);
	}
	
	@GetMapping("{id}/likes")
	public String getLikesFromTweet()
	{
		return "";
	}
	
	@GetMapping("{id}/context")
	public String getContextFromTweet(Long Id)
	{
		return tweetSerivce.getContextFromTweet(Id);
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
