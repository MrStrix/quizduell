package quizduell;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//Below annotation defines root element of XML file
@XmlRootElement
//You can define order in which elements will be created in XML file
//Optional
@XmlType(propOrder = { "questionName", "correctAnswer", "answerList" })
public class Question {

	private String questionName;
	private ArrayList<String> answerList = new ArrayList<String>();
	private int correctAnswer;
	
	
	public Question() {
		super();
	}
	
	public boolean verify(int answer) {
		if(answer == this.correctAnswer)
			return true;
		else
			return false;
	}
	
	public String getAnswerList1() {
		String answers="";
		for( int i = 0; i < this.answerList.size(); i++ ) {
			answers += i + ") " + this.answerList.get(i) + "\n";
		}
		return answers;
	}
	
	
	
	/**
	 * @param questionName the questionName to set
	 */
	@XmlElement
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	/**
	 * @param correctAnswer the correctAnswer to set
	 */
	@XmlElement  
	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	// XmLElementWrapper generates a wrapper element around XML representation  
	@XmlElementWrapper(name = "answerList")  
	// XmlElement sets the name of the entities in collection  
	@XmlElement(name = "answer")  
	public void setAnswerList(ArrayList<String> answerList) {
		this.answerList = answerList;
	}
	
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return questionName;
	}

	/**
	 * @return the answers
	 */
	public ArrayList<String> getAnswerList() {
		return answerList;
	}

	/**
	 * @return the correctAnswer
	 */
	public int getCorrectAnswer() {
		return correctAnswer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [questionName=" + questionName + ", answerList="
				+ answerList + ", correctAnswer=" + correctAnswer + "]";
	}
	
	
	
}
