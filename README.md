# Book Finder

A Java application that acts an interface for a SQLite database of books.
JDBC is used for the database connectivity. The data consists of real books.
The website [goodreads.com](https://www.goodreads.com/) was used to gather data.

The following information about several books was recorded:
* Title
* Author
* Publisher
* Genre
* Rating
* Series

# Compile and Run
## To Compile:

Windows/Linux
```
javac src/main/java/com/vpfeiffer/bookfinder/BookFinder.java
```

## To Run:
Windows/Linux
```
java -cp "./src/main/java/com/vpfeiffer/bookfinder:./lib/sqlite-jdbc-3.21.0.jar" BookFinder
```
# Usage
Main menu provides two options:

* List all authors
* List books by genre

---
To list all authors type:
```
authors
```
---
To list books by genre type:
```
genre
```
You will be prompted to choose a genre from the following:
* Fantasy
* Fiction
* Nonfiction

if i.e. you were to choose fantasy type:
```
Fantasy
```
All the books of the specified genre will be listed. 

Note: All genres must capitalized.

# Future Updates

* Jar file.
* Query for a publisher.
* Sort by rating.
* Query for series.
* Web Scraper for goodreads.
* Proper build tool support.

# Resources

[SQLite download page](https://sqlite.org/download.html)

[SQLite download and installation guide](www.sqlitetutorial.net/download-install-sqlite/)

[SQLite browser](http://sqlitebrowser.org/)

[Java SQL package](https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html)

# License
Copyright (c) 2018 Violet Pfeiffer

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
