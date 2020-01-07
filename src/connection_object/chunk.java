package connection_object;

public class chunk {

	private Integer number_of_records;
	private String instance_code;
	private String call_success;
	private Integer call_object_hashcode;
	
	public Integer getCall_object_hashcode() {
		return call_object_hashcode;
	}

	public void setCall_object_hashcode(Integer call_object_hashcode) {
		this.call_object_hashcode = call_object_hashcode;
	}

	public String getCall_success() {
		return call_success;
	}

	public void setCall_success(String call_success) {
		this.call_success = call_success;
	}

	public Integer getNumber_of_records() {
		return number_of_records;
	}

	public void setNumber_of_records(Integer number_of_records) {
		this.number_of_records = number_of_records;
	}

	public String getInstance_code() {
		return instance_code;
	}


	@Override
	public String toString() {
		return "chunk [number_of_records=" + number_of_records + ", instance_code=" + instance_code + ", call_success="
				+ call_success + ", call_object_hashcode=" + call_object_hashcode + "]";
	}

	public void setInstance_code(String instance_code) {
		this.instance_code = instance_code;
	}

	public chunk() {
		// TODO Auto-generated constructor stub
	}

}
