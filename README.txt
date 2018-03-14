Info:
    Used:
    JDBC to allow Java to interact with sqlite
    Java for logic/UI
    Sqlite for relational database.

How to compile:
javac -g BookFinder.java

How to run:
Windows:
java -classpath ".;sqlite-jdbc-3.21.0.jar" BookFinder

or 

java -cp ".;sqlite-jdbc-3.21.0.jar" BookFinder

Linux:
java -classpath ".:sqlite-jdbc-3.21.0.jar" BookFinder