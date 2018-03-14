//package main.java.com.vpfeiffer.bookfinder;

import java.util.Scanner;
import java.util.Objects;
import java.sql.*;

/**
* Domain classes used to produce command line user interface for database.
* <p>
* This class contains the controller and UI.
* </p>
*
* @since 1.0
* @author Violet Pfeiffer
* @version 1.0
*/
public final class BookFinder {
    /** For user input.
     *
     */
    private static Scanner reader;
    private static Connection database; // For database wrapper.

    /**
     * Utility class for accessing database.
     *
    */
    private BookFinder() {
    }

    /**
     * This is the main method which is the controller.
     * @param args
   */
    public static void main(String[] args) {
        reader = new Scanner(System.in);

        // Connect to SQL database.
        try {
            Class.forName("org.sqlite.JDBC");
            database = DriverManager.getConnection("jdbc:sqlite:books.db");
            // Prevent database from being edited.
            database.setAutoCommit(false);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        // Main UI loop.
        while (true) {

            // UI options.
            System.out.println("Type the option you would like to select.\n");
            System.out.println("authors: List authors");
            System.out.println("genre: List books by genre");
            // System.out.println("3: List books by author");
            System.out.println("exit: Exit");

            //int choice = reader.nextInt();
            String choice = reader.nextLine().trim();
            // Flush scanner.
            // reader.nextLine();

            // Exit program.
            /*if (choice == 0) {
                break;
            }*/
            if (Objects.equals(choice, new String("exit"))){
                break;
            }

            // UI options logic.
            switch (choice) {
                case "authors":
                    listAuthors();
                    break;
                case "genre":
                    listByGenre();
                    break;
                case "why":
                    listByAuthor();
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
        reader.close();
    }

    /** Print all authors.
     *
    */
    private static void listAuthors() {
        // Print all authors.
        try {
            Statement statement = database.createStatement();
            ResultSet rs = statement.executeQuery("SELECT name FROM AUTHOR;");

            while (rs.next()) {
                String  name = rs.getString("name");
                System.out.println(name);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /** List genra chosen by user.
     *
    */
    private static void listByGenre() {
        // Get genre from user.
        System.out.println("Select a genre: Fantasy, Fiction, Nonfiction");
        String genre = reader.nextLine();

        // Print all books in genre.
        try {
            PreparedStatement statement = database.prepareStatement("SELECT "
            + "BOOK.title,"
            + "author.name,publisher.name,"
            + "book.genre, book.rating,"
            + "book.series FROM BOOK INNER JOIN AUTHOR ON "
            + "BOOK.author_id=author.id INNER JOIN PUBLISHER ON "
            + "BOOK.publisher_id=publisher.id WHERE GENRE = ?");
            statement.setString(1, genre);
            // Get selected genre from database.
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                // Column
                String  title = rs.getString("title");
                System.out.println(String.format("Title: %s, Author: %s, "
                + "Publisher: %s, "
                + "Genre: %s, Rating: %s, Series: %s",
                rs.getString(1), rs.getString(2),
                rs.getString(3), rs.getString(4),
                rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**Implement next.
     *
    */
    private static void listByAuthor() {
        // To do.
    }

}
