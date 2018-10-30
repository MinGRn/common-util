package com.mingrn.common.arithmetic.redpackage;

import java.util.Random;

/**
 * 抢红包
 * </p>
 * <a href="https://blog.csdn.net/lb_383691051/article/details/79379384">参考</p>
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 10/10/2018 12:17
 */
public class DivideRedPackage2 {
	public static void main(String[] args) {
		Integer count = 10;
		Boolean isHave = true;
		MoneyPackage moneyPackage = new MoneyPackage((double) 100, 10);
		while (isHave) {
			if ((--count) <= 0) {
				isHave = false;
			}
			System.out.println(divideRedPackage(moneyPackage));
		}
	}

	/**
	 * 随机获取红包
	 *
	 * @param moneyPackage 红包
	 */
	private static double divideRedPackage(MoneyPackage moneyPackage) {
		if (moneyPackage.peopleNum == 1) {
			moneyPackage.peopleNum--;
			return (double) Math.round(moneyPackage.amount * 100) / 100;
		}
		double min = 0.01, max = moneyPackage.amount / moneyPackage.peopleNum * 2;
		double money = new Random().nextDouble() * max;
		money = money <= min ? min : money;
		money = Math.floor(money * 100) / 100;
		moneyPackage.peopleNum--;
		moneyPackage.amount -= money;
		return money;
	}

	static class MoneyPackage {
		/**
		 * 红包总额
		 */
		Double amount;

		/**
		 * 红包数
		 */
		Integer peopleNum;

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}

		public Integer getPeopleNum() {
			return peopleNum;
		}

		public void setPeopleNum(Integer peopleNum) {
			this.peopleNum = peopleNum;
		}

		MoneyPackage(Double amount, Integer peopleNum) {
			this.amount = amount;
			this.peopleNum = peopleNum;
		}
	}
}