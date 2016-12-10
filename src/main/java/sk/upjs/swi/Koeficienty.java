package sk.upjs.swi;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Koeficienty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6795943874934120761L;

	@Id
	@GeneratedValue
	private Long id;

	private Long idProdukt;
	/**
	 * vek poistenca
	 */
	private int vek;
	private double d1;
	private double d2;
	private double d3;
	private double d4;
	private double d5;
	private double d6;
	private double d7;
	private double d8;
	private double d9;
	private double d10;
	private double d11;
	private double d12;
	private double d13;
	private double d14;
	private double d15;
	private double d16;
	private double d17;
	private double d18;
	private double d19;
	private double d20;
	private double d21;
	private double d22;
	private double d23;
	private double d24;
	private double d25;
	private double d26;
	private double d27;
	private double d28;
	private double d29;
	private double d30;
	private double d31;
	private double d32;
	private double d33;
	private double d34;
	private double d35;
	private double d36;
	private double d37;
	private double d38;
	private double d39;
	private double d40;
	private double d41;
	private double d42;
	private double d43;
	private double d44;
	private double d45;
	private double d46;
	private double d47;
	private double d48;
	private double d49;
	private double d50;
	private double d51;
	private double d52;
	private double d53;
	private double d54;
	private double d55;
	private double d56;
	private double d57;
	private double d58;
	private double d59;
	private double d60;
	private double d61;
	private double d62;
	private double d63;
	private double d64;
	private double d65;
	private double d66;
	private double d67;
	private double d68;
	private double d69;
	private double d70;

	public Koeficienty() {
		super();
	}

	public Koeficienty(Long idProdukt, int vek, double d1, double d2, double d3, double d4, double d5, double d6,
			double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15,
			double d16, double d17, double d18, double d19, double d20, double d21, double d22, double d23, double d24,
			double d25, double d26, double d27, double d28, double d29, double d30, double d31, double d32, double d33,
			double d34, double d35, double d36, double d37, double d38, double d39, double d40, double d41, double d42,
			double d43, double d44, double d45, double d46, double d47, double d48, double d49, double d50, double d51,
			double d52, double d53, double d54, double d55, double d56, double d57, double d58, double d59, double d60,
			double d61, double d62, double d63, double d64, double d65, double d66, double d67, double d68, double d69,
			double d70) {

		this.idProdukt = idProdukt;
		this.vek = vek;
		this.d1 = d1;
		this.d2 = d2;
		this.d3 = d3;
		this.d4 = d4;
		this.d5 = d5;
		this.d6 = d6;
		this.d7 = d7;
		this.d8 = d8;
		this.d9 = d9;
		this.d10 = d10;
		this.d11 = d11;
		this.d12 = d12;
		this.d13 = d13;
		this.d14 = d14;
		this.d15 = d15;
		this.d16 = d16;
		this.d17 = d17;
		this.d18 = d18;
		this.d19 = d19;
		this.d20 = d20;
		this.d21 = d21;
		this.d22 = d22;
		this.d23 = d23;
		this.d24 = d24;
		this.d25 = d25;
		this.d26 = d26;
		this.d27 = d27;
		this.d28 = d28;
		this.d29 = d29;
		this.d30 = d30;
		this.d31 = d31;
		this.d32 = d32;
		this.d33 = d33;
		this.d34 = d34;
		this.d35 = d35;
		this.d36 = d36;
		this.d37 = d37;
		this.d38 = d38;
		this.d39 = d39;
		this.d40 = d40;
		this.d41 = d41;
		this.d42 = d42;
		this.d43 = d43;
		this.d44 = d44;
		this.d45 = d45;
		this.d46 = d46;
		this.d47 = d47;
		this.d48 = d48;
		this.d49 = d49;
		this.d50 = d50;
		this.d51 = d51;
		this.d52 = d52;
		this.d53 = d53;
		this.d54 = d54;
		this.d55 = d55;
		this.d56 = d56;
		this.d57 = d57;
		this.d58 = d58;
		this.d59 = d59;
		this.d60 = d60;
		this.d61 = d61;
		this.d62 = d62;
		this.d63 = d63;
		this.d64 = d64;
		this.d65 = d65;
		this.d66 = d66;
		this.d67 = d67;
		this.d68 = d68;
		this.d69 = d69;
		this.d70 = d70;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdProdukt() {
		return idProdukt;
	}

	public void setIdProdukt(Long idProdukt) {
		this.idProdukt = idProdukt;
	}

	public int getVek() {
		return vek;
	}

	public void setVek(int vek) {
		this.vek = vek;
	}

	public double getD1() {
		return d1;
	}

	public void setD1(double d1) {
		this.d1 = d1;
	}

	public double getD2() {
		return d2;
	}

	public void setD2(double d2) {
		this.d2 = d2;
	}

	public double getD3() {
		return d3;
	}

	public void setD3(double d3) {
		this.d3 = d3;
	}

	public double getD4() {
		return d4;
	}

	public void setD4(double d4) {
		this.d4 = d4;
	}

	public double getD5() {
		return d5;
	}

	public void setD5(double d5) {
		this.d5 = d5;
	}

	public double getD6() {
		return d6;
	}

	public void setD6(double d6) {
		this.d6 = d6;
	}

	public double getD7() {
		return d7;
	}

	public void setD7(double d7) {
		this.d7 = d7;
	}

	public double getD8() {
		return d8;
	}

	public void setD8(double d8) {
		this.d8 = d8;
	}

	public double getD9() {
		return d9;
	}

	public void setD9(double d9) {
		this.d9 = d9;
	}

	public double getD10() {
		return d10;
	}

	public void setD10(double d10) {
		this.d10 = d10;
	}

	public double getD11() {
		return d11;
	}

	public void setD11(double d11) {
		this.d11 = d11;
	}

	public double getD12() {
		return d12;
	}

	public void setD12(double d12) {
		this.d12 = d12;
	}

	public double getD13() {
		return d13;
	}

	public void setD13(double d13) {
		this.d13 = d13;
	}

	public double getD14() {
		return d14;
	}

	public void setD14(double d14) {
		this.d14 = d14;
	}

	public double getD15() {
		return d15;
	}

	public void setD15(double d15) {
		this.d15 = d15;
	}

	public double getD16() {
		return d16;
	}

	public void setD16(double d16) {
		this.d16 = d16;
	}

	public double getD17() {
		return d17;
	}

	public void setD17(double d17) {
		this.d17 = d17;
	}

	public double getD18() {
		return d18;
	}

	public void setD18(double d18) {
		this.d18 = d18;
	}

	public double getD19() {
		return d19;
	}

	public void setD19(double d19) {
		this.d19 = d19;
	}

	public double getD20() {
		return d20;
	}

	public void setD20(double d20) {
		this.d20 = d20;
	}

	public double getD21() {
		return d21;
	}

	public void setD21(double d21) {
		this.d21 = d21;
	}

	public double getD22() {
		return d22;
	}

	public void setD22(double d22) {
		this.d22 = d22;
	}

	public double getD23() {
		return d23;
	}

	public void setD23(double d23) {
		this.d23 = d23;
	}

	public double getD24() {
		return d24;
	}

	public void setD24(double d24) {
		this.d24 = d24;
	}

	public double getD25() {
		return d25;
	}

	public void setD25(double d25) {
		this.d25 = d25;
	}

	public double getD26() {
		return d26;
	}

	public void setD26(double d26) {
		this.d26 = d26;
	}

	public double getD27() {
		return d27;
	}

	public void setD27(double d27) {
		this.d27 = d27;
	}

	public double getD28() {
		return d28;
	}

	public void setD28(double d28) {
		this.d28 = d28;
	}

	public double getD29() {
		return d29;
	}

	public void setD29(double d29) {
		this.d29 = d29;
	}

	public double getD30() {
		return d30;
	}

	public void setD30(double d30) {
		this.d30 = d30;
	}

	public double getD31() {
		return d31;
	}

	public void setD31(double d31) {
		this.d31 = d31;
	}

	public double getD32() {
		return d32;
	}

	public void setD32(double d32) {
		this.d32 = d32;
	}

	public double getD33() {
		return d33;
	}

	public void setD33(double d33) {
		this.d33 = d33;
	}

	public double getD34() {
		return d34;
	}

	public void setD34(double d34) {
		this.d34 = d34;
	}

	public double getD35() {
		return d35;
	}

	public void setD35(double d35) {
		this.d35 = d35;
	}

	public double getD36() {
		return d36;
	}

	public void setD36(double d36) {
		this.d36 = d36;
	}

	public double getD37() {
		return d37;
	}

	public void setD37(double d37) {
		this.d37 = d37;
	}

	public double getD38() {
		return d38;
	}

	public void setD38(double d38) {
		this.d38 = d38;
	}

	public double getD39() {
		return d39;
	}

	public void setD39(double d39) {
		this.d39 = d39;
	}

	public double getD40() {
		return d40;
	}

	public void setD40(double d40) {
		this.d40 = d40;
	}

	public double getD41() {
		return d41;
	}

	public void setD41(double d41) {
		this.d41 = d41;
	}

	public double getD42() {
		return d42;
	}

	public void setD42(double d42) {
		this.d42 = d42;
	}

	public double getD43() {
		return d43;
	}

	public void setD43(double d43) {
		this.d43 = d43;
	}

	public double getD44() {
		return d44;
	}

	public void setD44(double d44) {
		this.d44 = d44;
	}

	public double getD45() {
		return d45;
	}

	public void setD45(double d45) {
		this.d45 = d45;
	}

	public double getD46() {
		return d46;
	}

	public void setD46(double d46) {
		this.d46 = d46;
	}

	public double getD47() {
		return d47;
	}

	public void setD47(double d47) {
		this.d47 = d47;
	}

	public double getD48() {
		return d48;
	}

	public void setD48(double d48) {
		this.d48 = d48;
	}

	public double getD49() {
		return d49;
	}

	public void setD49(double d49) {
		this.d49 = d49;
	}

	public double getD50() {
		return d50;
	}

	public void setD50(double d50) {
		this.d50 = d50;
	}

	public double getD51() {
		return d51;
	}

	public void setD51(double d51) {
		this.d51 = d51;
	}

	public double getD52() {
		return d52;
	}

	public void setD52(double d52) {
		this.d52 = d52;
	}

	public double getD53() {
		return d53;
	}

	public void setD53(double d53) {
		this.d53 = d53;
	}

	public double getD54() {
		return d54;
	}

	public void setD54(double d54) {
		this.d54 = d54;
	}

	public double getD55() {
		return d55;
	}

	public void setD55(double d55) {
		this.d55 = d55;
	}

	public double getD56() {
		return d56;
	}

	public void setD56(double d56) {
		this.d56 = d56;
	}

	public double getD57() {
		return d57;
	}

	public void setD57(double d57) {
		this.d57 = d57;
	}

	public double getD58() {
		return d58;
	}

	public void setD58(double d58) {
		this.d58 = d58;
	}

	public double getD59() {
		return d59;
	}

	public void setD59(double d59) {
		this.d59 = d59;
	}

	public double getD60() {
		return d60;
	}

	public void setD60(double d60) {
		this.d60 = d60;
	}

	public double getD61() {
		return d61;
	}

	public void setD61(double d61) {
		this.d61 = d61;
	}

	public double getD62() {
		return d62;
	}

	public void setD62(double d62) {
		this.d62 = d62;
	}

	public double getD63() {
		return d63;
	}

	public void setD63(double d63) {
		this.d63 = d63;
	}

	public double getD64() {
		return d64;
	}

	public void setD64(double d64) {
		this.d64 = d64;
	}

	public double getD65() {
		return d65;
	}

	public void setD65(double d65) {
		this.d65 = d65;
	}

	public double getD66() {
		return d66;
	}

	public void setD66(double d66) {
		this.d66 = d66;
	}

	public double getD67() {
		return d67;
	}

	public void setD67(double d67) {
		this.d67 = d67;
	}

	public double getD68() {
		return d68;
	}

	public void setD68(double d68) {
		this.d68 = d68;
	}

	public double getD69() {
		return d69;
	}

	public void setD69(double d69) {
		this.d69 = d69;
	}

	public double getD70() {
		return d70;
	}

	public void setD70(double d70) {
		this.d70 = d70;
	}

	public double dajSpravnyKoeficient(int dobaPoistenia) {

		switch (dobaPoistenia) {
		case 1:
			return d1;

		case 2:
			return d2;

		case 3:
			return d3;

		case 4:
			return d4;

		case 5:
			return d5;

		case 6:
			return d6;

		case 7:
			return d7;

		case 8:
			return d8;

		case 9:
			return d9;

		case 10:
			return d10;

		case 11:
			return d11;

		case 12:
			return d12;

		case 13:
			return d13;

		case 14:
			return d14;

		case 15:
			return d15;

		case 16:
			return d16;

		case 17:
			return d17;

		case 18:
			return d18;

		case 19:
			return d19;

		case 20:
			return d20;

		case 21:
			return d21;

		case 22:
			return d22;

		case 23:
			return d23;

		case 24:
			return d24;

		case 25:
			return d25;

		case 26:
			return d26;

		case 27:
			return d27;

		case 28:
			return d28;

		case 29:
			return d29;

		case 30:
			return d30;

		case 31:
			return d31;

		case 32:
			return d32;

		case 33:
			return d33;

		case 34:
			return d34;

		case 35:
			return d35;

		case 36:
			return d36;

		case 37:
			return d37;

		case 38:
			return d38;

		case 39:
			return d39;

		case 40:
			return d40;

		case 41:
			return d41;

		case 42:
			return d42;

		case 43:
			return d43;

		case 44:
			return d44;

		case 45:
			return d45;

		case 46:
			return d46;

		case 47:
			return d47;

		case 48:
			return d48;

		case 49:
			return d49;

		case 50:
			return d50;

		case 51:
			return d51;

		case 52:
			return d52;

		case 53:
			return d53;

		case 54:
			return d54;

		case 55:
			return d55;

		case 56:
			return d56;

		case 57:
			return d57;

		case 58:
			return d58;

		case 59:
			return d59;

		case 60:
			return d60;

		case 61:
			return d61;

		case 62:
			return d62;

		case 63:
			return d63;

		case 64:
			return d64;

		case 65:
			return d65;

		case 66:
			return d66;

		case 67:
			return d67;

		case 68:
			return d68;

		case 69:
			return d69;

		case 70:
			return d70;

		default:
			break;
		}

		return -1;
	}

}
