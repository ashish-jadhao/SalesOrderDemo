package com.assignment.salesorder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.salesorder.entity.Customer;
import com.assignment.salesorder.entity.Item;
import com.assignment.salesorder.exception.CustomerException;
import com.assignment.salesorder.exception.ItemException;

@Service
public interface ItemService {

	List<Item> getAllItems();

}
