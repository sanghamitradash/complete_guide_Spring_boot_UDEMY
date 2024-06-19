package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMemberShipDAO){
		return runner ->{

			demoTheBeforeAdvice(theAccountDAO, theMemberShipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMemberShipDAO) {

		//call the business method
		theAccountDAO.addAccount();

		//call the membership business method
		//this method will not match bcz I have mentioned the exact specific DAO in myDemoLogging Aspect
		theMemberShipDAO.addAccount();

	}
}
