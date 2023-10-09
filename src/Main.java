

public class Main {

    public static void main(String[] args) {
        Date date1 = new Date("30-04-2022");
        Date nextDay1 = date1.diaSeguinte();
        System.out.println("Next day of " + date1 + " is " + nextDay1);

        Date date2 = new Date("31-12-2022");
        Date nextDay2 = date2.diaSeguinte();
        System.out.println("Next day of " + date2 + " is " + nextDay2);

            Date validDate = new Date("12-12-2313");
            System.out.println("Valid Date: " + validDate);

            // Test invalid dates (will throw exceptions)
            Date invalidDate1 = new Date("12-13-2313");
            Date invalidDate2 = new Date("42-12-2313");


    }
}