package com.hisen.web;

import com.google.gson.Gson;
import com.hisen.common.PropertyConfigurer;
import com.hisen.common.PushUtil;
import com.hisen.entity.ApiResult;
import com.hisen.entity.Book;
import com.hisen.service.BookService;
import com.sun.deploy.config.ClientConfig;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by hisen on 17-4-24.
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @Autowired
    private PropertyConfigurer configurer;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Book> list = bookService.getList(0, 1000);
        model.addAttribute("list", list);
        return "list";// WEB-INF/jsp/"list".jsp
    }

    @RequestMapping(value = "/allbook", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String allBook() {
        List<Book> list = bookService.getList(0, 1000);
        Gson gson = new Gson();
        ApiResult<List<Book>> apiResult = new ApiResult<>();
        apiResult.setData(list);
        apiResult.setCode("1");
        apiResult.setMsg("查询成功");

        String result = gson.toJson(apiResult);

//        JPushClient pushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());

        return result;// WEB-INF/jsp/"list".jsp
    }


    @RequestMapping(value = "/detail/{bookId}", method = RequestMethod.GET)
    private String detail(@PathVariable("bookId") Long bookId, Model model) {
        Book book = bookService.getById(bookId);
        model.addAttribute("book", book);
        return "detail";
    }

    //    @RequestMapping(value = "/add/{bookId}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
//    @ResponseBody
//    private String add(@PathVariable("bookId") long booiId , @Param("number") int number , @Param("name")  String name , @Param("detail") String detail) {
//        Book hasBook = bookService.getById(booiId);
//        int i = -2;
//        if (hasBook == null) {
//            hasBook = new Book();
//            hasBook.setBookId(booiId);
//            hasBook.setNumber(number);
//            hasBook.setDetail(detail);
//            hasBook.setName(name);
//            i = bookService.addBook(hasBook);
//        }
//        return i > 0 ? "success" : "error";
//    }
//
//
    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    private String add(@Param("book_id") long book_id,
                       @Param("name") String name,
                       @Param("number") int number,
                       @Param("detail") String detail,
                       @Param("url") String url
    ) {

        ApiResult apiResult = new ApiResult();

        Book book = new Book();
//        book.setBookId(book_id);
        book.setName(name);
        book.setDetail(detail);
        book.setNumber(number);
        book.setUrl(url);
        book.setDate(new Date());


        int i = 0;

        Gson gson = new Gson();
        String result = "";
        try {

            i = bookService.addBook(book);

            apiResult.setMsg("添加成功");
            apiResult.setCode("1");

        } catch (Exception e) {
            apiResult.setData("添加失败" + e.getMessage());
            apiResult.setCode("0");
            e.printStackTrace();
        }
        result = gson.toJson(apiResult);
        return result;
    }



    /*


     jsp 使用  submit  post  来请求 添加接口  ---？
       】】】】 user 参数如何传递  】】】】


    *     // 具体的添加用户处理方法(post请求)
    // 注意: BindingResult必须在User之后, 中间不能有其他的参数
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Validated User user, BindingResult br) throws IOException { // @Validated: 对User数据进行校验
        if (br.hasErrors()) {
            return "user/add"; // 如果有错误, 则直接跳转到add添加用户页面
        }
        userMap.put(user.getUsername(), user);
        return "redirect:/user/users"; // 重定向到用户列表页面
    }
    *
    * */


    @RequestMapping(value = "/del/{bookId}", method = RequestMethod.GET)
    @ResponseBody
    private String deleteBookById(@PathVariable("bookId") Long id) {

        Gson gson = new Gson();
        ApiResult apiResult = new ApiResult<>();
        int i = bookService.deleteBookById(id);
        if (i > 0) {
            apiResult.setCode("1");
            apiResult.setMsg("删除成功");
        } else {
            apiResult.setCode("0");
            apiResult.setMsg("删除失败");
        }
        String result = gson.toJson(apiResult);
        return result;
    }

    @RequestMapping(value = "/push/{pushId}")
    @ResponseBody
    private String sendPush(@PathVariable("pushId") String pushId) {
        Gson gson = new Gson();
        ApiResult apiResult = new ApiResult<>();
        PushUtil.sendPush(pushId);
        apiResult.setCode("1");
        apiResult.setMsg("推送成功\n" + pushId);
        String result = gson.toJson(apiResult);
        return result;
    }


    @PostConstruct
    public void init() {
        logger.debug("-----------------upload controller init()------------------------");
    }


    @RequestMapping(value = "/image")
    @ResponseBody
    public String fileUpload(
            @RequestParam("file") MultipartFile file,
            HttpServletRequest request) {


        System.out.println("测试能够获取pro文件");
        System.out.println("istest = " + configurer.getProperty("config.istest", "true"));


        Gson gson = new Gson();
        ApiResult<String> apiResult = new ApiResult<>();


        if (file != null && !file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            logger.debug(originalFilename);

            // 文件保存路劲
            File outPath = new File(request.getServletContext().getRealPath("/"), "upload");
            if (!outPath.exists() || !outPath.isDirectory()) {
                outPath.mkdirs();
            }

            //保存的文件 dest file
            File outFile = new File(outPath, file.getOriginalFilename());

            logger.debug(outFile.getAbsolutePath());

            try {
                file.transferTo(outFile);
                apiResult.setCode("1");
                apiResult.setMsg("succeed");

                //InetAddress.getLocalHost().getHostAddress();//获得本机IP
                String localIp = InetAddress.getLocalHost().getHostAddress();//获得本机IP
                String url = request.getContextPath();
                String realPath = "";
                if (configurer.getProperty("config.istest").equals("true")) {
                    realPath = "http://" + INTERNET_IP + ":" + request.getLocalPort() + "/hello-ssm/upload/" + file.getOriginalFilename();
                } else {
                    realPath = "http://" + "www.luocaca.cn" + "/hello-ssm/upload/" + file.getOriginalFilename();
                }


                Book book = new Book();
                book.setUrl(realPath);
                book.setDate(new Date());
                book.setDetail("安卓手机图片上传");
                bookService.addBook(book);

                // private String name;
                //    private int number;
                // private String detail;
                //  private Date date ;

                logger.debug(realPath);
                apiResult.setData(realPath);
//              apiResult.setData(request.getServletContext().getRealPath("/") + file.getOriginalFilename());
            } catch (IOException e) {
                apiResult.setCode("0");
                apiResult.setMsg("faild;\n" + e.getMessage());
                e.printStackTrace();
                logger.debug(e.getMessage());
            }
        }

        logger.debug("" + gson.toJson(apiResult));

        return "" + gson.toJson(apiResult);


    }


    /**
     * 获得外网IP
     *
     * @return 外网IP
     */
    private static String getInternetIp() {
        try {
            Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            Enumeration<InetAddress> addrs;
            while (networks.hasMoreElements()) {
                addrs = networks.nextElement().getInetAddresses();
                while (addrs.hasMoreElements()) {
                    ip = addrs.nextElement();
                    if (ip != null
                            && ip instanceof Inet4Address
                            && ip.isSiteLocalAddress()
                            && !ip.getHostAddress().equals(INTRANET_IP)) {
                        return ip.getHostAddress();
                    }
                }
            }

            // 如果没有外网IP，就返回内网IP
            return INTRANET_IP;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static String INTRANET_IP = getIntranetIp(); // 内网IP
    public static String INTERNET_IP = getInternetIp(); // 外网IP

    /**
     * 获得内网IP
     *
     * @return 内网IP
     */
    private static String getIntranetIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}