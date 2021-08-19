package kr.or.ddit.basic;

public class MemberVO {
	String memId, memPass, memName, memTel, memAddr;

	public MemberVO(String memId, String memPass, String memName, String memTel, String memAddr) {
		this.memId = memId;
		this.memPass = memPass;
		this.memName = memName;
		this.memTel = memTel;
		this.memAddr = memAddr;
	}
	public MemberVO() {
		
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemTel() {
		return memTel;
	}
	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}
	public String getMemAddr() {
		return memAddr;
	}
	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}
	
	
}