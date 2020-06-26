package problems;

import runner.ProjectEulerRunner;

public class Problem019 implements ProjectEulerRunner {

	public static void main(String[] args) {
		System.out.println(new Problem019().run());
	}

	@Override
	public String run() {
		return String.valueOf(isSundayOnFirstOfMonth(1, 1, 1900, false));
	}

	private int isSundayOnFirstOfMonth(int currentDay, int month, int year, boolean leapYear) {
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
		case 1:
			days = 31;
			break;
		case 2:
			days = (leapYear ? 29 : 28);
			break;
		case 3:
			days = 31;
			break;
		case 4:
			days = 30;
			break;
		case 5:
			days = 31;
			break;
		case 6:
			days = 30;
			break;
		case 7:
			days = 31;
			break;
		case 8:
			days = 31;
			break;
		case 9:
			days = 30;
			break;
		case 10:
			days = 31;
			break;
		case 11:
			days = 30;
			break;
		default:
			days = 31;
			break;
		}
		if (currentDay == 0 && year > 1900) {
			return 1 + isSundayOnFirstOfMonth((currentDay + days) % 7, (month == 12 ? 1 : month + 1),
					(month == 12 ? year + 1 : year), leapYear);
		} else {
			return isSundayOnFirstOfMonth((currentDay + days) % 7, (month == 12 ? 1 : month + 1),
					(month == 12 ? year + 1 : year), leapYear);
		}
	}
}
