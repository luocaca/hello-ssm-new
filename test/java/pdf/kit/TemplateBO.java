package pdf.kit;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fgm on 2017/4/17.
 */
@Data
public class TemplateBO {

    private String templateName;

    private String freeMarkerUrl;

    private String ITEXTUrl;

    private String JFreeChartUrl;

    private List<String> scores;

    private List<MyData> dataList = Arrays.asList(new MyData(), new MyData(), new MyData(), new MyData(), new MyData(), new MyData(), new MyData());

    private String imageUrl;

    private String picUrl;


    private String fild1 = "1";
    private String fild2 = "花木书";
    private String fild3 = "大傻/17074990702";
    private String fild4 = "很抠的";
    private String fild5 = "背景上海";
    private String fild6 = "米径3 ; 高度4";
    private String fild7 = "2017-12-26 16:59:44\t33";
    private String fild8 = "444";
    private String fild9 = "566";
    private String fild10 = "未采用";

    public String getFild1() {
        return fild1;
    }

    public void setFild1(String fild1) {
        this.fild1 = fild1;
    }

    public String getFild2() {
        return fild2;
    }

    public void setFild2(String fild2) {
        this.fild2 = fild2;
    }

    public String getFild3() {
        return fild3;
    }

    public void setFild3(String fild3) {
        this.fild3 = fild3;
    }

    public String getFild4() {
        return fild4;
    }

    public void setFild4(String fild4) {
        this.fild4 = fild4;
    }

    public String getFild5() {
        return fild5;
    }

    public void setFild5(String fild5) {
        this.fild5 = fild5;
    }

    public String getFild6() {
        return fild6;
    }

    public void setFild6(String fild6) {
        this.fild6 = fild6;
    }

    public String getFild7() {
        return fild7;
    }

    public void setFild7(String fild7) {
        this.fild7 = fild7;
    }

    public String getFild8() {
        return fild8;
    }

    public void setFild8(String fild8) {
        this.fild8 = fild8;
    }

    public String getFild9() {
        return fild9;
    }

    public void setFild9(String fild9) {
        this.fild9 = fild9;
    }


    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getFreeMarkerUrl() {
        return freeMarkerUrl;
    }

    public void setFreeMarkerUrl(String freeMarkerUrl) {
        this.freeMarkerUrl = freeMarkerUrl;
    }

    public String getITEXTUrl() {
        return ITEXTUrl;
    }

    public void setITEXTUrl(String ITEXTUrl) {
        this.ITEXTUrl = ITEXTUrl;
    }

    public String getJFreeChartUrl() {
        return JFreeChartUrl;
    }

    public void setJFreeChartUrl(String JFreeChartUrl) {
        this.JFreeChartUrl = JFreeChartUrl;
    }

    public List<String> getScores() {
        return scores;
    }

    public void setScores(List<String> scores) {
        this.scores = scores;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getFild10() {
        return fild10;
    }

    public void setFild10(String fild10) {
        this.fild10 = fild10;
    }
}