package com.maike.common.entity;

import java.io.Serializable;

/**
 * @ClassName: ComKey
 * @Description: 通用 key-value
 * @author:
 * @date: 2018年10月8日 上午11:35:43
 */
public class ComKey implements Serializable{

	private static final long serialVersionUID = 5799445058129451301L;
	private Object key;
	private Object value;

	public ComKey() {
	}

	public ComKey(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}

	/**
	 * @return the key
	 */
	public Object getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(Object key) {
		this.key = key;
	}
	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

}
