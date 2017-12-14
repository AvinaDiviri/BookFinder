// Violet Pfeiffer
// Book Finder
import java.util.Scanner;
import java.sql.*;

public class BookFinder {
    static Connection database;

    public static void main(String[] args) {        
        Scanner reader = new Scanner(System.in);

        // connect to SQL database
        try{
            Class.forName("org.sqlite.JDBC");
            database = DriverManager.getConnection("jdbc:sqlite:books.db");
            database.setAutoCommit(false); // prevents database from being modified
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        // main UI loop
        while(true){

            // UI options
            System.out.println("1: List authors");
            System.out.println("2: List books in genre");
            System.out.println("3: List books by author");
            System.out.println("0: Exit");

            int choice = reader.nextInt();

            // exit program
            if (choice == 0){
                break;
            }

            // UI options logic
            switch(choice){
                case 1:
                    listAuthors();
                    break;
                case 2:
                    listByGenre();
                    break;
                case 3:
                    listByAuthor();
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
        reader.close();
    }

    private static void listAuthors(){
        try {
            Statement statement = database.createStatement();
            ResultSet rs = statement.executeQuery( "SELECT name FROM AUTHOR;");

            while (rs.next()){
                String  name = rs.getString("name");
                System.out.println(name);
            }
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    private static void listByGenre(){
        // To do
    }

    private static void listByAuthor(){
        // To do
    }

}