package com.morenkov.morestat.dto.users.feed;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.morenkov.morestat.dto.common.*;

import java.util.List;

public class MediaFeedData {
	@JsonProperty("caption")
	private Caption caption;

	@JsonProperty("comments")
	private Comments comments;

	@JsonProperty("created_time")
	private String createdTime;

	@JsonProperty("id")
	private String id;

	@JsonProperty("filter")
	private String imageFilter;

	@JsonProperty("images")
	private Images images;

	@JsonProperty("videos")
	private Videos videos;

	@JsonProperty("likes")
	private Likes likes;

	@JsonProperty("link")
	private String link;

	@JsonProperty("location")
	private Location location;

	@JsonProperty("tags")
	private List<String> tags;

	public static final String TYPE_IMAGE = "image";
	public static final String TYPE_VIDEO = "video";

	@JsonProperty("type")
	private String type;

	@JsonProperty("user")
	private User user;

	@JsonProperty("user_has_liked")
	private boolean userHasLiked;

	@JsonProperty("users_in_photo")
	private List<UsersInPhoto> usersInPhotoList;

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the comments
	 */
	public Comments getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(Comments comments) {
		this.comments = comments;
	}

	/**
	 * @return the caption
	 */
	public Caption getCaption() {
		return caption;
	}

	/**
	 * @param caption the caption to set
	 */
	public void setCaption(Caption caption) {
		this.caption = caption;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the likes
	 */
	public Likes getLikes() {
		return likes;
	}

	/**
	 * @param likes the likes to set
	 */
	public void setLikes(Likes likes) {
		this.likes = likes;
	}

	/**
	 * @return the createdTime
	 */
	public String getCreatedTime() {
		return createdTime;
	}

	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @return the images
	 */
	public Images getImages() {
		return images;
	}

	/**
	 * @param images the images to set
	 */
	public void setImages(Images images) {
		this.images = images;
	}

	/**
	 * @return the imageFilter
	 */
	public String getImageFilter() {
		return imageFilter;
	}

	/**
	 * @param imageFilter the imageFilter to set
	 */
	public void setImageFilter(String imageFilter) {
		this.imageFilter = imageFilter;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public boolean isUserHasLiked() {
		return userHasLiked;
	}

	public void setUserHasLiked(boolean userHasLiked) {
		this.userHasLiked = userHasLiked;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Videos getVideos() {
		return videos;
	}

	public void setVideos(Videos videos) {
		this.videos = videos;
	}

 

	public List<UsersInPhoto> getUsersInPhotoList() {
		return usersInPhotoList;
	}

	public void setUsersInPhotoList(List<UsersInPhoto> usersInPhotoList) {
		this.usersInPhotoList = usersInPhotoList;
	}

	@Override
	public String toString() {
		return String
				.format("MediaFeedData [caption=%s, comments=%s, createdTime=%s, id=%s, imageFilter=%s, images=%s, likes=%s, link=%s, location=%s, tags=%s, type=%s, user=%s, userHasLiked=%s, usersInPhoto=%s]",
						caption, comments, createdTime, id, imageFilter, images, likes, link, location, tags, type,
						user, userHasLiked, usersInPhotoList);
	}
}
