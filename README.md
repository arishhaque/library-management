# Library Management
A Design Patterns project by [Shiva Govindaraju](https://github.com/ShivaGovindaraju) and [Arish Haque](https://github.com/arishhaque).

## Project Description

The goal of this project is to develop an application that would assist in the management of a Library Catalogue. The suggested use-case is for libraries employed by schools and universities to manage their existing library catalogue in a useful way, though the actual stakeholders in this project are not so limited: anyone who requires the management of a catalogue of books would benefit from this application.

This entailed being able to organize a collection of books onto library shelves which exist in the real-world by storing their information and locations electronically. The application should not only allow for the organization of all catalogue materials, but also permit the user to find books based on various criteria, as well as to issue books to select individuals (marking them as no longer available to issuing, once no more of that book is available in the catalogue) and to return them back to the catalogue. User access should also be restricted to certain functions, such that only selected users are given permission/privilege to perform select actions.

A brief description of the overall functionalities necessary are as follows:
- The Catalogue would organize Books onto Shelves based on Genre
  - Some Shelves with wide-Genre categories might have smaller Shelves on them with more narrowly focused Genre labels
  - All aspects of the Catalogue should be controlled through the application
- Users would be able to access the Catalogue to find Books, whether that be:
  - Finding a specific Book by Name
  - Finding all Books by an Author, or within a given Genre
  - Sorting all Books by Rating
  - Issuing a Book to a User, or returning one
- Librarians would be managing Catalogue contents (Books and Shelves)
- Administrators would be able to add/remove valid Users of the Catalogue
- Administrators should possess the same privileges as Librarians as well

## Requirements

To run the application, there are certain requirements for the machine that the application is being run upon.

First, the application was developed using Java 11, and would require that the Java 11.0.11 JDK is utilized on the machine running the application.

Secondly, it is also crucial that MySQL is installed on the machine as well, and that within src/main/resources/ of the project application, the library_db.sql file is dumped into a MySQL database table titled ‘library_db’. This must be done before the executable JAR file can be run to begin the application or the application will fail to operate as a result of SQL Exceptions and errors from the database being absent from MySQL.

The DbConfig file requires editing to make the hard-coded values in the file match the username and password set for the application machine running MySQL. Similarly, Maven is also required to be installed on the machine to provide access to the IDE for the packaging of the Java application developed using Spring Boot and Java GUI frameworks. Having these tools integrated into the IDE is very useful to run the application.

