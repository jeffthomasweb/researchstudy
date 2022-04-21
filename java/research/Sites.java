package research;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Sites {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer siteId;
	
	private String name;
	
	//BiDirectional Many to one. Many sites possible per a User. 
	@ManyToOne
	private Users sites;
	
	//No argument constructor
	public Sites() {
	}

	public Integer getSiteId() {
		return siteId;
	}

	
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Users getSites() {
		return sites;
	}

	public void setSites(Users sites) {
		this.sites = sites;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, siteId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sites other = (Sites) obj;
		return Objects.equals(name, other.name) && Objects.equals(siteId, other.siteId);
	}

	@Override
	public String toString() {
		return "Sites [siteId=" + siteId + ", name=" + name + "]";
	}

	
	
}
