package com.mingrn.common.arithmetic.redpackage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 抢红包,二倍均值法
 * </p>
 * <a href="https://juejin.im/post/5af80310f265da0b8636585e">参考</p>
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 10/10/2018 09:48
 */
public class DivideRedPackage1 {

	/**
	 * 发红包算法,金额参数以分为单位
	 */
	private static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {
		List<Integer> amountList = new ArrayList<>();
		Integer restAmount = totalAmount;
		Integer restPeopleNum = totalPeopleNum;
		Random random = new Random();
		for (int i = 0; i < totalPeopleNum - 1; i++) {
			/*
			 *随机范围：[1，剩余人均金额的两倍),左闭右开
			 */
			int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
			restAmount -= amount;
			restPeopleNum--;
			amountList.add(amount);
		}
		amountList.add(restAmount);
		return amountList;
	}


	public static void main(String[] args) {
		List<Integer> amountList = divideRedPackage(10000, 10);
		for (Integer amount : amountList) {
			System.out.println("抢到金额：" + new BigDecimal(amount).divide(new BigDecimal(100)));
		}
	}
}