package com.bolsadeideas.springboot.webflux.app.models.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="clients")
public class BankClient
{
	@Id
	private String id;
	private String name;
	private String typeClient;
	private Date createAt;

	public BankClient() {}

	public BankClient(String nombre, String tipoClient) {
		this.name = nombre;
		this.typeClient = tipoClient;
	}

	public BankClient(String nombre, String tipoClient, String id) {
		this.name = nombre;
		this.typeClient = tipoClient;
		this.id = id;
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
	public String getTypeClient() {
		return typeClient;
	}
	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	

}
