package com.ensta.librarymanager.modele;

public enum Abonnement {
	BASIC(0),
	PREMIUM(1), 
	VIP(2);
	
	private int value;
	
	Abonnement(int i) {
		this.value=i;
	}

	public int getValue() {
		return value;
	}

	public static Abonnement fromString(String s) {
		if (s.equals("BASIC")) {
			return BASIC;
		}else if(s.equals("PREMIUM")) {
			return PREMIUM;
		}else if(s.equals("VIP")) {
			return VIP;
		}
		return null;
	}
	
	public static String toString(Abonnement a) {
		if (a.getValue()==0) {
			return "BASIC";
		}else if(a.getValue()==1) {
			return "PREMIUM";
		}else if(a.getValue()==2) {
			return "VIP";
		}
		return "NULL";
	}
}
