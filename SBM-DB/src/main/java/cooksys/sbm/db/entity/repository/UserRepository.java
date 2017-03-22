package cooksys.sbm.db.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cooksys.sbm.db.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	User findById(Long id);

}
