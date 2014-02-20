package com.he.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
/**
 * ���ڼ���session���Ե����
 * 
 * @author �ν���    QQ 277803242
 *
 */
public class LoginListener implements HttpSessionAttributeListener {
	// �Ѿ���¼�û�session
	public static Map<String, HttpSession> loginedUser = new HashMap<String, HttpSession>();

	public void attributeAdded(HttpSessionBindingEvent eventAdd) {
		// TODO ����session���Ե����
		String attrName = eventAdd.getName();
		// ������Ϊ����userName�����
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
