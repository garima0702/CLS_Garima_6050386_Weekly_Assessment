package com.example.Assessment2.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="abes_track")
public class Track {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="track_id")
	private long id;
	
	@Column(name="track_title")
	private String title;
	
	@Column(name="album_name")
	private String albmName;
	
	@Column(name="release_dt")
	private LocalDate releseDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlbmName() {
		return albmName;
	}

	public void setAlbmName(String albmName) {
		this.albmName = albmName;
	}

	public LocalDate getReleseDate() {
		return releseDate;
	}

	public void setReleseDate(LocalDate releseDate) {
		this.releseDate = releseDate;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", title=" + title + ", albmName=" + albmName + ", releseDate=" + releseDate + "]";
	}
	
	
	
	

}
