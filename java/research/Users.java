package research;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer userId;

    private String userName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Studies> studiesSet = new HashSet<>();
	
    @OneToMany(mappedBy = "sites", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Sites> sitesSet = new HashSet<>();
    //No argument constructor
    public Users() {
	}

	public void addStudies(Studies study) {
		studiesSet.add(study);
		//To Do: Create add method
		study.getUsersSet().add(this);
	}

	public void removeAddress(Studies study) {
		studiesSet.remove(study);
		study.getUsersSet().remove(this);
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(userId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(userId, other.userId) && Objects.equals(userName, other.userName);
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Studies> getStudiesSet() {
		return studiesSet;
	}

	public void setStudiesSet(Set<Studies> studiesSet) {
		this.studiesSet = studiesSet;
	}

	public Set<Sites> getSitesSet() {
		return sitesSet;
	}

	public void setSitesSet(Set<Sites> sitesSet) {
		this.sitesSet = sitesSet;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + "]";
	}
}

