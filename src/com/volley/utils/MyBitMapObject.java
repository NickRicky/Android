package com.volley.utils;

import java.io.Serializable;

import android.graphics.Bitmap;

public class MyBitMapObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Bitmap bitMap;
	public MyBitMapObject(Bitmap bitMap){
		this.bitMap = bitMap;
	}
	
	public Bitmap getBitMap(){
		return bitMap;
	}
}
