package com.pma.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pma.business.LineItem;
import com.pma.business.LineItemRepository;

@RestController
@RequestMapping("/line-items")
public class LineItemController {
	
	@Autowired
	private LineItemRepository liRepo;
	
	@GetMapping(path="/")
	public Iterable<LineItem> getAll() {
		return liRepo.findAll();
		
	}

}
