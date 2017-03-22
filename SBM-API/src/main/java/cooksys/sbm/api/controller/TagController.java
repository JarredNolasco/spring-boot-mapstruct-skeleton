package cooksys.sbm.api.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.sbm.api.service.TagService;
import cooksys.sbm.api.service.UserService;

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
	public String ValidateTag(){
		return "";
	}
	
	@GetMapping
	public String GetTags(){
		return "";
	}
	
	@GetMapping("/{label}")
	public String Validatetag(){
		return "";
	}

}
