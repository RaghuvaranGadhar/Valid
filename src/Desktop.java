//import java.math.BigInteger;

public class Desktop {
	String asid;
	String an;
	String ab;
	String at;
	String cpuid;
	String floor;
	String hdd;
	String location;
	String make;
	String model;
	String os;
	String ram;
	String slocation;
	String sno;
	String type;
	public Desktop(String asid,String an,String ab, String at, String cpuid,
			String floor, String hdd, String location,
			String make, String model, String os,
			String ram, String slocation, String sno,
			String type) {
		// TODO Auto-generated constructor stub
		this.asid=asid;
		this.an=an;
		this.ab=ab;
		this.at=at;
		this.cpuid=cpuid;
		this.floor=floor;
		this.hdd=hdd;
		this.location=location;
		this.make=make;
		this.model=model;
		this.os=os;
		this.ram=ram;
		this.slocation=slocation;
		this.sno=sno;
		this.type=type;
	}
	
	public String getasid() {
		return asid;
	}

	public String getan() {
		return an;
	}
	
	public String getab() {
		return ab;
	}
	
	public String getat() {
		return at;
	}
	
	public String getcpuid() {
		return cpuid;
	}
	
	public String getfloor() {
		return floor;
	}
	
	public String gethdd() {
		return hdd;
	}
	
	public String getlocation() {
		return location;
	}
	
	public String getmake() {
		return make;
	}
	
	public String getmodel() {
		return model;
	}
	
	public String getos() {
		return os;
	}
	
	public String getram() {
		return ram;
	}
	
	public String getslocation() {
		return slocation;
	}
	
	public String getsno() {
		return sno;
	}
	
	public String gettype() {
		return type;
	}
}
