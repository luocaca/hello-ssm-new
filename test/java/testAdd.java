import com.hisen.pdf.component.chart.Line;
import com.hisen.pdf.component.chart.impl.DefaultLineChart;
import pdf.kit.ReportKit360;
import pdf.kit.TemplateBO;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import static pdf.kit.ReportKit360.getTemperatureLineList;

public class testAdd {


    public static void main(String... args) {


//        for (int i = 21; i < 40; i++) {
            printM3u8Url(14);
//        }


    }

    private static void printM3u8Url(int i) {
        StringBuffer buffer = new StringBuffer();
        String str = +i + "+/003.ts";
        String head = "#EXTINF:7.566667,\nhttp://video2.baliup.com:88/m3u8/";
        String end = ".ts";

        String start = "#EXTM3U\n" +
                "#EXT-X-VERSION:3\n" +
                "\n" +
                "#EXT-X-MEDIA-SEQUENCE:0\n" +
                "\n" +
                "#EXT-X-ALLOW-CACHE:YES\n" +
                "#EXT-X-TARGETDURATION:17\n" +
                "\n";

        String end1 = "#EXT-X-ENDLIST\n";

        //#EXTINF:8.333333,
        // http://video2.baliup.com:88/m3u8/14/004.ts
        System.out.println(start);
        buffer.append(start);
        for (int i1 = 0; i1 < 50; i1++) {
            if (i1 > 9) {
                System.out.println(head + i + "/" + "0" + i1 + end);
                buffer.append(head + i + "/" + "0" + i1 + end);
            } else {
                System.out.println(head + i + "/" + "00" + i1 + end);
                buffer.append(head + i + "/" + "00" + i1 + end);
            }

        }
        System.out.println(end1);
        buffer.append(end1);

        //  File file = new File("D:/hust/file.txt");

        String f = "C:/Users/Administrator/Desktop/demo/";
        File directory = new File("C:/Users/Administrator/Desktop/demo/test");
//        String str = "C:\\Users\\Administrator\\Desktop\\bak";
        File dirs = new File("C:/Users/Administrator/Desktop/demo/dem1/demo2/demo3/test.txt");
        File file = new File(f, i + ".m3u8");
        /**
         *  File file = new File("D:/hust/file.txt");
         File directory = new File("D:/hust/hk");
         File dir = new File("D:/hank/hu/file.txt");
         */

        if (!directory.exists()) {
            System.out.println("mkdir-->" + directory.mkdir());
//            System.out.println("" + directory.mkdirs());
        }
        if (!dirs.exists()) {
            System.out.println("mkdirs-->" + dirs.mkdirs());
        }

        if (!file.exists()) {
            try {
                System.out.println("file.exists()-->" + dirs.createNewFile());
            } catch (IOException e) {

                System.out.println("文件创建失败--------");
                e.printStackTrace();
            }
        }

        file.setWritable(true);
        byte[] bytes = buffer.toString().getBytes();

        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(file));
            printStream.print(buffer.toString());

        } catch (FileNotFoundException e) {

            System.out.println("未");
            e.printStackTrace();
        }


//        if (!file.exists()) {
//            file.mkdirs();
//        }


    }


    public void addPdf() {

        ReportKit360 kit = new ReportKit360();
        TemplateBO templateBO = new TemplateBO();//配置模板数据
        templateBO.setTemplateName("你好  ! Hel你好你好你好你好你好你好lo freemarker! Hello jFreeChart!");
        templateBO.setFreeMarkerUrl("你好http://www.zheng-hang.com/chm/freemarker2_3_24/ref_directive_if.html");
        templateBO.setITEXTUrl("你好http://developers.itextpdf.com/examples-itext5");

        templateBO.setJFreeChartUrl("http://www.yiibai.com/jfreechart/jfreechart_referenced_apis.html");
        templateBO.setImageUrl("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");


        List<String> scores = new ArrayList<String>();
        scores.add("90");
        scores.add("95");
        scores.add("98");
        templateBO.setScores(scores);
        List<Line> lineList = getTemperatureLineList();
        DefaultLineChart lineChart = new DefaultLineChart();
        String picUrl = lineChart.draw(lineList, 0);//自定义的数据画图
        templateBO.setPicUrl(picUrl);
        String path = kit.createPDF(templateBO, "hello.pdf");
        System.out.println(path);

    }


    public static void testUploadImage() {

        String url = "http://192.168.0.13:80/hello/book/image";

        String fileName = "I:/礼金表.png";

        Map<String, String> textMap = new HashMap<>();

        // 可以设置多个 input 的 name ， value
        textMap.put("name", "testname");
        textMap.put("type", "2");
        //设置file 的name ， 路劲
        Map<String, String> fileMap = new HashMap<>();
        fileMap.put("file", fileName);
        String contentType = "";//image/png

        String ret = formUpload(url, textMap, fileMap, contentType);

        System.out.println(ret);


    }


    public static String formUpload(
            String urlStr, Map<String, String> textMap,
            Map<String, String> fileMap,
            String contentType
    ) {
        String res = "";
        HttpURLConnection conn = null;

        // boundary就是request头和上传文件内容的分隔符

        String BOUNDARY = "-------------------------------123821742118716";

        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5 * 1000);
            conn.setReadTimeout(3 * 1000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type",
                    "multipart/from-data; boundary=" + BOUNDARY);

            OutputStream out = new DataOutputStream(conn.getOutputStream());


            if (fileMap != null) {
                Iterator iterator = fileMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }

                    File file = new File(inputValue);
                    String filename = file.getName();

                    // 没有传入 类型， 同时根据文件获取不到类型
                    //默认采用application / octet-stream
                    contentType = new MimetypesFileTypeMap().getContentType(file);

                    //contentType 非 空 采用 filename 匹配默认的图片类型
                    if (!"".equals(contentType)) {
                        if (filename.equals(".png")) {
                            contentType = "image/png";
                        } else if (filename.endsWith(".jpg")) {
                            contentType = "image/jpeg";
                        } else if (filename.endsWith(".gif")) {
                            contentType = "image/gif";
                        } else if (filename.endsWith("ico")) {
                            contentType = "image/image/x-icon";
                        }
                    }

                    if (contentType == null || "".equals(contentType)) {
                        contentType = "application/octet-stream";
                    }

                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("\r\n")
                            .append("--")
                            .append(BOUNDARY)
                            .append("\r\n");

//                    stringBuffer.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename
//                            + "\"\r\n");

                    stringBuffer.append("Content-Disposition: form-data; name=\"" + inputName + "\" ; filename =\"" + filename + "\"\r\n");

                    stringBuffer.append("Content-Type:" + contentType + "\r\n\r\n");
                    out.write(stringBuffer.toString().getBytes());
                    DataInputStream in = new DataInputStream(new FileInputStream(file));

                    int bytes = 0;
                    byte[] bufferOut = new byte[1024];
                    while ((bytes = in.read(bufferOut)) != -1) {
                        out.write(bufferOut, 0, bytes);
                    }

                    in.close();
                }

                byte[] endData = ("\r\n--" + BOUNDARY).getBytes();
                out.write(endData);
                out.flush();
                out.close();

                // 读取返回数据
                StringBuffer strBuf = new StringBuffer();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String line = null;
                while ((line = reader.readLine()) != null) {
                    strBuf.append(line).append("\n");
                }

                res = strBuf.toString();
                reader = null;


            }


        } catch (Exception e) {
            System.out.println("发送POST请求出错。" + urlStr);
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }

        return res;

    }


}