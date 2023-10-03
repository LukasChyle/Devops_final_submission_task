package com.example.Devops_final_submission_task.controllers;


import com.example.Devops_final_submission_task.Repositories.MenuRepo;
import com.example.Devops_final_submission_task.service.MenuManipulator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/menu")
public class MenuController {

    MenuRepo menuRepo;

    MenuManipulator menuManipulator;

    public MenuController(MenuRepo menuRepo, MenuManipulator menuManipulator) {
        this.menuRepo = menuRepo;
        this.menuManipulator = menuManipulator;
    }

    @GetMapping
    public String getWeeklyMenu() {
        return menuRepo.getMenuMap().toString();
    }

    @GetMapping("/today")
    public String getTodaysMenu() {
        return menuManipulator.checkTodaysMenu(LocalDate.now().getDayOfWeek().toString());
    }

}
