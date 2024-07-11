package com.railway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.railway.entities.Category;
import com.railway.entities.Railway;

@Repository
public interface RailwayRepository extends JpaRepository<Railway, Long>{

	List<Railway> findByCategory(Category category);
}
