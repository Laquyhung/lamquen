package baithigiuakylan2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubjectManagement {
	List<ISubject> mang = new ArrayList<ISubject>();
	Scanner nhap;
	Scanner nhap1 = new Scanner(System.in);
	Scanner nhap2 = new Scanner(System.in);
	Scanner nhap3 = new Scanner(System.in);

	public SubjectManagement() {
	}

	public void meNu() {
		System.out.println("Enrolment Management System");
		System.out.println("----------------------------------");
		System.out.println("1. Add a normal subject");
		System.out.println("2. Add a special subject");
		System.out.println("3. Remove a subject");
		System.out.println("4. Display subject information");
		System.out.println("Your choice (1-4, other to quit):");
	}

	public boolean kiemTra(String maMon) {
		for (ISubject mon : mang) {
			if (((Subject) mon).getMaMon().equalsIgnoreCase(maMon))
				return true;
		}
		return false;
	}

	public void addMonBT(Subject mon) {
		if (kiemTra(mon.getMaMon()) == true)
			System.out.println("Da trung mon");
		else {
			mang.add(mon);
			System.out.println("Da them mon");
		}

	}

	public void addMonDB(SpecialSubject mon) {
		if (kiemTra(mon.getMaMon()) == true)
			System.out.println("Da trung mon");
		else {
			mang.add(mon);
			System.out.println("Da them mon");
		}

	}

	public int timMon(String maMon) {
		for (int i = 0; i < mang.size(); i++) {
			if (kiemTra(maMon) == true)
				return i;
		}
		return -1;
	}

	public void xoaMon(Subject mon) {
		if (timMon(mon.getMaMon()) != -1) {
			mang.remove(timMon(mon.getMaMon()));
			System.out.println("Da xoa mon");
		} else
			System.out.println("Khong co mon trong danh sach");
	}

	public void hienThi() {
		System.out.println("Normal subject");
		System.out.println("SubjectID\t" + "SubjectName\t" + "Credits\t\t"
				+ "Fee");
		for (ISubject mon : mang) {
			if (mon instanceof Subject) {
				System.out.println(mon.toString());
			}
		}

		System.out.println("Special subject");
		System.out.println("SubjectID\t" + "SubjectName\t" + "Program\t"
				+ "Credits\t\t" + "Fee");
		for (ISubject mon : mang) {
			if (mon instanceof SpecialSubject) {
				System.out.println(mon.toString());
			}
		}
	}

	public int chuongTrinh() {
		nhap = new Scanner(System.in);
		int i = -1;
		System.out.println("Nhap so: ");
		i = nhap.nextInt();
		switch (i) {
		case 1:
			System.out.print("Nhap ma mon:");
			String a = nhap1.nextLine();
			System.out.print("Nhap ten mon:");
			String b = nhap1.nextLine();
			System.out.print("Nhap so tin chi hoc phan:");
			int c = nhap2.nextInt();
			System.out.print("Nhap so tin chi thuc hanh:");
			int d = nhap2.nextInt();
			Subject mon = new Subject(a, b, c, d);
			addMonBT(mon);
			break;
		case 2:
			System.out.print("Nhap ma mon:");
			String a1 = nhap1.nextLine();
			System.out.print("Nhap ten mon:");
			String b1 = nhap1.nextLine();
			System.out.print("Nhap so tin chi hoc phan:");
			int c1 = nhap2.nextInt();
			System.out.print("Nhap so tin chi thuc hanh:");
			int d1 = nhap2.nextInt();
			System.out.print("Nhap ma so mon dac biet");
			String e1 = nhap1.nextLine();
			SpecialSubject mon1 = new SpecialSubject(a1, b1, c1, d1, e1);
			addMonDB(mon1);
			break;
		case 3:
			System.out.print("Nhap ma mon:");
			String a2 = nhap1.nextLine();
			System.out.print("Nhap ten mon:");
			String b2 = nhap1.nextLine();
			System.out.print("Nhap so tin chi hoc phan:");
			int c2 = nhap2.nextInt();
			System.out.print("Nhap so tin chi thuc hanh:");
			int d2 = nhap2.nextInt();
			Subject mon2 = new Subject(a2, b2, c2, d2);
			xoaMon(mon2);
			break;
		case 4:
			hienThi();
			break;
		default:
			i = -1;
			break;
		}
		return i;
	}

	public static void main(String[] args) {
		SubjectManagement hung = new SubjectManagement();
		boolean a = true;
		do {
			hung.meNu();
			if (hung.chuongTrinh() == -1)
				a = false;
		} while (a);
	}

}
