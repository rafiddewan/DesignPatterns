import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BuddyInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8981857269293221592L;
	private String name, address, phone;
	private int age;

	/* Constructor
	*/


	public BuddyInfo(String name, String address, String phone, int age) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.age = age;
	}
	
	public BuddyInfo(BuddyInfo b) {
		this(b.getName(), b.getAddress(), b.getPhone(), b.getAge());
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public boolean equals(BuddyInfo buddy) {
		if(buddy == null) return false; 
		if(buddy == this) return true;
		if(buddy.getClass() != this.getClass()) return false;
		BuddyInfo bud = (BuddyInfo)buddy;
		if(bud.getAddress().equals(this.address) && bud.getName().equals(this.name) && bud.getPhone().equals(this.phone) && bud.getAge() == this.age) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return this.name + "#" + this.address + "#" + this.phone + "#" + this.age;
	}
	
	public String greeting() {
		return "Hi " + this.name;
	}
	
	public boolean isOver18() {
		return this.age > 18;
	}
	
	public String toXML() {
		String s = "<BuddyInfo>\n";
		s += "<name>" + this.name + "</name> \n";
		s += "<age>" + this.age + "</age> \n";
		s += "<address>" + this.address + "</address> \n";
		s += "<phone>" + this.phone + "</phone>\n";
		s += "</BuddyInfo>";
		return s;
	}
	
	
	public static BuddyInfo importBuddy(String info) {
		String[] s = info.split("#");
		BuddyInfo b = new BuddyInfo(s[0], s[1], s[2], Integer.parseInt(s[3]));
		return b;		
	}
	
}