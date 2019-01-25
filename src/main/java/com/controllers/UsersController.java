package com.controllers;

import com.entities.UserDetails;
import com.entities.Users;
import com.servicesapi.UsersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("users")
public class UsersController {
    @Autowired
    UsersService userServices;

    @ApiOperation(value = "create lead", produces = "application/json", consumes = "application/json")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView getPage() {
        System.out.println("page refreshed");

        ModelAndView view = new ModelAndView("users");
        return view;
    }


    @ApiOperation(value = "create lead", produces = "application/json", consumes = "application/json")
    @RequestMapping(value = "/page2", method = RequestMethod.GET)
    public ModelAndView getPage2() {
        System.out.println("page refreshed");
        ModelAndView view = new ModelAndView("users2");
        return view;
    }

    @ResponseBody
    @RequestMapping(value="/show",method = RequestMethod.GET)
    public ArrayList<Users> showData(){

        Users usss1 =new Users();

        usss1.setUser_name("Tom");
        usss1.setEmail("tomcat@pt.com");

        Users usss2=new Users();
        usss2.setUser_name("Narayan Gupta");
        usss2.setEmail("narayang@pt.com");

        ArrayList<Users> tm=new ArrayList<Users>();
        tm.add(usss1);
        tm.add(usss2);
        return tm;
    }

    @ResponseBody
    @RequestMapping(value="/show/{user_name}",method=RequestMethod.GET)
    public Users showUsers(@PathVariable("user_name") String str,@RequestBody Users users){
        Users uss=new Users();
        uss.setUser_name(str);
        uss.setEmail(str+"@pttt.com");
        System.out.println("username is "+users.getUser_name()+" email address is "+users.getEmail());
        return uss;
    }


    @ResponseBody
    @RequestMapping(value="/show/{user_name}",method = RequestMethod.PUT)
    public ResponseEntity<Void> showdata(@PathVariable("user_name") String username, @RequestBody Users uss){
        Users users =new Users();
        System.out.println("username = " + username);
        System.out.println("user name is " +uss.getUser_name() + " email address is "+uss.getEmail() );

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ApiOperation(value = "create lead", produces = "application/json", consumes = "application/json")
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getSaved(@RequestBody Users users) {
        System.out.println("Request incoming: " + users);
        Map<String, Object> map = new HashMap<String, Object>();
        if (userServices.saveOrUpdate(users)) {
            map.put("status", "200");
            map.put("message", "Your record have been saved successfully");
        }
        return map;
    }

    @ApiOperation(value = "create lead", produces = "application/json", consumes = "application/json")
    @RequestMapping(value = "/saveOrUpdate2", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getSaved2(@RequestBody UserDetails users) {
        System.out.println("Request incoming: " + users);
        Map<String, Object> map = new HashMap<String, Object>();
        if (userServices.saveOrUpdate2(users)) {
            map.put("status", "200");
            map.put("message", "Your record have been saved successfully");
        }
        return map;
    }

    @ApiOperation(value = "create lead", produces = "application/json", consumes = "application/json")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getAll(Users users) {

        Map<String, Object> map = new HashMap<String, Object>();

        List<Users> list = userServices.list();

        if (list != null) {
            map.put("status", "200");
            map.put("message", "Data found");
            map.put("data", list);
        } else {
            map.put("status", "404");
            map.put("message", "Data not found");

        }

        return map;
    }

    @ApiOperation(value = "create lead", produces = "application/json", consumes = "application/json")
    @RequestMapping(value = "/list2", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getAll2(UserDetails users) {

        Map<String, Object> map = new HashMap<String, Object>();

        List<UserDetails> list = userServices.list2();

        if (list != null) {
            map.put("status", "200");
            map.put("message", "Data found");
            map.put("data", list);
        } else {
            map.put("status", "404");
            map.put("message", "Data not found");

        }

        return map;
    }

    @ApiOperation(value = "create lead", produces = "application/json", consumes = "application/json")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> delete(Users users) {
        Map<String, Object> map = new HashMap<String, Object>();

        if (userServices.delete(users)) {
            map.put("status", "200");
            map.put("message", "Your record have been deleted successfully");
        }

        return map;
    }


}
