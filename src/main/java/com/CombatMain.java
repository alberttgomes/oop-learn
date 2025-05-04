package com;

import com.model.Champion;
import com.service.CombatService;

import java.util.Scanner;

public class CombatMain {

    public static void main(String[] args) {
        System.out.println("Welcome to the Combat Game!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter champion X data: ");
        Champion xChampion = CombatService.createChampion(scanner);

        System.out.println("Please enter champion Y data: ");
        Champion yChampion = CombatService.createChampion(scanner);

        System.out.print("Enter number of turns: ");
        int turns = scanner.nextInt();

        CombatService.turn(xChampion, yChampion, turns);
    }

}
