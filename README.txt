Info:
    Used:
    JDBC to allow Java to interact with sqlite
    Java for logic/UI
    Sqlite for relational database.

How to compile:
javac -cp "/src/main/java/com/vpfeiffer/bookfinder;/lib/sqlite-jdbc-3.21.0.jar" src/main/java/com/vpfeiffer/bookfinder/BookFinder.java

How to run:
Windows:
java -cp "./src/main/java/com/vpfeiffer/bookfinder;./lib/sqlite-jdbc-3.21.0.jar" BookFinder

Linux:
java -cp "./src/main/java/com/vpfeiffer/bookfinder:./lib/sqlite-jdbc-3.21.0.jar" BookFinder