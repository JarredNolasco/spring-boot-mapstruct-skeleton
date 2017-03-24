package cooksys.sbm.api.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cooksys.component.ServiceUtilities;
import cooksys.component.ServiceUtilities.IdChecker;
import cooksys.sbm.db.entity.Tag;
import cooksys.sbm.db.entity.Tweet;
import cooksys.sbm.db.entity.User;
import cooksys.sbm.db.entity.embeddable.Credentials;
import cooksys.sbm.db.entity.repository.TagRepository;
import cooksys.sbm.db.entity.repository.TweetRepository;
import cooksys.sbm.db.entity.repository.UserRepository;
import cooksys.sbm.dto.dto.TweetDto;
import cooksys.sbm.dto.mapper.TweetMapper;



@Service
public class TweetService {
	
	private final TweetRepository tweetRepository;
	private final UserRepository userRepository;
	private final TagRepository tagRepository;
	private final TweetMapper tweetMapper;
	private final ServiceUtilities serviceUtilities;
	private final IdChecker idChecker;
	
	public TweetService(UserRepository userRepository,TagRepository tagRepository,TweetRepository tweetRepository, TweetMapper tweetMapper,ServiceUtilities serviceUtilities)
	{
		super();
		this.tweetRepository = tweetRepository;
		this.userRepository= userRepository;
		this.tagRepository = tagRepository;
		this.tweetMapper = tweetMapper;
		this.serviceUtilities = serviceUtilities;
		this.idChecker = serviceUtilities.buildIdChecker(User.class, this::has);
	}

	public List<TweetDto> index() {
		 return tweetRepository
                .findAll()
                .stream()
                .map(tweetMapper::toTweetDto)
                .collect(Collectors.toList());
	}
	
	 public boolean has(Long id) {
	        if (id != null)
	            return tweetRepository.exists(id);
	        return false;
	 }

	
	public Long post(TweetDto tweetDto) {
		
		//System.out.println("+++++++++++++++++"+tweetDto.getContent());
		String [] contentStringArray = tweetDto.getContent().split("\\s+");
		for (int i = 0; i < contentStringArray.length; i++) {
			
			 if(contentStringArray[i].startsWith("@"))
			 {
				User user = new User();
				user.getMentionedtweets().add(tweetMapper.toTweet(tweetDto));
				 
			 }else if (contentStringArray[i].startsWith("#"))
			 {
				 Tag tag = new Tag();
				 tag.setLabel(contentStringArray[i]);
				 tagRepository.save(tag); 
			}
		}
		
		return tweetRepository.save(tweetMapper.toTweet(tweetDto)).getId();
	}

	public TweetDto get(Long id) {
		return tweetMapper.toTweetDto(tweetRepository.findById(id));
	}

	public void delete(Long id) {
		
		Tweet tweet = tweetRepository.findById(id);
		tweet.setExist(false);
		
	}

	public void postTweetLike(Credentials cred, Long id) {
		User currentUser= userRepository.findByUsername(cred.getUsername());
		Tweet currentTweet = tweetRepository.findById(id);
		currentUser.getLikedtweets().add(currentTweet);
		userRepository.save(currentUser);
	}

	public String getTagFromTweet(Long id) {
		
		Tweet currentTweet = tweetRepository.findById(id);
		if(currentTweet == null)
		{
			return ("+++++++++++++++++++++++++" + currentTweet.getContent());
		}
		String returnString = "";
		String [] contentStringArray = currentTweet.getContent().split("\\s+");
		
		for (int i = 0; i < contentStringArray.length; i++) {
			if (contentStringArray[i].startsWith("#"))
			 {
				 
				returnString = returnString + contentStringArray[i];	  
			}
			}
		
		return returnString;
	}

	public String getContextFromTweet(Long id) {
		// TODO Auto-generated method stub
		return tweetRepository.findById(id).getContent();
	}

	public Tweet postTweetRepost(Long id) {
		Tweet oldTweet = tweetRepository.findById(id);
		Tweet newTweet = new Tweet();
		newTweet.setContent(oldTweet.getContent());
		newTweet.setRepostOriginal(oldTweet);
		tweetRepository.save(newTweet);
		return newTweet;
	    
		
	}

	
}
	



