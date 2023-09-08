# GrowSkill
GrowSkill is a e-learning platform for women

# A summary about my work
In this projects, I am trying to explain the step-to-step process of an user who visits the website. Some annotations are used for relation mapping and to get automatic getter and setters for attributes. I have create APIs by dividing into different layers like we can write controllers in controller layer, logic in service layer and database in repository layer.
By some annotations, we can perform CRUD operation like
For getting all course, we can use @GetMapping
For enrollment in course, we can use @Postmapping
and so on........

# Project Structure and answers are written below

# For proper implementation and clarification, please check out models/entities

# User Journey

Steps are:-
1. If the user is already registered on the website then he/she can log in to their account using the registered email and password,
   If not, then firstly, the user has to create an account using their name, email, phone number and password.
2. After successful login, the user can explore courses in the "Courses" section.
3. The user can view details of each course such as course name, instructor, duration and pricing.
4. The user selects a course they are interested in and proceeds to enroll in it by clicking on "Enroll Now".
5. The user is redirected to the payment section.
6. After successful payment, the User receives a payment successful and confirmation email with course details like class timings, topics to be covered in courses, zoom links of live classes etc.
7. User attends the live classes by joining zoom links.
8. After completion of the course, the User downloads the recordings of the classes and certificate of course from their profile section.




# Models with constraints and datatypes

Note:- Below are not proper implementation, just an idea is given below

1. User {
            UserId(int)(Unique and Auto Generated),
            UserName(String),
            Email(String),
            Password(String)
            MobileNo(String),
            Gender(Enum like MALE,FEMALE)
        }

2. Instructor {
                  InstructorId(int)(Unique and Auto Generated),
                  InstructorName(String),
                  Email(String),
                  MobileNo(String),
                  specialization(Enum like Baking/Makeup/Handicrafts)
                  Gender(Enum like MALE,FEMALE)
              }

3. Course {
             CourseId(int)(Unique and Auto Generated),
             CourseName(String),
             Description(String),
             Duration(int)(In months),
             Instructor(String),
             Category(Enum Like Baking/Makeup/Handicrafts),
             Price(int)(In Rupees)
          }

4. Class {
            ClassId(int)(Unique and Auto Generated),
            CourseId(int),
            Date(LocalDate),
            Time(LocalTime),
            Topic(String),
            ZoomLink(String)
         }

5. Enrollment {
                 EnrollmentId(int)(Unique and Auto Generated),
                 UserId(int),
                 CourseId(int),
                 EnrollmentDate(LocalDate)
              }

6. Payment {
              PaymentId(int)(Unique and Auto Generated),
              UserId(int),
              CourseId(int),
              Amount(int),
              PaymentDate(int)
           }

7. Recording {
                 RecordingId(int)(Unique and Auto Generated),
                 ClassId(int)
            }
   
9. Certificate {
                  CertificateID(int)(Unique and Auto Generated),
                  UserID(int),
                  UserName(String)
                  CourseID(int),
                  CourseName(String)
                  IssueDate(LocalDate)
               }




# Relationships

1. User-Course (One-to-many) //Because User can enroll in multiple courses
2. Instructor-Course (One-to-many) // One instructor is assigned to multiple courses like one instructor is assigned to all baking courses (like Beginner Makeup Course, Advance Makeup Course)
3. Enrollment-User-Course (Many-to-Many) // Many users can enroll in multiple courses
4. Bidirectional relation between Course and Class
    1. Course-Class(One-to-many) // Course have multiple classes
    2. Class-Course (Many-to-one) // Each course have multiple classes
5. User-Payment (One-to-many) // User can make multiple payments
6. Class-Recording (One-to-one) // Each class have separate recording
7. Bidirectional relation between User and Certificate
    1. User-Certificate (One-to-one) // Certificate is given to specific user
    2. Certificate-User (Many-to-one) // A user can have multiple certificate of multiple courses

Note:- For establishing relation between entities, mapping annotations are used like @OneToOne, @OneToMany, @ManyToOne and some libraries are used to set and get attributes like Lombok which provides automatically getters and setters. We don't need to write manually.





# Queries that are fired at each steps.

Note:- On practical implementation, these(users,courses,classes,instructors,enrollments,payments,recordings,certificates) tables are created in database.
1. For User registration
   insert into users(username,email,password,mobileNo,gender) values ("Aman Sharma","amansharma123@gmail.com","1234","1234567890","MALE");
2. For User login
   select * from users where email="amansharma123@gmail.com" and password="1234";
3. For explore courses
   select * from courses;
4. For enrollment
   insert into enrollments (userId,courseId,enrollmentDate) values (1,232,"2023-09-10"); // These values are imaginary
5. For payment
   insert into payments (userId,courseId,amount,paymentDate) values (1,232,699,"2023-09-10");
6. For classes
   select * from classes;
7. For recordings
   select * from recording where classId=1;
8. For certificate
   select * from certificate where userId=1 and courseId=232;

* Some other queries
1. For instructor registration
   insert into users (instructorname,email,mobileNo,specialization,gender) values ("Diya Sharma","diyasharma123@gmail.com","1234567890","Makeup","FEMALE");
2. For course addition
   insert into courses (coursename,description,duration,instructor,category,price) values ("Makeup Beginner Course by Diya Sharma","In this course, you will learn basic makeup",3,"Diya Sharma","Makeup",399);
3. For class schedule
   insert into classes (courseId,date,time,topic,zoomlink) values (232,"2023-09-20","Use of liner","https://zoomlink");


