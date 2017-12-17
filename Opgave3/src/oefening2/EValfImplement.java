package oefening2;

import java.util.Calendar;
import java.util.Date;

import opgave2.oefening2.Docent;
import opgave2.oefening2.Student;

public class EValfImplement extends EValf {

	@Override
	protected EValf getInstance() {
		if (instance == null)
			instance = new EValfImplement();
		return instance;
	}
	
	public static void main(String[] args) {
		EValfImplement evalf = new EValfImplement();
		
		Docent docent = new Docent("Diath", "Woodrow");
		MessageImplement message = new MessageImplement(Calendar.getInstance().getTime(), docent);
		Student student = new Student("Anukha", "Fashii");
		System.out.println(evalf.post(message));
		message = new MessageImplement(Calendar.getInstance().getTime(), student);
		System.out.println(evalf.post(message));
	}
}
