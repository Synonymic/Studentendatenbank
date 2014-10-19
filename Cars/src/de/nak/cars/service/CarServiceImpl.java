package de.nak.cars.service;

import de.nak.studentendatenbank.dao.StudentDAO;
import de.nak.studentendatenbank.model.Student;

import java.util.List;

/**
 * The car service implementation class.
 *
 * @author Stephan Anft
 */
public class CarServiceImpl implements CarService {
	/** The car DAO. */
	private StudentDAO carDAO;

	@Override
	public void saveCar(Student car) {
		carDAO.save(car);
	}

	@Override
	public Student loadCar(Long id) {
		return carDAO.load(id);
	}

	@Override
	public void deleteCar(Student car) {
		carDAO.delete(car);
	}

	@Override
	public List<Student> loadAllCars() {
		return carDAO.loadAll();
	}

	public void setCarDAO(StudentDAO carDAO) {
		this.carDAO = carDAO;
	}

}
