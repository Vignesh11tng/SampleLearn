package org.logoff;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinHomePage extends BaseClass{
	public AdactinHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement txtUsername;
	
	@FindBy(id="password")
	private WebElement txtPassword;
	
	@FindBy(id="login")
	private WebElement btnLogin;
	
	@FindBy(xpath="//b[contains(text(),'Invalid')]")
	private WebElement errmsg;

	public WebElement getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(WebElement errmsg) {
		this.errmsg = errmsg;
	}

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public void setTxtUsername(WebElement txtUsername) {
		this.txtUsername = txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(WebElement txtPassword) {
		this.txtPassword = txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(WebElement btnLogin) {
		this.btnLogin = btnLogin;
	}
	

}
