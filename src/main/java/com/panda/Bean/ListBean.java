package com.panda.Bean;

public class ListBean {
	    private int errno;
	    private String errmsg;
	    private list_DataBean data;
		public int getErrno() {
			return errno;
		}
		public void setErrno(int errno) {
			this.errno = errno;
		}
		public String getErrmsg() {
			return errmsg;
		}
		public void setErrmsg(String errmsg) {
			this.errmsg = errmsg;
		}
		public list_DataBean getData() {
			return data;
		}
		public void setData(list_DataBean data) {
			this.data = data;
		}
		@Override
		public String toString() {
			return "ListBean [errno=" + errno + ", errmsg=" + errmsg + ", data=" + data + "]";
		}
		
}
