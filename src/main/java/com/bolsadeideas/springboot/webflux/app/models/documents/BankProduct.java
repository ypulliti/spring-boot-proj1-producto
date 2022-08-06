package com.bolsadeideas.springboot.webflux.app.models.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="productos")
public class BankProduct
{
	@Id
	private String id;
	private String name;
	private String productType;
	private int comision;
	private Date createAt;
	private int limitMovimientos;

	public BankProduct() {}


	public BankProduct(String nombre, String producttype, int comision, int limitMovimientos) {
		this.name = nombre;
		this.productType = producttype;
		this.comision = comision;
		this.limitMovimientos = limitMovimientos;
	}

	public BankProduct(String nombre, String producttype, String id, int comision, int limitMovimientos) {
		this.name = nombre;
		this.productType = producttype;
		this.id = id;
		this.comision = comision;
		this.limitMovimientos = limitMovimientos;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public int getComision()
	{
		return comision;
	}

	public void setComision(int comision)
	{
		this.comision = comision;
	}

	public int getLimitMovimientos()
	{
		return limitMovimientos;
	}

	public void setLimitMovimientos(int limitMovimientos)
	{
		this.limitMovimientos = limitMovimientos;
	}
}
