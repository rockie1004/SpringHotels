package dmacc.beans;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String amenity;
	@Autowired
	private Address address;
	
	public Hotel() {
		super();
	}
	
	public Hotel(String name) {
		super();
		this.name = name;
	}

	public Hotel(String name, String amenity) {
		super();
		this.name = name;
		this.amenity = amenity;
	}
	public Hotel(long id, String name, String amenity) {
		super();
		this.id = id;
		this.name = name;
		this.amenity = amenity;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return amenity;
	}
	public void setPhone(String amenity) {
		this.amenity = amenity;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", amenity=" + amenity + ", address=" + address + "]";
	}
}
