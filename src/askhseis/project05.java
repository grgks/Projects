package askhseis;

public class project05 {
    public static void main(String[] args) {

        boolean[][] seats = new boolean[30][12];


        book(seats, 'C', 2);


        book(seats, 'A', 1);


       // cancel or
       // book(seats,'!',11);      //Δοκιμή εισαγωγής λάθος στοιχείων


        book(seats, 'C', 2);


        cancel(seats, 'A', 1);


        cancel(seats, 'D', 3);
    }


    public static void book(boolean[][] seats, char column, int row) {
        if (seats == null) return;

        int col = column - 'A';
        int rows = row - 1;

        try {
            if (seats[rows][col]) {
                System.out.println("Η θέση " + column + row + " είναι ήδη κλεισμένη.");
            } else {
                seats[rows][col] = true;
                System.out.println("Η θέση " + column + row + " κλείστηκε επιτυχώς.");
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Παρακαλώ εισάγετε σωστά στοιχεία(Οι θέσεις δεν υπάρχουν στο σύστημα)");
        }
    }


    public static void cancel(boolean[][] seats, char column, int row) {
        if (seats == null) return;

        int col = column - 'A';
        int rows = row - 1;

        try {
            if (! seats[rows][col]) {
                System.out.println("Η θέση " + column + row + " δεν είναι κλεισμένη.");
            } else {
                seats[rows][col] = false;
                System.out.println("Η θέση " + column + row + " ακυρώθηκε επιτυχώς.");
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Παρακαλώ εισάγετε σωστά στοιχεία(Οι θέσεις δεν υπάρχουν στο σύστημα)");
        }
    }
}