package com.kaka.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description: TODO
 * @Author fuwei
 * @Date Created in  2018/12/11 18:24
 */
@RestController
@RequestMapping("/kaka")
@Api(value = "测试api", tags = {"测试api"})
public class KakaController {

    @ResponseBody
    @PostMapping(value = "/post", produces = {"application/json;charset=UTF-8"})
    @ApiOperation("post测试")
    public String post(@RequestBody Map map) {
        return JSON.toJSONString(map.values());
    }

    @ResponseBody
    @GetMapping(value = "/get", produces = {"application/json;charset=UTF-8"})
    @ApiOperation("get测试")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "key", value = "关键字", required = false, dataType = "String")})
    public String get(@Param("key") String key) {
        return "传入 key=" + key;
    }
}
