package com.example.sprbootw4.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/board")
@RestController
public class BoardRestController {


    int order = 0;
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    @RequestMapping("/create")
    public Map<String, Object> create(String title, String content, String author){
        System.out.println("create");

        Map<String, Object> board = new HashMap<>();
        board.put("title", title);
        board.put("content", content);
        board.put("author", author);

        board.put("id", ++order);

        list.add(board);

        Map<String, Object> returnValue = new HashMap<String, Object>();
        returnValue.put("resultCode", 200);
        return returnValue;
    }

    @RequestMapping("/update")
    public void update(String id, String title, String content, String author){
        System.out.println("update");

        Map<String, Object> board = detail(id);
        if(title != null && !title.isEmpty()){
            board.put("title", title);
        }
        if(content != null && !content.isEmpty()){
            board.put("content", content);
        }
        if(author != null && !author.isEmpty()){
            board.put("author", author);
        }
    }

    @RequestMapping("/delete")
    public void delete(String id){
        System.out.println("delete");

        Map<String, Object> board = detail(id);
        board.remove("title");
        board.remove("content");
        board.remove("author");
    }

    @RequestMapping("/detail")
    public Map<String, Object> detail(String id){
        System.out.println("detail");

        for(Map<String, Object> each : list){
            if((each.get("id") + "").equals(id)){
                return each;
            }
        }
        return null;
    }

    @RequestMapping("/list")
    public List<Map<String, Object>> list(){
        System.out.println("list");
        return list;
    }

}