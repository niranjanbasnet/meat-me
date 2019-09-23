package com.niranjan.Meatme.repository;

import com.niranjan.Meatme.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItem, Integer> {
}
