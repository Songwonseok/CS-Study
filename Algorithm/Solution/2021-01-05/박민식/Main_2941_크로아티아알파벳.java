package algo_study;

import java.io.*;
import java.util.*;

public class Main_2941_크로아티아알파벳 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String alpa = br.readLine();
		int len = alpa.length();
		int alpaCount = 0;

		for (int idx = 0; idx < len; idx++) {
			char tmp = alpa.charAt(idx);
			if (tmp == 'c') {
				if (idx < len - 1) {
					if (alpa.charAt(idx + 1) == '=' || alpa.charAt(idx + 1) == '-') {
						idx += 1;
					}
				}
			} else if (tmp == 'd') {
				if (idx < len - 1) {
					if (alpa.charAt(idx + 1) == 'z') {
						if (idx < len - 2 && alpa.charAt(idx + 2) == '=') {
							idx += 2;
						}
					} else if (alpa.charAt(idx + 1) == '-') {
						idx += 1;
					}
				}
			} else if (tmp == 'l') {
				if (idx < len - 1) {
					if (alpa.charAt(idx + 1) == 'j') {
						idx += 1;
					}
				}
			} else if (tmp == 'n') {
				if (idx < len - 1) {
					if (alpa.charAt(idx + 1) == 'j') {
						idx += 1;
					}
				}
			} else if (tmp == 's') {
				if (idx < len - 1) {
					if (alpa.charAt(idx + 1) == '=') {
						idx += 1;
					}
				}
			} else if (tmp == 'z') {
				if (idx < len - 1) {
					if (alpa.charAt(idx + 1) == '=') {
						idx += 1;
					}
				}
			}
			alpaCount++;
		}

		System.out.println(alpaCount);
	}

}
