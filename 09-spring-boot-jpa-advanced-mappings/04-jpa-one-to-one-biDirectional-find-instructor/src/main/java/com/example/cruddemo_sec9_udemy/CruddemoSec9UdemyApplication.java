package com.example.cruddemo_sec9_udemy;

import com.example.cruddemo_sec9_udemy.dao.AppDAO;
import com.example.cruddemo_sec9_udemy.entity.Instructor;
import com.example.cruddemo_sec9_udemy.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoSec9UdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoSec9UdemyApplication.class, args);
	}

	//create command line runner
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		//java LAMBDA expression
		return runner -> {
			//createInstructor(appDAO);

			//findInstructor(appDAO);

			//deleteInstructor(appDAO);

			findInstructorDetail(appDAO);

		};
	}

	private void findInstructorDetail(AppDAO appDAO) {

		//get the instructor detail object
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		//print the instructor detail
		System.out.println("tempInstructorDetail: "+tempInstructorDetail);

		//print the associated instructor
		System.out.println("the associated instructor: "+tempInstructorDetail.getInstructor());

		System.out.println("Done!!");

	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting the instructor id: "+theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done!!");
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 2;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("the associated instructorDetail only: "+ tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		/*
		//create the instructor
		Instructor tempInstructor = new Instructor("Chad","Darby","chad@gmail.com");

		//create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"https://www.youtube.com/youtube",
				"love to code");

		 */

		//create the instructor
		Instructor tempInstructor = new Instructor("Madhu","Patel","madhu@gmail.com");

		//create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"https://www.youtube.com/youtube",
				"love to dance");


		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		//
		//NOTE: this will ALSO save the details object
		//because of cascadeType.ALL
		//
		System.out.println("Saving instructor: "+tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!!");
	}

}
