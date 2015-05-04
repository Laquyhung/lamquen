package baithigiuakylan2;

public class SpecialSubject extends Subject implements ISpecialSubject {
	private String chuongTrinh;

	public SpecialSubject(String maMon, String tenMon, int tcHocPhan,
			int tcThucHanh, String cT) {
		super(maMon, tenMon, tcHocPhan, tcThucHanh);
		this.chuongTrinh = cT;
	}

	@Override
	public int getSpecialFee() {
		if (chuongTrinh.equalsIgnoreCase("SIE"))
			return 80 * getTcHocPhan();
		if (chuongTrinh.equalsIgnoreCase("HEDSPI"))
			return 30 * getTcHocPhan();
		if (chuongTrinh.equalsIgnoreCase("ICT"))
			return 50 * getTcHocPhan();
		return 0;
	}

	@Override
	public int getFee() {
		return super.getFee() + getSpecialFee();
	}

	@Override
	public String toString() {
		return this.getMaMon() + "\t\t"+this.getTenMon()+"\t\t"+this.chuongTrinh+"\t\t"+this.tcHocPhi()+"\t\t"+this.getFee();
	}
	
	

}
