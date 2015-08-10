package com.example.test;

public class Member {
	private String name;
	private String gender;
	private Member like;
	private int liked;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Member getLike() {
		return like;
	}
	public void setLike(Member like) {
		this.like = like;
	}
	public int getLiked() {
		return liked;
	}
	public void setLiked(int liked) {
		this.liked = liked;
	}

}
