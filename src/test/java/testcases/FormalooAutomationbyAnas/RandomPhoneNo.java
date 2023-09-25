package testcases.FormalooAutomationbyAnas;

import java.util.Random;

public class RandomPhoneNo {
    public static String generateRandomPhoneNumber() {
        Random rand = new Random();
        StringBuilder phoneNumber = new StringBuilder("+");

        // Generate country code (e.g., +1 for USA)
        phoneNumber.append(rand.nextInt(9) + 1);

        // Generate remaining digits
        for (int i = 0; i < 10; i++) {
            phoneNumber.append(rand.nextInt(10));
            if (i == 2 || i == 5) {
                phoneNumber.append("-");
            }
        }

        return phoneNumber.toString();
    }
}
