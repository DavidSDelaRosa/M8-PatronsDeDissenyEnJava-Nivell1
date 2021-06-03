package com.video.domain;

import java.util.List;

public class Video {
	
	private int videoId;
	private String url;
	private String tittle;
	private User owner;
	List<Tag> tags;
	private static int videosCount = 1;
	
	public Video(String url, String tittle, User owner, List<Tag> tags) {
		super();
		this.url = url;
		this.tittle = tittle;
		this.owner = owner;
		this.tags = tags;
		videoId = videosCount;
		videosCount++;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public int getVideoId() {
		return videoId;
	}

	public static int getVideosCount() {
		return videosCount;
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", url=" + url + ", tittle=" + tittle + ", owner=" + owner + ", tags="
				+ tags + "]";
	}

}
