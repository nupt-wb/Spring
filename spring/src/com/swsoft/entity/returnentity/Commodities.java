package com.swsoft.entity.returnentity;

import java.util.Date;

public class Commodities {
private int id; 
private String zlbh;
private String spbh;
private String name;
private String price;
private int sl;
private Date submitDate;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getZlbh() {
	return zlbh;
}
public void setZlbh(String zlbh) {
	this.zlbh = zlbh;
}
public String getSpbh() {
	return spbh;
}
public void setSpbh(String spbh) {
	this.spbh = spbh;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public int getSl() {
	return sl;
}
public void setSl(int sl) {
	this.sl = sl;
}
public Date getSubmitDate() {
	return submitDate;
}
public void setSubmitDate(Date submitDate) {
	this.submitDate = submitDate;
}

}
