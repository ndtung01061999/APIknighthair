package booking.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import booking.entity.Comment;

public class CommentDTO implements Comment{
	String name;
	String avatar;
	String comment;
	int point;
	
	public CommentDTO(String name, String avatar, String comment, int point) {
		super();
		this.name = name;
		this.avatar = avatar;
		this.comment = comment;
		this.point = point;
	}

	public String getName() {
		return name;
	}


	public String getAvatar() {
		return avatar;
	}

	public String getComment() {
		return comment;
	}


	public int getPoint() {
		return point;
	}


}
