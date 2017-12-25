package com.hisen.web;

import com.google.gson.Gson;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
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


}