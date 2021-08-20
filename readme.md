#Java Employee Record Project

##Created By Joe Hilton

###Requirements:

1- Program should read a .csv file and report that it has done it correctly. 

2- File should remove duplicates and report how many items it removed

3- The program should then upload the clean records to a database as fast as possible

###Tools Used:

IntelliJ IDEA

MySQL Server

MySQL Workbench

Maven

JUnit

---

##Instuctions for Use

Step 1) Open database.properties found in the resources folder, then set userName, passWord and url to appropriate values for your MySQL server.

Step 2) Ensure that the fileName variable on line 12 of Main is correctly set to appropriate .Csv file (Two are bundled by default, EmployeeRecordsLarge.csv is the default value)

Step 3) Set the numOfThreads variable on line 13 of Main to whatever number of threads you would like to use (160 was good for development system)

Step 4) Ensure that the maximum number of connections to your MySQL server is at least equal to the numOfThreads variable, it should preferably be higher however.

Step 5) Run the program, bear in mind this may take a while to run, depending on your system and selected options.