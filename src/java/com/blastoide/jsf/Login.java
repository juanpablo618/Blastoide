package com.blastoide.jsf;


/**
 *
 * @author cuello.juanpablo@gmail.com
 * http://www.journaldev.com/7252/jsf-authentication-login-logout-database-example
 */
import com.blastoide.jpa.LoginDAO;
import java.io.IOException;
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
        private String rol;

        public String getRol() {
            return rol;
        }

        public void setRol(String rol) {
            this.rol = rol;
        }

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
                             this.rol = "administrador";
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
        //TODO mejorar este metodo que devuelva un string con "login" el nombre del archivo que quiero redireccionar 
        public void logout() throws IOException {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
                
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().redirect("Login.xhtml");
        
        }
}