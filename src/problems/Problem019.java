package problems;

import runner.ProjectEulerRunner;

public class Problem019 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem019().run());
    }

    @Override
    public String run() {
        int result = countingSundays(1, 1, 1900);
        return Integer.toString(result);
    }

    private int countingSundays(int currentDay, int month, int year) {
        if (year > 2000) {
            return 0;
        }
        boolean leapYear;
        leapYear = year % 4 == 0 && year > 1900;
        int days = switch (month) {
            case 2 -> (leapYear ? 29 : 28);
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
        if (currentDay == 0 && year > 1900) {
            return 1 + countingSundays((currentDay + days) % 7, (month == 12 ? 1 : month + 1),
                    (month == 12 ? year + 1 : year));
        } else {
            return countingSundays((currentDay + days) % 7, (month == 12 ? 1 : month + 1),
                    (month == 12 ? year + 1 : year));
        }
    }
}
