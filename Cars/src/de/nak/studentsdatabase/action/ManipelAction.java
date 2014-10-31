package de.nak.studentsdatabase.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.Manipel;
import de.nak.studentsdatabase.service.ManipelService;

/**
 * Action for a single manipel.
 *
 * @author Andreas Krey
 */
public class ManipelAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;
	/** The current manipel. */
	private Manipel manipel;
	/** The manipel's identifier selected by the user. */
	private Long manipelId;
	/** The manipel service. */
	private ManipelService manipelService;

	/**
	 * Saves the manipel to the database.
	 *
	 * @return the result string.
	 */
	public String save() {
		manipelService.save(manipel);
		return SUCCESS;
	}

	/**
	 * Deletes the selected manipel from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
		manipel = manipelService.load(manipelId);
		if (manipel != null) {
			manipelService.delete(manipel);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected manipel in the company form.
	 *
	 * @return the result string.
	 */
	public String load() {
		manipel = manipelService.load(manipelId);
		return SUCCESS;
	}

	/**
	 * Cancels the editing.
	 * This method is implemented in order to avoid problems with parameter submit and validation.
	 *
	 * @return the result string.
	 */
	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		// If the manipel is not set, the manipel ID has to be set.
		if (manipel == null && manipelId == null) {
			addActionError(getText("msg.selectManipel")); //Ändern!
		}
	}

	public Manipel getManipel() {
		return manipel;
	}

	public void setManipel(Manipel manipel) {
		this.manipel = manipel;
	}

	public Long getManipelId() {
		return manipelId;
	}

	public void setManipelId(Long manipelId) {
		this.manipelId = manipelId;
	}

	public void setManipelService(ManipelService manipelService) {
		this.manipelService = manipelService;
	}
}
