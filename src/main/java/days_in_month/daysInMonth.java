package days_in_month;

public class daysInMonth {

    public static void main(String[] args) {
        int daysInMonth = getDaysInMonth(5,2023);
        System.out.println(daysInMonth);
    }
    
    public  static int getDaysInMonth(int monthNumber,int year) {
        int daysInMonth = 0;

        switch (monthNumber) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = 30;
                break;
            case 2:
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
            default:
                System.out.println("Only 12 month in year");
                break;
        }

        return daysInMonth;
    }
}
