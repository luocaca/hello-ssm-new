package pdf.kit;


import com.hisen.pdf.component.PDFHeaderFooter;
import com.hisen.pdf.component.PDFKit;
import com.hisen.pdf.component.chart.Line;
import com.hisen.pdf.component.chart.impl.DefaultLineChart;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;


import java.util.ArrayList;
import java.util.List;


import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fgm on 2017/4/17.
 * 360报告
 *
 */
@Slf4j
public class ReportKit360 {

    private static Logger log= LoggerFactory.getLogger(ReportKit360.class);

    public static List<Line> getTemperatureLineList() {
        List<Line> list= Lists.newArrayList();
        for(int i=1;i<=7;i++){
            Line line=new Line();
            float random=Math.round(Math.random()*10);
            line.setXValue("星期"+i);
            line.setYValue(20+random);
            line.setGroupName("下周");
            list.add(line);
        }
        for(int i=1;i<=7;i++){
            Line line=new Line();
            float random=Math.round(Math.random()*10);
            line.setXValue("星期"+i);
            line.setYValue(20+random);
            line.setGroupName("这周");
            list.add(line);
        }
        return list;
    }

    public  String createPDF(Object data, String fileName){
        //pdf保存路径
        try {
            //设置自定义PDF页眉页脚工具类
            PDFHeaderFooter headerFooter=new PDFHeaderFooter();
            PDFKit kit=new PDFKit();
            kit.setHeaderFooterBuilder(headerFooter);
            //设置输出路径

            //request.getServletContext().getRealPath("/"), "upload"
            kit.setSaveFilePath("D:\\pdf\\hello.pdf");
            String saveFilePath=kit.exportToFile(fileName,data);
            return  saveFilePath;
        } catch (Exception e) {
            log.error("PDF生成失败{}", ExceptionUtils.getFullStackTrace(e));
            return null;
        }

    }

    public static void main(String[] args) {

        ReportKit360 kit=new ReportKit360();
        TemplateBO templateBO=new TemplateBO();
        templateBO.setTemplateName("Hello iText! Hello freemarker! Hello jFreeChart!");
        templateBO.setFreeMarkerUrl("http://www.zheng-hang.com/chm/freemarker2_3_24/ref_directive_if.html");
        templateBO.setITEXTUrl("http://developers.itextpdf.com/examples-itext5");
        templateBO.setJFreeChartUrl("http://www.yiibai.com/jfreechart/jfreechart_referenced_apis.html");
        templateBO.setImageUrl("http://mss.vip.sankuai.com/v1/mss_74e5b6ab17f44f799a524fa86b6faebf/360report/logo_1.png");
        List<String> scores=new ArrayList<String>();
        scores.add("90");
        scores.add("95");
        scores.add("98");
        templateBO.setScores(scores);
        List<Line> lineList=getTemperatureLineList();
        DefaultLineChart lineChart=new DefaultLineChart();
        lineChart.setHeight(500);
        lineChart.setWidth(300);
        String picUrl=lineChart.draw(lineList,0);
        templateBO.setPicUrl(picUrl);
        String path= kit.createPDF(templateBO,"hello.pdf");
        System.out.println(path);



    }






}