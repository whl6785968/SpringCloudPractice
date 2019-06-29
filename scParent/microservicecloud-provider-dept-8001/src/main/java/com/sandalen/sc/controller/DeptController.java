package com.sandalen.sc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sandalen.sc.entities.Dept;
import com.sandalen.sc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystix_get")
    public Dept get(@PathVariable("id") Long id)
    {
        return deptService.get(id);
    }

    public Dept processHystix_get(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("不存在信息").setDb_source("该库不存在" +id+"的信息");
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list()
    {
        return deptService.list();
    }
}
