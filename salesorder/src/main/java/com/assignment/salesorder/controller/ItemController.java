package com.assignment.salesorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.salesorder.entity.Item;
import com.assignment.salesorder.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@GetMapping("/getallitems")
	public List<Item> getAllItems(){
		return itemService.getAllItems();
	}
	
	
	@PostMapping("/add")
	public Item saveItem(@RequestBody Item item) {
		item = itemService.saveItem(item);
		return item;
	}
}
