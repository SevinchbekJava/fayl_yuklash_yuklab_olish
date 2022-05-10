//package com.fayl_yuklash_yuklab_olish.controller;
//
//import com.fayl_yuklash_yuklab_olish.model.Fayl;
//import com.fayl_yuklash_yuklab_olish.model.FaylSource;
//import com.fayl_yuklash_yuklab_olish.repository.FaylRepository;
//import com.fayl_yuklash_yuklab_olish.repository.FaylSourceRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import java.io.IOException;
//import java.util.Iterator;
//
//@RestController
//@RequestMapping(value = "/fayl")
//public class FaylController {
//    @Autowired
//    FaylRepository faylRepository;
//    @Autowired
//    FaylSourceRepository faylSourceRepository;
//    @PostMapping("/yuklash")
//    public String upload_fayl(MultipartHttpServletRequest msr) throws IOException {
//        Iterator<String> faylNomlari=msr.getFileNames();
//        MultipartFile multifayl=msr.getFile(faylNomlari.next());
//        if(multifayl!=null){
//            String faylNomi=multifayl.getOriginalFilename();
//            long size= multifayl.getSize();
//            String contentType= multifayl.getContentType();
//            byte[] faylbyts= multifayl.getBytes();
//            Fayl fayl=new Fayl();
//            fayl.setOrginalFaylNomi(faylNomi);
//            fayl.setFaylSize(size);
//            fayl.setContentType(contentType);
//            Fayl fayl1=faylRepository.save(fayl);
//
//            FaylSource faylSource=new FaylSource();
//            faylSource.setSourceFayl(faylbyts);
//            faylSource.setFayl(fayl1);
//            faylSourceRepository.save(faylSource);
//            return "Fayl yuklandi ID: "+fayl1.getFaylId();
//        }
//        return "Fayl yuklanmadi";
//    }
//}

package com.fayl_yuklash_yuklab_olish.controller;
import com.fayl_yuklash_yuklab_olish.model.Fayl;
import com.fayl_yuklash_yuklab_olish.model.FaylSource;
import com.fayl_yuklash_yuklab_olish.repository.FaylRepository;
import com.fayl_yuklash_yuklab_olish.repository.FaylSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Iterator;

@RestController
@RequestMapping("/fayl")
public class FaylController {

    @Autowired
    FaylRepository faylBeen;

    @Autowired
    FaylSourceRepository sourceBeen;

    @PostMapping("/yuklash")
    public String install(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> malumot=request.getFileNames();
        MultipartFile fayl=request.getFile(malumot.next());
        if(fayl!=null){
            String orginalNomi=fayl.getOriginalFilename();
            long hajmi=fayl.getSize();
            String contentType=fayl.getContentType();
            byte[] source=fayl.getBytes();
            Fayl fayl1=new Fayl();
            fayl1.setOrginalFaylNomi(orginalNomi);
            fayl1.setContentType(contentType);
            fayl1.setFaylSize(hajmi);
            Fayl fayl2=faylBeen.save(fayl1);
            FaylSource source1=new FaylSource();
            source1.setSourceFayl(source);
            source1.setFayl(fayl2);
            sourceBeen.save(source1);
            return "Joylandi ID"+fayl2.getFaylId();
        }
        return "Joylanmadi";
    }
}
