package com.example.TokoKu.utility;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.UUID;

public class Helper {



    public static void setUpsertViewModel(Object dto, String type,String menu, Model model){
        model.addAttribute("dto",dto);
        model.addAttribute("type",type+" "+menu);
    }
    public static void setRegisterViewModel(Object dto, String title, Model model){
        model.addAttribute("dto",dto);
        model.addAttribute("title","Create New "+title);
    }



    public static String uploadPhoto(String target,String fileName, MultipartFile multipartFile)throws IOException {
        var uploadDirectory="src/main/resources/static/resources/image/"+target;
        var uploadPath= Paths.get(uploadDirectory);
        if(fileName == null || fileName.equals("")){
            var uuid= UUID.randomUUID();
            fileName=String.format("%s.jpg",uuid.toString());
        }
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        try(InputStream inputStream=multipartFile.getInputStream()){
            Path filePath=uploadPath.resolve(fileName);
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e){

        }
        return fileName;
    }



}
