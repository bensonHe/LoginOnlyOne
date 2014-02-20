package com.he.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
/**
 * 用于监听session属性的添加
 * 
 * @author 何锦彬    QQ 277803242
 *
 */
public class LoginListener implements HttpSessionAttributeListener {
	// 已经登录用户session
	public static Map<String, HttpSession> loginedUser = new HashMap<String, HttpSession>();

	public void attributeAdded(HttpSessionBindingEvent eventAdd) {
		// TODO 监听session属性的添加
		String attrName = eventAdd.getName();
		// 监听到为属性userName的添加
		if ("userName".equals(attrName)) {
			String value = (String) eventAdd.getValue();
			HttpSession session = loginedUser.get(value);
			if (session != null) {
				session.removeAttribute(attrName);
			}
			loginedUser.put(value, eventAdd.getSession());
		}

	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

}
