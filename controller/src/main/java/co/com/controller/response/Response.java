package co.com.controller.response;

public class Response {

	private Object data;
	
	public Response(Object data) {
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}
	
	public static Response createResponse(Object data) {
		return new Response(data);
	}
}
