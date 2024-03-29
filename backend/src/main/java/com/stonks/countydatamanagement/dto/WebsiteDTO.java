package com.stonks.countydatamanagement.dto;

import java.io.Serializable;

import com.stonks.countydatamanagement.entities.Website;

public class WebsiteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String link;
	
	public WebsiteDTO() {
		
	}
	
	public WebsiteDTO(Website entity) {
		this.id = entity.getId();
		this.link = entity.getLink();
	}

	public WebsiteDTO(Long id, String link) {
		super();
		this.id = id;
		this.link = link;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebsiteDTO other = (WebsiteDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
