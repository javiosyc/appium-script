package generator.test.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import generator.test.annotation.TestingAccount;

public class UserLoginTestRule implements TestRule {

	private Boolean hasUser;

	private String userName;
	private String pid;
	private String password;

	@Override
	public Statement apply(Statement base, Description description) {

		TestingAccount c = description.getAnnotation(TestingAccount.class);
		if (c != null) {
			userName = c.userName();
			pid = c.pid();
			password = c.password();
			hasUser = true;
		} else {
			hasUser = false;
		}
		return base;
	}

	public Boolean getHasUser() {
		return hasUser;
	}

	public void setHasUser(Boolean hasUser) {
		this.hasUser = hasUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
