package com.cnp.pwsasset.util;


import org.springframework.http.MediaType;

import java.io.File;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

import static org.springframework.http.MediaType.*;

public class FileUploadUtil {

    /**
     *
     * @param uploadRootPath - 업로드 기본 경로 (ex: D:/myapp/profile/upload)
     * @return - 새로운 날짜별 경로
     *           ex) D:/myapp/profile/upload/2023/01/07
     */
    public static String makeUploadDirectory(String uploadRootPath) {
        // 오늘 년,월,일 정보 가져오기
        LocalDateTime now = LocalDateTime.now();
        int y = now.getYear();
        int m = now.getMonthValue();
        int d = now.getDayOfMonth();

        // 폴더 생성
        String[] dateInfo = {
                String.valueOf(y)
                , len2(m)
                , len2(d)
        };

        String newUploadPath = uploadRootPath;

        // File.separator : 운영체제에 맞는 디렉토리 경로구분문자를 생성
        // 리눅스 : / ,  윈도우 : \
        for (String date : dateInfo) {
            newUploadPath += File.separator + date;

            // 해당 경로대로 폴더를 생성
            File dirName = new File(newUploadPath);
            if (!dirName.exists()) dirName.mkdir();
        }

        return newUploadPath;
    }

    private static String len2(int n) {
        return new DecimalFormat("00").format(n);
    }

    // 파일명을 전달하면 확장자를 추출해서 미디어타입(image/png)을 리턴

    /**
     * @param filePath - /2023/01/07/djfskdjkfsjkf_abc.gif
     * @return image/gif
     */
    public static MediaType getMediaType(String filePath) {
        // 확장자 추출
        String ext = filePath.substring(filePath.lastIndexOf(".") + 1);

        switch (ext.toUpperCase()) {
            case "PNG":
                return IMAGE_PNG;
            case "GIF":
                return IMAGE_GIF;
            case "JPG": case "JPEG":
                return IMAGE_JPEG;
            default:
                return null;
        }
    }

}
