import com.mingrn.mybatis.generator.util.CodeUtil;

public class GenerateMain {

	private static final String JDBC_URL = "jdbc:mysql://localhost/yilutong";
	private static final String JDBC_USERNAME = "root";
	private static final String JDBC_PASSWORD = "admin";
	private static final String AUTHOR = "zhang.shilin";
	private static final String PROJECT_PATH = "C:\\Users\\MinGR\\Desktop\\New folder";
	private static final String PROJECT_PACKAGE = "com";

	public static void main(String[] args) {

		String[][] tableNames = {
				{"wechat_official_user_timer", "", "微信公众号订阅用户定时表", "Id", "Long"}
		};

		CodeUtil.create(tableNames, AUTHOR, JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD, PROJECT_PATH, PROJECT_PACKAGE);
	}
}