package com.thinksys.demo.dao;

import java.io.IOException;

import com.thinksys.demo.util.Response;

public interface PDFDao {

	public Response getByteCode() throws IOException;
	
}
