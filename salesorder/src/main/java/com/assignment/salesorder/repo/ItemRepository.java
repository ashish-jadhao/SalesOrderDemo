package com.assignment.salesorder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.salesorder.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
