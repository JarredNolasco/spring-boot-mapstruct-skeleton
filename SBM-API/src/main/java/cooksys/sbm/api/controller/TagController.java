package cooksys.sbm.api.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cooksys.sbm.api.service.TagService;
import cooksys.sbm.db.entity.Tag;
import cooksys.sbm.db.entity.Tweet;




@RestController
@Validated
@RequestMapping("tags")
public class TagController {
	
	private TagService tagService;
	
	public TagController(TagService tagService)
	{
		super();
		this.tagService = tagService;
	}
	
	@GetMapping("validate/tag/exists/{label}")
	public Boolean ValidateTag(@RequestParam Long Id){
		return tagService.checkIfExist(Id);
	}
	
	@GetMapping
	public List<Tag> GetTags(){
		return tagService.getIndex();
	}
	
	@GetMapping("/{label}")
	public List<Tweet> Validatetag(String tag){
		return tagService.getTagLabels(tag);
	}

}
