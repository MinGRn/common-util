package com.mingrn.common;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int count = 0;
		boolean isTrue = true;
		while (isTrue){
			System.out.println(Math.random());
			count++;
			if ((++count) > 100){
				isTrue = false;
			}
		}
	}
}
