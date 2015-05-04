package baithigiuakylan2;

public class Subject implements ISubject {
	private String maMon;
	public String getMaMon() {
		return maMon;
	}

	private String tenMon;
	public String getTenMon() {
		return tenMon;
	}

	private int tcHocPhan;
	
	public int getTcHocPhan() {
		return tcHocPhan;
	}

	private int tcThucHanh;
	private int tcHocPhi;
	private int hPhi;

	public Subject(String maMon, String tenMon, int tcHocPhan, int tcThucHanh) {
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.tcHocPhan = tcHocPhan;
		this.tcThucHanh = tcThucHanh;
	}

	public int tcHocPhi() {
		tcHocPhi = tcThucHanh*2+(tcHocPhan-tcThucHanh);
		return tcHocPhi;
		
	}
	@Override
	public int getFee() {
		hPhi = tcHocPhi()*120;
		return hPhi;
	}
	
	
	
	@Override
	public String toString() {
		return this.maMon + "\t\t"+this.tenMon+"\t\t"+this.tcHocPhi()+"\t\t"+this.getFee();
	}

	public static void main(String[] agrs) {
		Subject hung = new Subject("11", "java", 3, 2);
		System.out.println(hung.getFee());
	}
}
