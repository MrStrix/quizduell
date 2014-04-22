package quizduell;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Duel {
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Question> questions = new ArrayList<Question>();
	
	public Duel(User a, User b) {
		super();
		this.users.add(a);
		this.users.add(b);
				
		try {
   
			// create JAXB context and initializing Marshaller
			JAXBContext jaxbContext = JAXBContext.newInstance(Question.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		   
			// specify the location and name of xml file to be read
			File XMLfile = new File("/home/strix/myquestions.xml");
		   
			// this will create Java object - country from the XML file
			Question countryIndia = (Question) jaxbUnmarshaller.unmarshal(XMLfile);
		
			System.out.println("Country Name: "+countryIndia.toString());

		
		} catch (JAXBException e) {
			// some exception occured
			e.printStackTrace();
		}
		
	}
	
	public Question getQuestion() {
		return this.questions.get(0);
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Duel with "+users.get(0).getName() + " vs " + users.get(1).getName();
	}
	
	
}
