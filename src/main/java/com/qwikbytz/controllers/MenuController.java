package com.qwikbytz.controllers;

import com.qwikbytz.models.MenuItemModel;
import com.qwikbytz.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @PostMapping("/createItem")
    public String insert(@RequestBody MenuItemModel menuItem) {
        // Saving the incoming data to the database
        menuItemRepository.save(menuItem);
        return "Data Inserted";
    }

}
