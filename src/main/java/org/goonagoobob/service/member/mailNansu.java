package org.goonagoobob.service.member;

public class mailNansu {
	
	public static String nanSu() {
		int a[] = new int[6];
		boolean chk;
		
		for(int i = 0; i < 6; i++) {
			while(true) {
				a[i] = (int)(Math.random() * 6);
				chk = false;
				
				for(int j = 0; j < i; j++) {
					if(a[j] == a[i]) {
						chk = true;
						break;
					}
					
					if(a[j] != a[i]) {
						chk = false;
					}
				}
				
				if(!chk) break;
			}
		}
	
		String result = "";
		for(int i = 0; i < 6; i++) {
			System.out.println(a[i]);
			result += String.valueOf(a[i]);
		}
		return result;
	}
	
	
}
