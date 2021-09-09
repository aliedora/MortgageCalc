import mortgage_calculator.MortgageCalculator;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MortgageCalculator mortgageCalculator = new MortgageCalculator(4500000, 13500000, 8.8, 20);
        mortgageCalculator.calculateMonthPayment();

        HashMap<Integer, Integer> additionalPayments = addAdditionalPayments();
        mortgageCalculator.calculateMonthPaymentsWithPercents(additionalPayments, 50000);




    }


    private static HashMap<Integer, Integer> addAdditionalPayments() {
        HashMap<Integer, Integer> additionalPayments = new HashMap<>();
        additionalPayments.put(1, 40000);
        additionalPayments.put(2, 30000);
//        additionalPayments.put(3, 500000);
//        additionalPayments.put(5, 40000);
//        additionalPayments.put(6, 40000);
//        additionalPayments.put(7, 130000);
//        additionalPayments.put(15, 130000);
//        additionalPayments.put(18, 130000);
//        additionalPayments.put(21, 130000);
        return additionalPayments;
    }
}
