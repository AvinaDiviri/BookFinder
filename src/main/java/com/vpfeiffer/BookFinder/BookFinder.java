package com.vpfeiffer.BookFinder;

import java.util.Scanner;
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
    static Scanner reader; // For user input.
    static Connection database; // For database wrapper.

    private BookFinder(){
        // Not called.
    }
    public static void main(String[] args) {        
        reader = new Scanner(System.in);

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
            //System.out.println("3: List books by author");
            System.out.println("0: Exit");

            int choice = reader.nextInt();
            reader.nextLine(); //flush scanner

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

    //print all authors
    private static void listAuthors(){
        // print all authors
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

    // List genre chosen by user
    private static void listByGenre(){
        // get genre from user
        System.out.println("Select a genre: Fantasy, Fiction, Nonfiction");
        String genre = reader.nextLine();

        // print all books in genre
        try {
            PreparedStatement statement = database.prepareStatement("SELECT BOOK.title, author.name,publisher.name, book.genre, book.rating, book.series FROM BOOK INNER JOIN AUTHOR ON BOOK.author_id=author.id INNER JOIN PUBLISHER ON BOOK.publisher_id=publisher.id WHERE GENRE = ?");
            statement.setString(1, genre);
            // get selected genre from database
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                // Column
                String  title = rs.getString("title");
                System.out.println(String.format("Title: %s, Author: %s, Publisher: %s, Genre: %s, Rating: %s, Series: %s", rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5),rs.getString(6) ));
            }
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    private static void listByAuthor(){
        // To do
    }

}
