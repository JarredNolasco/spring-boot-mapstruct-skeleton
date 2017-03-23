package cooksys.sbm.db.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cooksys.sbm.db.entity.Tag;

public interface TagRepository extends JpaRepository<Tag,Long>{
	
	Tag findByLabel(String label);

}
