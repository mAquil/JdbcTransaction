package com.stackroute.spring.jdbc.main;

import com.stackroute.spring.jdbc.model.Actor;
import com.stackroute.spring.jdbc.model.Movie;
import com.stackroute.spring.jdbc.service.MovieManagerImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stackroute.spring.jdbc.service.MovieManager;

public class TransactionManagerMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		MovieManager movieManager = ctx.getBean("movieManager",
				MovieManagerImpl.class);

		Movie cust = createDummyCustomer();
		movieManager.createMovie(cust);

		ctx.close();
	}

	private static Movie createDummyCustomer() {
		Movie movie = new Movie();
		movie.setMovieName("Raazi");
		movie.setMovieId(34);
		movie.setReleaseYear(2016);
		movie.setRating(4);
		Actor actor = new Actor();
		actor.setId(9);
		actor.setName("akshay");
		actor.setGender("male");
		actor.setAge(52);
		// setting value more than 20 chars, so that SQLException occurs

		movie.setActor(actor);
		return movie;
	}

}
