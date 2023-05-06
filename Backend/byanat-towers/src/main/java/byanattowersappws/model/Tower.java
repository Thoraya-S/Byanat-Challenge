package byanattowersappws.model;

import java.io.Serializable;


public class Tower implements Serializable{
private static final long serialVersionUID = 1L;
	
	private Integer tower_id;
	private String operator;
	private String address; 
	private Integer height;
	private String tower_type;
	private Long latitude;
	private Long longitude;
	private String technology;
	public Integer getTower_id() {
		return tower_id;
	}
	public void setTower_id(Integer tower_id) {
		this.tower_id = tower_id;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getTower_type() {
		return tower_type;
	}
	public void setTower_type(String tower_type) {
		this.tower_type = tower_type;
	}
	public Long getLatitude() {
		return latitude;
	}
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	public Long getLongitude() {
		return longitude;
	}
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	

}
