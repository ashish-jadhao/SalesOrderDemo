package com.assignment.salesorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.assignment.salesorder.entity.Item;

import com.assignment.salesorder.repo.ItemRepository;


@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepo;

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		List<Item> allItems = itemRepo.findAll();
		return allItems;
	}


	

}
