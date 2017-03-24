package cooksys.sbm.dto.mapper;

import org.mapstruct.Mapper;

import cooksys.sbm.db.entity.Tweet;
import cooksys.sbm.dto.dto.TweetDto;

@Mapper(componentModel = "spring")
public interface TweetMapper {

	TweetDto toTweetDto (Tweet tweet);
	
	Tweet toTweet(TweetDto tweetDto);
}
