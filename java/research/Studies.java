package research;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Studies {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer studyId;
	
	private String studyName;
	
	//BiDirectional Many to Many.
	//Set type more efficient than ArrayList. Hibernate creates more SQL statements if using ArrayList.
	@ManyToMany(mappedBy = "studiesSet")
	private Set<Users> usersSet = new HashSet<>();
	
	//No argument constructor
	public Studies() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(studyId, studyName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studies other = (Studies) obj;
		return Objects.equals(studyId, other.studyId) && Objects.equals(studyName, other.studyName);
	}

	public Integer getStudyId() {
		return studyId;
	}

	public void setStudyId(Integer studyId) {
		this.studyId = studyId;
	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}
	
	public Set<Users> getUsersSet() {
		return usersSet;
	}

	public void setUsersSet(Set<Users> usersSet) {
		this.usersSet = usersSet;
	}

	@Override
	public String toString() {
		return "Studies [studyId=" + studyId + ", studyName=" + studyName + "]";
	}
	
	

}

