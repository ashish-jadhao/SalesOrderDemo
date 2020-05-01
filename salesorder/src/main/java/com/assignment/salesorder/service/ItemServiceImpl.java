package com.assignment.salesorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.salesorder.entity.Customer;
import com.assignment.salesorder.entity.Item;
import com.assignment.salesorder.exception.ItemException;
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

	@Override
	public Item saveItem(Item item) {
		// TODO Auto-generated method stub
		Item savedItem = itemRepo.saveAndFlush(item);
		return savedItem;
	}

	@Override
	public Item getItem(Integer id) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteItem(Integer id) throws ItemException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item updateItem(Integer id) throws ItemException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
