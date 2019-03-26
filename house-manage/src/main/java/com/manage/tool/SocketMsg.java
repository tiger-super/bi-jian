package com.manage.tool;

import java.io.Serializable;

public class SocketMsg implements Serializable{
	private String fromName;//发送者名字
	private String fromUser;// 发送者.
	private String toUser;// 接受者.
	private String msg;// 消息
	//是否接受
	private String ifWork;
	//发送者角色
	private String roleForFrom;
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getIfWork() {
		return ifWork;
	}
	public void setIfWork(String ifWork) {
		this.ifWork = ifWork;
	}
	public String getRoleForFrom() {
		return roleForFrom;
	}
	public void setRoleForFrom(String roleForFrom) {
		this.roleForFrom = roleForFrom;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	@Override
	public String toString() {
		return "SocketMsg [fromName=" + fromName + ", fromUser=" + fromUser + ", toUser=" + toUser + ", msg=" + msg
				+ ", ifWork=" + ifWork + ", roleForFrom=" + roleForFrom + "]";
	}  
	
}
