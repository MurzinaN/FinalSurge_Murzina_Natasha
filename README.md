What is FinalSurge?
FinalSurge.com is the training and coaching online platform for athletes, coaches, teams and clubs. Final Surge is providing a free online training log for athletes of all types including runners, triathletes, cyclists, swimmers, and their coaches. The FinalSurge to allows track workouts and import workout and GPS data from fitness devices, save and analyze the results.
Libraries,  frameworks used in project:
1.	Selenium version 3.141.59;
2.	TestNG version 7.6.0;
3.	Log4j-core version 2.18.0;
4.	Allure-testng version 2.18.1;
5.	Lombok version 1.18.24;

Prerequisites installed:
1. Java JDK 18.0.1.1 and 1.8.0_341
2. Maven version 3.8.6

Continuous Integration: 
Jenkins

SVC:
Github version 5.2.0

Setting up config:
1.	Clone this repository.
2.	Enter email, password and URL in config.properties

Checklist:
1. Verify that user can log in the system with correct data.
2. Verify that user can't log in the system with invalid email and get the appropriate error message
3. Verify that user can't log in the system with invalid password and get the appropriate error message
4. Verify that user can log out of the system.
5. Сheck that user can add workout in Training Calendar.
6. Сheck that user can copy workout in Training Calendar.
7. Сheck that user can upload file with workout data in Training Calendar.
8. Verify that user can calculate daily caloric needs.
9. Verify that user can calculate pace workout.
10. Verify that user can input and save his daily vitals.
11. Сheck that user receives an appropriate error message when entering incorrect data in daily vitals form.
12. Сheck that user can add new shoes to the equipment.
13. Verify that user can get a workout report for the selected period. 

Test suites

Smoke tests
This suite includes tests: addTrainingOnCalendarTest, positiveLoginTest, reportTest 
Running the suit
mvn -DsuiteXmlFile=smokeTest.xml test

Regression tests
This suite includes tests: dailyCaloricNeedsCalculatorTest, paceCalculatorTest, addDailyVitalsTest, logoutTest, addNewShoeTest, copyTrainingOnCalendarTest, uploadTrainingTest
Running the suit
mvn -DsuiteXmlFile=regressionTest.xml test
And each scenario of this suite will execute.
 
Negative tests
This suite includes tests: dailyVitalsWithIncorrectDataTest, negativeLoginTestForEmail, negativeLoginTestForPassword
Running the suit
mvn -DsuiteXmlFile=negativeTest.xml test

Running all tests:
1.	mvn clean test
2.	mvn -DsuiteXmlFile=allTests.xml test

Running all tests in class:
mvn -Dtest=AddTrainingTest test
mvn -Dtest=CalculatorTest test
mvn -Dtest=DailyVitalsTest test
mvn -Dtest=LoginTest test
mvn -Dtest=NewShoeTest test
mvn -Dtest=ReportsAndStatisticsTest test
mvn -Dtest=TrainingTest test


 Running a single test:
mvn -Dtest=AddTrainingTest#addTrainingOnCalendarTest test
mvn -Dtest=CalculatorTest#dailyCaloricNeedsCalculatorTest test
mvn -Dtest=CalculatorTest#paceCalculatorTest test
mvn -Dtest=DailyVitalsTest#addDailyVitalsTest test
mvn -Dtest=DailyVitalsTest#dailyVitalsWithIncorrectDataTest test
mvn -Dtest=LoginTest#positiveLoginTest test
mvn -Dtest=LoginTest#negativeLoginTestForEmail test
mvn -Dtest=LoginTest#negativeLoginTestForPassword test
mvn -Dtest=LoginTest#logoutTest test
mvn -Dtest=NewShoeTest#addNewShoeTest test
mvn -Dtest=ReportsAndStatisticsTest#reportTest test
mvn -Dtest=TrainingTest#copyTrainingOnCalendarTest test
mvn -Dtest=TrainingTest#uploadTrainingTest test






















