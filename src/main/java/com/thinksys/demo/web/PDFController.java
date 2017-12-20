package com.thinksys.demo.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thinksys.demo.service.PDFService;
import com.thinksys.demo.serviceImpl.PDFServiceImpl;
import com.thinksys.demo.util.Response;

@RestController
@CrossOrigin(origins={"*"})
@RequestMapping({"pdfapi"})
public class PDFController {




	PDFService pdfServiceImpl = new PDFServiceImpl();

	@CrossOrigin(origins={"*"})
	@RequestMapping(value="/getpdf1	", method=RequestMethod.GET)
	public Response getPDF1() throws IOException {

		String filename = "get.pdf";
		Response res=this.pdfServiceImpl.getPdfBytesCode(filename);
		return res;
	}

	@CrossOrigin(origins={"*"})
	@RequestMapping(value="/getpdf", method=RequestMethod.GET , produces = "application/pdf")
	public ResponseEntity<byte[]> getPDF() throws IOException {


		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = "get.pdf";
		headers.add("content-disposition", "inline");
		//	    headers.setContentDispositionFormData(filename, filename);
		//	    headers.setContentDispositionFormData("inline", filename);
		//	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		Path pdfPath = Paths.get("D:\\get.pdf");
		byte[] pdf = Files.readAllBytes(pdfPath);
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(pdf, headers, HttpStatus.OK);
		System.out.println(response);
		return response;
	}
	
	
	
	
public void gethtml(){
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//	@RequestMapping(value = "/form/pdf", produces = "application/pdf")
	//	public ResponseEntity<byte[]> showPdf(DomainModel domain, ModelMap model) {
	//	    createPdf(domain, model);
	//
	//	    Path path = Paths.get(PATH_FILE);
	//	    byte[] pdfContents = null;
	//	    try {
	//	        pdfContents = Files.readAllBytes(path);
	//	    } catch (IOException e) {
	//	        e.printStackTrace();
	//	    }
	//
	//	    HttpHeaders headers = new HttpHeaders();
	//	    headers.setContentType(MediaType.parseMediaType("application/pdf"));
	//	    String filename = NAME_PDF;
	//	    headers.setContentDispositionFormData(filename, filename);
	//	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	//	    ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(
	//	            pdfContents, headers, HttpStatus.OK);
	//	    return response;
	//	}

	//	@RequestMapping(value = "/getPDF", method = RequestMethod.GET)
	//	@Produces("application/pdf")
	//	public ResponseBuilder generateReport() throws Exception {
	//
	//
	//		File file = new File("D:\\get.pdf");
	//		FileInputStream fileInputStream = new FileInputStream(file);
	//		ResponseBuilder responseBuilder = Response.ok((Object) fileInputStream);
	//		responseBuilder.type("application/pdf");
	//		responseBuilder.header("Content-Disposition",  "attachment; filename=get.pdf");
	//		return responseBuilder;
	//
	//	}
	//
	//	@RequestMapping(value="/pdfmethod", produces="application/pdf")
	//	public void pdfMethod(HttpServletRequest request, HttpServletResponse response){
	//		response.setContentType("application/pdf");
	//		InputStream inputStream = null;
	//		OutputStream outputStream = null;
	//
	//		try{
	//			File file = new File("D:\\get.pdf");
	//			inputStream = new FileInputStream(file);
	//			outputStream = response.getOutputStream();
	//			// IOUtils.copy(inputStream, outputStream);
	//		}catch(IOException ioException){
	//			//Do something or propagate up..
	//		}finally{
	//			IOUtils.closeQuietly(inputStream);
	//			IOUtils.closeQuietly(outputStream);
	//		}
	//	}
	//
	//
	//	@RequestMapping(value = "/getPDF1", method = RequestMethod.GET)
	//	public void generateReport(HttpServletResponse response) throws Exception {
	//
	//		Path pdfPath = Paths.get("D:\\get.pdf");
	//		byte[] pdf = Files.readAllBytes(pdfPath);
	//
	//		response.setContentType("application/pdf");
	//		response.setHeader("Content-disposition", "attachment; filename=" + "get.pdf");
	//		response.setContentLength(pdf.length);
	//		response.getOutputStream().write(pdf);
	//		response.getOutputStream().flush();
	//		
	//	}
	//
	//
	//	@RequestMapping(value = "/showHelp.do", method = RequestMethod.GET)
	//	public ResponseEntity<byte[]> showHelp() throws Exception {         
	//
	//		Path pdfPath = Paths.get("D:\\get.pdf");
	//		byte[] pdf = Files.readAllBytes(pdfPath);
	//		HttpHeaders headers = new HttpHeaders();
	//		headers.setContentType(MediaType.parseMediaType("application/pdf"));
	//		String filename = "output.pdf";
	//		headers.add("content-disposition", "inline;filename=" + "getpdf");
	//		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	//		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(pdf, headers, HttpStatus.OK);
	//		return response;
	//	}

}
