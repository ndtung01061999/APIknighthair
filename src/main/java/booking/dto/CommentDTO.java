package booking.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import booking.entity.Comment;

public class CommentDTO implements Comment {
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

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}