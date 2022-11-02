//------------------------------------------------------------------------------------------------------------------------------
					INTRO:
//------------------------------------------------------------------------------------------------------------------------------
This project represents an employee database management app. 


In order to run the application after downloading the source code,
the file NewJFrame.java from src\main\java\com\mycompany\mavenproject1\md\Tekwill\ui 
must be run, preferably with Apache NetBeans.


I have developed this application by using the Java programming language and the Swing framework for it, Postgresql and the Apache Netbeans IDE.
The application is built on 3 layers:
1. DAO (Data Acces Object) which handles the communication with the Postgresql database
2. Service, which implements function for managing requests between the GUI and the DAO.
3. UI , which implements the graphical user interface with Swing

The database was created using postgresql and is hosted on my local computer. 
Its name and address can be seen in the JDBCConnection file, in the DAO folder.

This application won't work properly if just downloaded on a device, because it is bond to
the employee database hosted on my computer.

Earlier versions of the application, in which I have included only the GUI and the tables with
employee data can be found in earlier commits on github. 
These version work properly, with the only exception that they don't save the data on the 
hard drive, and thus, all the employee data is lost after closing the app.






//------------------------------------------------------------------------------------------------------------------------------
			FUNCTIONAL:
//------------------------------------------------------------------------------------------------------------------------------
The application follows the basic CRUD rules, and by using the main menu, the following can be done:

- Create an employee record  
-Update an employee record, with the specified id 
-Delete an employee record, with the specified id
-Find information about the employee record with the specified id.
-Manage departments (create a new department, get info about an existing department, delete an existing department to which no employee record is bound)
-Filter information about employees (by name, id and department) and sort the filtered information (by id, name, last name, name+last name).





//---------------------------------------------------------------------------------------------------------------------------------
			DEMONSTRATION:
//---------------------------------------------------------------------------------------------------------------------------------

A demonstration of the application can be found in this youtube video:

https://www.youtube.com/watch?v=VNxVWIdBQQU
