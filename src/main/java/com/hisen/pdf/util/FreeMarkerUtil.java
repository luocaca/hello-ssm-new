package com.hisen.pdf.util;

import com.hisen.pdf.component.PDFKit;
import com.hisen.pdf.exception.FreeMarkerException;
import com.hisen.pdf.exception.PDFException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.StringWriter;

public class FreeMarkerUtil {

    /**
     * @description 获取模板
     */
    public static String getContent(String fileName,Object data){

        String templatePath=getPDFTemplatePath(fileName);
        String templateFileName=getTemplateName(templatePath);
//        String templateFileName = "hello.ftl";
        String templateFilePath=getTemplatePath(templatePath);
        if(StringUtils.isEmpty(templatePath)){
            throw new FreeMarkerException("templatePath can not be empty!");
        }
        try{
            Configuration config = new Configuration(Configuration.VERSION_2_3_25);
            config.setDefaultEncoding("UTF-8");
            config.setDirectoryForTemplateLoading(new File(templateFilePath));
            config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            config.setLogTemplateExceptions(false);
            templateFileName = "hello.ftl";
            Template template = config.getTemplate(templateFileName);
            StringWriter writer = new StringWriter();
            template.process(data, writer);
            writer.flush();
            String html = writer.toString();
            return html;
        }catch (Exception ex){
            throw new FreeMarkerException("FreeMarkerUtil process fail",ex);
        }
    }

    private static String getTemplatePath(String templatePath) {
        if(StringUtils.isEmpty(templatePath)){
            return "";
        }
        String path=templatePath.substring(0,templatePath.lastIndexOf("\\"));
//        String    path = "C:\\Users\\Administrator\\Desktopstudy_java\\hello-ssm\\Users\\Administrator\\IdeaProjects\\hello-ssm\\target\\test-classes\\templates" ;
        return path;
    }

    private static String getTemplateName(String templatePath) {
        if(StringUtils.isEmpty(templatePath)){
            return "";
        }
        //C:\Users\Administrator\Desktop\study_java\hello-ssm\Users\Administrator\IdeaProjects\hello-ssm\target\test-classes\templates\hello.ftl
        String fileName=templatePath.substring(templatePath.lastIndexOf("\\")+1);
        return fileName;
    }

    /**
     * @description 获取PDF的模板路径,
     * 默认按照PDF文件名匹对应模板
     * @param fileName PDF文件名    (hello.pdf)
     * @return         匹配到的模板名
     */
    public static String getPDFTemplatePath(String fileName){
        String  classpath=PDFKit.class.getClassLoader().getResource("").getPath();
        String templatePath=classpath+"/templates";
        File file=new File(templatePath);
        if(!file.isDirectory()){
            throw new PDFException("PDF模板文件不存在,请检查templates文件夹!");
        }
        String pdfFileName=fileName.substring(0,fileName.lastIndexOf("."));
        File defaultTemplate=null;
        File matchTemplate=null;
        for(File f:file.listFiles()){
            if(!f.isFile()){
                continue;
            }
            String templateName=f.getName();
            if(templateName.lastIndexOf(".ftl")==-1){
                continue;
            }
            if(defaultTemplate==null){
                defaultTemplate=f;
            }
            if(StringUtils.isEmpty(fileName)&&defaultTemplate!=null){
                break;
            }
            templateName=templateName.substring(0,templateName.lastIndexOf("."));
            if(templateName.toLowerCase().equals(pdfFileName.toLowerCase())){
                matchTemplate=f;
                break;
            }
        }
        if(matchTemplate!=null){
            return matchTemplate.getAbsolutePath();
        }
        if(defaultTemplate!=null){
            return defaultTemplate.getAbsolutePath();
        }

        return null;

    }

}
