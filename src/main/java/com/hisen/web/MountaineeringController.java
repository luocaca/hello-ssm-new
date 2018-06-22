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


@Controller
@RequestMapping("/mountaineering")
public class MountaineeringController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public MountaineeringService service;

    @RequestMapping(value = "/lately", method = RequestMethod.GET)
    @ResponseBody
    public String mountaineering(Model model) {
        Gson gson = new Gson();
        Mountaineering mountaineering = service.queryLately();
        model.addAttribute("mountaineering", mountaineering);
        ApiResult<Mountaineering> apiResult = new ApiResult<>();
        apiResult.setData(mountaineering);
        apiResult.setCode("1");
        apiResult.setMsg("查询成功");
        String result = gson.toJson(apiResult);
        return result;// WEB-INF/jsp/"list".jsp
    }


}
