package cooksys.sbm.db.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cooksys.sbm.db.entity.Tweet;
import cooksys.sbm.db.entity.User;

public interface TweetRepository extends JpaRepository<Tweet,Long> {

	User findById(Long id);
}
