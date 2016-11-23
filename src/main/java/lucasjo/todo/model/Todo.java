package lucasjo.todo.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="todo")
public class Todo extends AbstractTimeStampEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	private String text;
	// 01 :  진행중, 02: 완료
	private String toDoSts;
	// C : create, U : 변경, D: 삭제
	private String sts;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date closeDt;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Todo [id=");
		builder.append(id);
		builder.append(", text=");
		builder.append(text);
		builder.append(", toDoSts=");
		builder.append(toDoSts);
		builder.append(", sts=");
		builder.append(sts);
		builder.append(", closeDt=");
		builder.append(closeDt);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
