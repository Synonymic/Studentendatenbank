package de.nak.cars.service;

import de.nak.studentendatenbank.model.Student;

import java.util.List;

/**
 * Car service interface.
 *
 * @author Dirk Johannssen
 */
public interface CarService {

	/**
	 * Creates or updates a car.
	 *
	 * @param car The car.
	 */
	void saveCar(Student car);

	/**
	 * Loads a single car.
	 *
	 * @param id The identifier.
	 * @return a car or null.
	 */
	Student loadCar(Long id);

	/**
	 * Deletes the given car.
	 *
	 * @param car The car.
	 */
	void deleteCar(Student car);

	/**
	 * Loads a list of all cars.
	 *
	 * @return a list which is empty if no car was found.
	 */
	List<Student> loadAllCars();

}
