package org.xq.pojo;

import java.io.Serializable;
import java.util.List;

public class Cust implements Serializable {
	private Integer id;
	private String name;
	private String address;
	private String phone;
	private List<Integer> ids;
	
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Cust [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	
}
