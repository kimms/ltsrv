package com.patin.srv.api.common.response;

import java.util.ArrayList;
import java.util.List;

/**
 * ResponseBodyVO.java
 * 
 * @author KIM, MinSeob
 */
public class ResponseBodyVO<T> {

	private int docCnt;
	private List<T> docs = new ArrayList<T>();

	public void setDoc(T doc) {
		this.docs.add(doc);
	}
	
	public List<T> getDocs() {
		return docs;
	}

	public void setDocs(List<T> docs) {
		this.docs = docs;
	}

	public int getDocCnt() {
		return docCnt;
	}

	public void setDocCnt(int docCnt) {
		this.docCnt = docCnt;
	}
}
