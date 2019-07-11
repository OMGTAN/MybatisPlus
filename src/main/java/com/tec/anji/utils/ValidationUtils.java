package com.tec.anji.utils;

import java.util.Collection;

import org.springframework.util.CollectionUtils;


public class ValidationUtils {
	
	/**
	 * 集合为空时直接返回
	 * @param c
	 */
	public static void returnIfEmputy(Collection<?> c) {
		if(CollectionUtils.isEmpty(c)) {
			return;
		}
	}
}
