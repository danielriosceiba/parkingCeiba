package co.com.parking.domain.dto;

public class CompositeResponse {
	
	public static final String ERROR = "ERROR"; 
	public static final String SUCCESS = "SUCCESS"; 
	public static final String WARNING = "WARNING"; 
	public static final String INFO = "INFO"; 
	
	private String result;
	private String text;
	
	public CompositeResponse(String result) {
		this.result = result;
	}

	public CompositeResponse(String result, String text) {
		this.result = result;
		this.text = text;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}