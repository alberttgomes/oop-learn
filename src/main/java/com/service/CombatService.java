package com.service;

import com.model.Champion;

import java.util.Scanner;

public class CombatService {

    public static Champion createChampion(Scanner scanner) {
        System.out.print("Enter champion name: ");
        String championName = scanner.nextLine();
        System.out.print("Enter champion initial life: ");
        int championLife = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter champion attack: ");
        int championAttack = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter champion armor: ");
        int championArmor = scanner.nextInt();
        scanner.nextLine();

        return new Champion(
            championArmor, championAttack, championLife, championName);
    }

    public static void turn(Champion xChampion, Champion yChampion, int turns) {
        System.out.println("\n Init combat");

        for (int i = 0; i < turns; i++) {
            xChampion.takeDamage(yChampion);
            yChampion.takeDamage(xChampion);

            System.out.println("Result turn: " + i);

            System.out.println(xChampion.status());
            System.out.println(yChampion.status());;

            if (xChampion.getLife() <= 0 || yChampion.getLife() <= 0) {
                break;
            }
        }

        System.out.println("--- END THE COMBAT ---");
    }

}
