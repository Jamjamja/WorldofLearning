package org.worldoflearning;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class UploadController {

	@Autowired
	private HttpServletRequest httpServletRequest;

	private ServletContext servletContext;

	@RequestMapping(value = "/dateiupload", method = RequestMethod.GET)
	public String dateiupload() {
		return "benutzer/dateiupload";
	}

	private String saveDirectory = "C:/Test/Upload/";

	@RequestMapping(value = "dateiupload/upload", method = RequestMethod.POST)
	public String handleFileUpload(HttpServletRequest request,
			@RequestParam CommonsMultipartFile[] meineDatei) throws Exception {

		System.out.println("description: ");

		if (meineDatei != null && meineDatei.length > 0) {
			for (CommonsMultipartFile aFile : meineDatei) {

				System.out.println("Saving file: "
						+ aFile.getOriginalFilename());

				if (!aFile.getOriginalFilename().equals("")) {
					aFile.transferTo(new File(saveDirectory
							+ aFile.getOriginalFilename()));
				}
			}
		}

		// returns to the view "Result"
		return "benutzer/dateiupload/erfolg";
	}
	
	
	@RequestMapping(value = "benutzer/dateiupload/erfolg", method = RequestMethod.GET)
	public String impressum(@RequestParam("erfolg") boolean erfolg) {
		return "benutzer/dateiupload";
	}

}
