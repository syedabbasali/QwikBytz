package com.qwikbytz.repositories;

import com.qwikbytz.models.MenuItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemModel, Long> {
}
