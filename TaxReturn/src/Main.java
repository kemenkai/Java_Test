//package src;
//
//import java.awt.desktop.SystemSleepEvent;
//import java.util.List;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//
//
//        Income[] incomes = new Income[]{new Employee(3000), new SalaryIncome(7500), new RoyaltyIncome(12000)};
//
//        System.out.println(totalTax(incomes));
//    }
//
//    public static double totalTax (Income...incomes){
//        double total = 0.00;
//        for (Income income : incomes) {
//            total = total + income.getTax();
//        }
//        return total;
//    }
//}
