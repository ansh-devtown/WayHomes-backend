package com.org.dumper.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Configuration
public class HelperUtils {

    public File multipartFileToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convertedFile);
        fos.write(file.getBytes());
        fos.close();
        return convertedFile;
    }

    public String generateFileName(MultipartFile multiPart, String path, String id) {
        if(path.equals("properties")) {
            return "properties" + "/" + "prop-" + id + "/" + Objects.requireNonNull(
                    multiPart.getOriginalFilename()).replace(" ", "_");
        }
        return "users" + "/" + "user-" + id + "/" + Objects.requireNonNull(
                multiPart.getOriginalFilename()).replace(" ", "_");
    }
}
