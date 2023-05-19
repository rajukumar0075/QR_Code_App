package in.code.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5472404251568128459L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String paper1Marks;
	private String paper2Marks;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Student student = (Student) o;
		return id == student.id && Objects.equals(paper1Marks, student.paper1Marks)
				&& Objects.equals(paper2Marks, student.paper2Marks);
	}

}
