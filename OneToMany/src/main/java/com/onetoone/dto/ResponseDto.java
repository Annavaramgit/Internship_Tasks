package com.onetoone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

	

	private String pname;
	private double pprice;
	private int cid;
	private String cname;
	
	   public ResponseDto(int cid, String cname, String pname, double pprice) {
	        this.cid = cid;
	        this.cname = cname;
	        this.pname = pname;
	        this.pprice = pprice;
	    }
}
