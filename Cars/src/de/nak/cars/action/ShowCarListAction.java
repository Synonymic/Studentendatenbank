package de.nak.cars.action;

import com.opensymphony.xwork2.Action;

import de.nak.cars.service.CarService;
import de.nak.studentendatenbank.model.Student;

import java.util.List;

/**
 * Action that shows a list of cars.
 *
 * @author Stephan Anft
 */
public class ShowCarListAction implements Action {
	/** The list of cars. */
	private List<Student> carList;

	/** The car service. */
	private CarService carService;

	@Override
	public String execute() throws Exception {
		carList = carService.loadAllCars();
		return SUCCESS;
	}

	public List<Student> getCarList() {
		return carList;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}
}
