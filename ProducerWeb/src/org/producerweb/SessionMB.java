package org.producerweb;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name="sessionMB")
@SessionScoped
public class SessionMB {

	private List<SelectItem> times;

	@PostConstruct
	public void init() {

		times = new ArrayList<SelectItem>();
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j <60; j++) {
				times.add(new SelectItem("" + (i < 9 ? "0" + i : i) + ":"
						+ (j < 9 ? "0" + j : j) + ":00"));
			}
		}

	}

	public List<SelectItem> getTimes() {
		return times;
	}

	public void setTimes(List<SelectItem> times) {
		this.times = times;
	}

}
