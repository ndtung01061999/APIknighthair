package booking.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.activation.FileTypeMap;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("img")
public class ImgController {
	@GetMapping("")
public String getabc() {
		return "test";
	}

	@GetMapping("/{name}")
	public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {
		String filename = "src/main/resources/static/" + name + ".png";
		File img = new File(filename);
		return ResponseEntity.ok()
				.contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img)))
				.body(Files.readAllBytes(img.toPath()));
	}
}
