package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		//Lambda expression
		return runner ->{
			//createStudent(studentDAO);
			createMultipleStudent(studentDAO);

			//STEP 3: Update main app for read the object
			//readStudent(studentDAO);

			//STEP-3: Update main app for query the object
			//queryForStudent(studentDAO);

			//queryForStudentByLastName(studentDAO);

			//STEP-3: Update main app for updating the object
			//updateStudent(studentDAO);

			//STEP-3: Update main app for deleting the object
			//deleteStudent(studentDAO);

			//STEP-3: Update main app for deleting all object
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count "+ numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on id: primary key
		int studentId = 2;
		System.out.println("Getting student with id:" +studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first_name to "Sweety"
		System.out.println("Updating student" );
		myStudent.setFirstName("Sweety");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated student..." + myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		//get list of students
		List<Student>theStudents = studentDAO.findByLastName("Mohanty");

		//display the list of students
		for(Student tempStudents : theStudents){
			System.out.println(tempStudents);
		}
	}

	private void queryForStudent(StudentDAO studentDAO){
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}
	private void readStudent(StudentDAO studentDAO){
		//create a student object
		System.out.println("Creating new student object..");
		Student tempStudent = new Student("Jyoti", "Nayak", "jyoti@gmail.com");

		//save the object
		System.out.println("Saving student");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student.Generate id: " +theId);

		//retrieve student based on id: primary key
		System.out.println("Retrieving student with id: "+ theId);
		Student myStudent = studentDAO.findById(theId);

		//display the student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 students object...");
		Student tempStudent1 = new Student("Sangha", "Dash", "sangha@gmail.com");
		Student tempStudent2 = new Student("Bhagya", "Naik", "bhagya@gmail.com");
		Student tempStudent3 = new Student("Sweta", "Mohanty", "sweta@gmail.com");
//
//		//save the student objects
		System.out.println("Saving students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating a new student object...");
		Student tempStudent = new Student("Sangha", "Dash", "sangha@gmail.com");

		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generate id: " + tempStudent.getId());
	}

}
