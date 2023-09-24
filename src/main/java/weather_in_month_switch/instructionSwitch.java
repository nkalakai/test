package weather_in_month_switch;


public class instructionSwitch {
    public static void main(String[] args) {
        int month = 4;
        switch (month) {
            case 12, 1, 2:
                System.out.println("winter");
                break;
            case 3, 4, 5:
                System.out.println("spring");
                break;
            case 6, 7, 8:
                System.out.println("summer");
                break;
            case 9, 10, 11:
                System.out.println("autumn");
                break;
            default:
                System.out.println("is only 12 month in year");
                break;
                }
    }
}

