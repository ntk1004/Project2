package com.javaweb.modol;

import java.util.ArrayList;
import java.util.List;

public class ErrorResonseDTO  {
private String err;
private List<String > li = new ArrayList<>();
public String getErr() {
	return err;
}
public void setErr(String err) {
	this.err = err;
}
public List<String> getLi() {
	return li;
}
public void setLi(List<String> li) {
	this.li = li;
}

}
