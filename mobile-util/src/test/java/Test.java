import com.mingrn.common.mobile.ownership.MobileCodeWS;
import com.mingrn.common.mobile.ownership.MobileCodeWSSoap;


public class Test {
	public static void main(String[] args) {
		int index = 0;
		while (true) {
			test();
			index++;
			if (index > 1000) {
				break;
			}
		}
	}

	private static void test() {
		long start = System.currentTimeMillis();
		MobileCodeWS mobileCodeWS = new MobileCodeWS();
		MobileCodeWSSoap mobileCodeWSSoap = mobileCodeWS.getMobileCodeWSSoap();
		String info = mobileCodeWSSoap.getMobileCodeInfo("1515588***", null);
		System.out.println(info);
		System.out.println(System.currentTimeMillis() - start);
	}
}