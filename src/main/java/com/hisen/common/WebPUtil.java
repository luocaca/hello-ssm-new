package com.hisen.common;

import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class WebPUtil {

    public static void main(String... strs) {

        String in = "E:\\as3.0\\IdeaProjects\\hello-ssm-new\\libwebp-0.4.1-windows-x64\\bin\\aa.png";
        String out = "D:\\baiduyun\\bb.webp";

        System.out.println(convertToWebp(in, out));

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
        ClassLoader cl = WebPUtil.class.getClassLoader(); // get classloader
        // init cwebp path，and set privilege of 755.
        // you can replace cwebpath in your case. in this case, we used a macos-based cwebp
//        String cwebpPath = cl.getResource("libwebp/cwebp_macos").getPath();
//        String cwebpPath = cl.getResource("/").getPath() + "/libwebp-0.4.1-windows-x64/bin/dwebp.exe";
        String cwebpPath = "E:\\as3.0\\IdeaProjects\\hello-ssm-new\\libwebp-0.4.1-windows-x64\\bin\\dwebp.exe";
        // cwebp = System.getProperty("user.dir")+"/libwebp-0.4.2-windows-	x64/bin/dwebp.exe";

        try {
            String[] args = new String[]{"E:\\as3.0\\IdeaProjects\\hello-ssm-new\\libwebp-0.4.1-windows-x64\\bin\\dwebp.exe", inputFile, "-o", outputFile};

            /**
             * C:\Users\Administrator\Desktop\ffm_demo\libwebp-0.4.1-windows-x64\bin>
             * cwebp 75 a   a.png -o out.webp
             */

//            String chmodCommand = "chmod 755 " + cwebpPath;
//            Runtime.getRuntime().exec(chmodCommand).waitFor();

            StringBuilder command = new StringBuilder(cwebpPath);
            command.append(" -q " + (quality == 0 ? 75 : quality));
            command.append(" " + inputFile);
            command.append(" -o " + outputFile);

//            Runtime.getRuntime().exec(command.toString());
            Runtime.getRuntime().exec(args);

            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("An error happend when convert to webp. Img is: \" + inputFile");
            e.printStackTrace();

        }
        return result;
    }


}
