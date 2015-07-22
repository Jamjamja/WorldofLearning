package org.worldoflearning;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@Autowired
	private HttpServletRequest httpServletRequest;

	@Autowired
	private ServletContext servletContext;

	@RequestMapping(value = "/dateiupload", method = RequestMethod.GET)
	public String dateiupload() {
		return "benutzer/dateiupload";
	}

	
	@RequestMapping(value = "dateiupload/upload", method = RequestMethod.POST)
    public String handleUpload(@RequestParam(value = "meineDatei", required = false) MultipartFile multipartFile,
            HttpServletResponse httpServletResponse, Model model) {

        String orgName = multipartFile.getOriginalFilename();

        if (multipartFile.isEmpty()){
            model.addAttribute("type" , "danger");
            model.addAttribute("message" , "Du hast keine Datei ausgewählt zum hochladen");
            return "benutzer/dateiupload";
        }
        else {
        String filePath = servletContext.getRealPath("/ressources/dateiupload/");
        try {
            multipartFile.transferTo(new File(filePath + "/" + orgName));
        } catch (IllegalStateException e) {
            e.printStackTrace();
            model.addAttribute("type" , "danger");
            model.addAttribute("message" , "File failed:" + orgName);
            return "benutzer/dateiupload";
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("type" , "danger");
            model.addAttribute("message" , "File failed:" + orgName);
            return "benutzer/dateiupload";
            
        }
        model.addAttribute("type" , "success");
        model.addAttribute("message" , "File uploaded:" + orgName);
        return "benutzer/dateiupload";
        }
    }
	
//	@RequestMapping(value = "dateiupload/upload", method = RequestMethod.POST)
//	public String handleFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile[] meineDatei, String saveDirectory, Model model) throws Exception {
//		saveDirectory = servletContext.getRealPath("/ressources/dateiupload/");
//		System.out.println("description: ");
//
//		if (meineDatei != null && meineDatei.length > 0) {
//			for (CommonsMultipartFile aFile : meineDatei) {
//
//				System.out.println("Saving file: "
//						+ aFile.getOriginalFilename());
//				System.out.println(saveDirectory);
//				if (!aFile.getOriginalFilename().equals("")) {
//					aFile.transferTo(new File(saveDirectory
//							+ aFile.getOriginalFilename()));
//				}
//			}
//		}
//
//		// returns to the view "Result"
//		model.addAttribute("success", "");
//		return "benutzer/dateiupload";
//	}

	@RequestMapping(value = "benutzer/dateiupload/erfolg", method = RequestMethod.GET)
	public String impressum(@RequestParam("erfolg") boolean erfolg) {
		return "benutzer/dateiupload";
	}

}
