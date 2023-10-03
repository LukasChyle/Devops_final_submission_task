package com.example.Devops_final_submission_task.service;

import com.example.Devops_final_submission_task.Repositories.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuManipulatorImplement implements MenuManipulator {

    MenuRepo menuRepo;
    @Autowired
    public MenuManipulatorImplement(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }

    @Override
    public String checkTodaysMenu(String date) {
        Weekdays weekdays = Weekdays.valueOf(date);
        return switch(weekdays) {
            case MONDAY  -> menuRepo.menuMap.get(0);
            case TUESDAY -> menuRepo.menuMap.get(1);
            case WEDNESDAY -> menuRepo.menuMap.get(2);
            case THURSDAY -> menuRepo.menuMap.get(3);
            case FRIDAY -> menuRepo.menuMap.get(4);
            case SATURDAY -> menuRepo.menuMap.get(5);
            case SUNDAY -> menuRepo.menuMap.get(6);
        };

    }
}
