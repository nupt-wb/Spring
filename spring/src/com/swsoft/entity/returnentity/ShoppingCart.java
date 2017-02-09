package com.swsoft.entity.returnentity;

import java.util.Date;

public class ShoppingCart {
private int id;
private String username;
private String zlbh;
private String spbh;
private int sl;
private String price;
private String zj;
private Date submitDate;

public String getZj() {
	return zj;
}
public void setZj(String zj) {
	this.zj = zj;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
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
public int getSl() {
	return sl;
}
public void setSl(int sl) {
	this.sl = sl;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public Date getSubmitDate() {
	return submitDate;
}
public void setSubmitDate(Date submitDate) {
	this.submitDate = submitDate;
}

}
