package com.hisen.common;

import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class ImageFormatConverter {
    // private static Logger log = Logger.getLogger(ImageFormatConverter.class);


    public static void main(String[] args) {

        convertToWebp("imgs/aa.png");
//        String inputFile = "/";
//        String outputFile = "/Users/wangjieyu/Downloads/libwebp-0.5.0-rc1-mac-10.9/output/logo.webp";
//        if (executeCWebp(inputFile, outputFile, 90)) {
//            System.out.println("convert ok~");
//        } else {
//            System.out.println("sth wrong happened");
//        }
    }


    public static boolean convertToWebp(String inputFile) {
        String outputFile = inputFile.split("\\.")[0] + ".webp";
        return convertToWebp(inputFile, outputFile, 75);
    }


    public static boolean convertToWebp(String inputFile, String outputFile) {
        return convertToWebp(inputFile, outputFile, 75);
    }

    public static boolean convertToWebp(String inputFile, String outputFile, Integer quality) {
        if (!new File(inputFile).exists()) {
            return false;
        }

        String outputPath = FilenameUtils.getFullPath(outputFile);
        if (!new File(outputPath).exists()) {
            new File(outputPath).mkdirs();
        }

        return executeCWebp(inputFile, outputFile, quality);
    }

    /**
     * execute cwebp command：cwebp [options] input_file -o output_file.webp
     */
    private static boolean executeCWebp(String inputFile, String outputFile, Integer quality) {
        boolean result = false;
        ClassLoader cl = ImageFormatConverter.class.getClassLoader(); // get classloader
        // init cwebp path，and set privilege of 755.
        // you can replace cwebpath in your case. in this case, we used a macos-based cwebp
        String cwebpPath = cl.getResource("libwebp/cwebp_macos").getPath();
        try {
            String chmodCommand = "chmod 755 " + cwebpPath;
            Runtime.getRuntime().exec(chmodCommand).waitFor();

            StringBuilder command = new StringBuilder(cwebpPath);
            command.append(" -q " + (quality == 0 ? 75 : quality));
            command.append(" " + inputFile);
            command.append(" -o " + outputFile);

            Runtime.getRuntime().exec(command.toString());

            result = true;
        } catch (Exception e) {
            // log.error("An error happend when convert to webp. Img is: " + inputFile, e);
        }
        return result;
    }


}