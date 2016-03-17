package model;

public class Triple {
	private int tripleID;
	private String subject;
	private String object;
	private String predicate;
	public Triple() {
		super();
	}
	public Triple(int tripleID, String subject, String object, String predicate) {
		super();
		this.tripleID = tripleID;
		this.subject = subject;
		this.object = object;
		this.predicate = predicate;
	}
	public int getTripleID() {
		return tripleID;
	}
	public void setTripleID(int tripleID) {
		this.tripleID = tripleID;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getPredicate() {
		return predicate;
	}
	public void setPredicate(String predicate) {
		this.predicate = predicate;
	}
}
