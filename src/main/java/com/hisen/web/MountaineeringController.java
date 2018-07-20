package com.hisen.web;

import com.google.gson.Gson;
import com.hisen.entity.ApiResult;
import com.hisen.entity.Mountaineering;
import com.hisen.service.MountaineeringService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/mountaineering")
public class MountaineeringController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MountaineeringService service;

    @RequestMapping(value = "/lately", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String mountaineering(Model model) {
        Gson gson = new Gson();
        Mountaineering mountaineering = service.queryLately();


        Mountaineering.convertJsonToList(mountaineering);

        model.addAttribute("mountaineering", mountaineering);
        ApiResult<Mountaineering> apiResult = new ApiResult<>();
        apiResult.setData(mountaineering);
        apiResult.setCode("1");
        apiResult.setMsg("查询成功");
        String result = gson.toJson(apiResult);
        return result;// WEB-INF/jsp/"list".jsp
    }


    @RequestMapping(value = "/publish", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String adminPage(Model model) {

        return "publish";// WEB-INF/jsp/"list".jsp
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String add(Mountaineering model) {
        ApiResult apiResult = new ApiResult();
        Gson gson = new Gson();
        String result = "";
        int i = 0;
        try {

//            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
            model.setCreateDate(new Date());
            i = service.addMountaineering(model);
            apiResult.setMsg("添加成功");
            apiResult.setCode("1");
        } catch (Exception e) {
            apiResult.setMsg("添加失败" + e.getMessage());
            apiResult.setCode("0");
            e.printStackTrace();
        }
        result = gson.toJson(apiResult);

        return result;// WEB-INF/jsp/"list".jsp
    }


    @RequestMapping(value = "/update", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String update(Mountaineering model) {

//        Mountaineering mountaineering = service.queryLately();
//      mountaineering.setPrice(300);

        ApiResult apiResult = new ApiResult();
        Gson gson = new Gson();
        String result = "";
        int i = 0;
        try {
            i = service.updateMountaineering(model);

//            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
//            model.setCreateDate(new Date());
//            i = service.addMountaineering(model);
            apiResult.setMsg("修改成功"+i);
            apiResult.setCode("1");
        } catch (Exception e) {
            apiResult.setMsg("修改失败" + e.getMessage());
            apiResult.setCode("0");
            e.printStackTrace();
        }
        result = gson.toJson(apiResult);
        return result;// WEB-INF/jsp/"list".jsp
    }


}
