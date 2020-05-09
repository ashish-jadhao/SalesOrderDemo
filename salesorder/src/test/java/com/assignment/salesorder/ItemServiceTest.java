package com.assignment.salesorder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.assignment.salesorder.entity.Item;
import com.assignment.salesorder.repo.ItemRepository;
import com.assignment.salesorder.service.ItemService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ItemServiceTest {

	@Autowired
	private ItemService itemService;

	@MockBean
	private ItemRepository itemRepository;
	
	@Test
	public void getAllItemsTest() {
		when(itemRepository.findAll()).thenReturn(Stream
				.of(new Item(101,"Laptop",50000),
				new Item(102,"Desktop",60000))
				.collect(Collectors.toList()));

		// Comparing size
		assertEquals(2, itemService.getAllItems().size());
	}
}
