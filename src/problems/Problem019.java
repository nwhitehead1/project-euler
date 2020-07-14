package problems;

import runner.ProjectEulerRunner;

public class Problem019 implements ProjectEulerRunner {

    public static void main(String[] args) {
        System.out.println(new Problem019().run());
    }

    @Override
    public String run() {
        int result = countingSundays(1, 1, 1900, false);
        return Integer.toString(result);
    }

    private int countingSundays(int currentDay, int month, int year, boolean leapYear) {
        if (year > 2000) {
            return 0;
        }
        if (year % 4 == 0 && year > 1900) {
            leapYear = true;
        } else {
            leapYear = false;
        }
        int days;
        switch (month) {
            case 2:
                days = (leapYear ? 29 : 28);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            default:
                days = 31;
                break;
        }
        if (currentDay == 0 && year > 1900) {
            return 1 + countingSundays((currentDay + days) % 7, (month == 12 ? 1 : month + 1),
                    (month == 12 ? year + 1 : year), leapYear);
        } else {
            return countingSundays((currentDay + days) % 7, (month == 12 ? 1 : month + 1),
                    (month == 12 ? year + 1 : year), leapYear);
        }
    }
}
