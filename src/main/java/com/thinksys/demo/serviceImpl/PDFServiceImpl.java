package com.thinksys.demo.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.thinksys.demo.dao.PDFDao;
import com.thinksys.demo.daoImpl.PDFDaoImpl;
import com.thinksys.demo.service.PDFService;
import com.thinksys.demo.util.Response;
import com.thinksys.demo.web.HomeController;

@Service
public class PDFServiceImpl implements PDFService {

	private static final Logger logger = LoggerFactory.getLogger(PDFServiceImpl.class);

	PDFDao pdfDaoImpl = new PDFDaoImpl();


	@Override
	public Response getPdfBytesCode(String filename) {
		
		Response response = null;
		try {
			filename="D:\\get.pdf";
			
			response=this.pdfDaoImpl.getByteCode();
			response.setMessage("Success");
		} catch (IOException e) {

			response.setErrorMessage(e.getMessage());
			response.setMessage("error");
			logger.info("PDFServiceImpl :error in getPdfBytesCode ",e);
		}
		return response;
	}





}
