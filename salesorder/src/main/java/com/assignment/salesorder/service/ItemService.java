package com.assignment.salesorder.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.assignment.salesorder.entity.Item;


@Service
public interface ItemService {

	List<Item> getAllItems();

}
