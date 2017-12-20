package com.thinksys.demo.daoImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Repository;

import com.thinksys.demo.dao.PDFDao;
import com.thinksys.demo.util.Response;

@Repository
public class PDFDaoImpl  implements PDFDao{

	@Override
	public Response  getByteCode() throws IOException {

		Response response = new Response();
		Path pdfPath = Paths.get("D:\\get.pdf");
		byte[] pdf = Files.readAllBytes(pdfPath);
		if(pdf.length>0){
			
			response.setScalarResult(pdf);
			response.setStatus(true);
		}
		else{
			
			response.setStatus(false);
		}
		return response;
	}

	
	
}
