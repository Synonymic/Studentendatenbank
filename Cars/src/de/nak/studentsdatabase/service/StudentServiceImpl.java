package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.dao.StudentDAO;
import de.nak.studentsdatabase.model.DiscontinuedStudent;
import de.nak.studentsdatabase.model.ExmatriculatedStudent;
import de.nak.studentsdatabase.model.ImmatriculatedStudent;
import de.nak.studentsdatabase.model.Student;

/**
 * The student service implementation class.
 * 
 * @author Dirk Johannﬂen
 *
 */
public class StudentServiceImpl implements StudentService {

	/**
	 * The studentDAO.
	 */
	private StudentDAO studentDAO;
	
	@Override
	public void save(Student student) {
		studentDAO.save(student);

	}

	@Override
	public Student load(Long id) {
		return studentDAO.load(id);
	}

	@Override
	public List<Student> loadAll() {
		return studentDAO.loadAll();
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void exmatriculate(Student student) {
		
		ExmatriculatedStudent exStudent = new ExmatriculatedStudent();
		exStudent.setAddress(student.getAddress());
		exStudent.setCompany(student.getCompany());
		exStudent.setContact(student.getContact());
		exStudent.setDayOfBirth(student.getDayOfBirth());
		exStudent.setFirstName(student.getFirstName());
		exStudent.setName(student.getName());
		exStudent.setGender(student.getGender());
		exStudent.setManipel(student.getManipel());
		exStudent.setMatriculationNumber(student.getMatriculationNumber());
		exStudent.setPlaceOfBirth(student.getPlaceOfBirth());
		exStudent.setSalutation(student.getSalutation());
		exStudent.setZenturie(student.getZenturie());
		studentDAO.exmatriculate( exStudent);

	}

	@Override
	public void discontinue(Student student) {
		DiscontinuedStudent disStudent = new DiscontinuedStudent();
		disStudent.setAddress(student.getAddress());
		disStudent.setCompany(student.getCompany());
		disStudent.setContact(student.getContact());
		disStudent.setDayOfBirth(student.getDayOfBirth());
		disStudent.setFirstName(student.getFirstName());
		disStudent.setName(student.getName());
		disStudent.setGender(student.getGender());
		disStudent.setManipel(student.getManipel());
		disStudent.setMatriculationNumber(student.getMatriculationNumber());
		disStudent.setPlaceOfBirth(student.getPlaceOfBirth());
		disStudent.setSalutation(student.getSalutation());
		disStudent.setZenturie(student.getZenturie());
		studentDAO.discontinue(disStudent);

	}

	@Override
	public void immatriculate(Student student) {

		ImmatriculatedStudent newStudent = new ImmatriculatedStudent();
		newStudent.setAddress(student.getAddress());
		newStudent.setCompany(student.getCompany());
		newStudent.setContact(student.getContact());
		newStudent.setDayOfBirth(student.getDayOfBirth());
		newStudent.setFirstName(student.getFirstName());
		newStudent.setName(student.getName());
		newStudent.setGender(student.getGender());
		newStudent.setManipel(student.getManipel());
		newStudent.setMatriculationNumber(student.getMatriculationNumber());
		newStudent.setPlaceOfBirth(student.getPlaceOfBirth());
		newStudent.setSalutation(student.getSalutation());
		newStudent.setZenturie(student.getZenturie());
		newStudent.setUserIdentification(student.getMatriculationNumber());
		studentDAO.immatriculate(newStudent);
	}

}
