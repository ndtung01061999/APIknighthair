package booking.dto;

import java.util.Iterator;
import java.util.List;

import booking.entity.Comment;

public class StoreCommentDTO {
	List<Comment> listcomment;

	public float getAvgPoint() {
		int avgPoint = 0;
		int n =  listcomment.size();
		for (int i = 0; i < listcomment.size(); i++) {
			avgPoint += listcomment.get(i).getPoint();
		}
		if(n>0)
		return avgPoint / n;
		else return 0;
	}

	public List<Comment> getListcomment() {
		return listcomment;
	}

	public void setListcomment(List<Comment> listcomment) {
		this.listcomment = listcomment;
	}

}
