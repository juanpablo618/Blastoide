package com.blastoide.jsf;


/**
 *
 * @author cuello.juanpablo@gmail.com
 * http://www.journaldev.com/7252/jsf-authentication-login-logout-database-example
 */
import com.blastoide.jpa.LoginDAO;
import com.blastoide.jsfcontroller.UsersController;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;
	
	private String pwd;
	private String msg;
	private String user;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	//validate login
	public String validateUsernamePassword() {
		boolean valid = LoginDAO.validate(user, pwd);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user);
                        
                         
                         if(LoginDAO.getRol().equals("administrador")){
                             return "admin";
                         }else{
                             return "usuarioComun";
                         }
                                                
			
                        
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Password o Usuario incorrecto",
							"Por favor ingrese bien su usuario y password"));
			return "login";
		}
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
}