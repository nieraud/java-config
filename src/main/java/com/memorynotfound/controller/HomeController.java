package com.memorynotfound.controller;

import com.memorynotfound.models.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

import javax.xml.ws.Response;
import java.net.URI;

@RestController
public class HomeController {

   /* @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model){
        model.addAttribute("message", "Spring MVC Java Config Example");
        return "index";
    }
    */

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
       return "Hello";
    }

    @RequestMapping(value = "/b", method = RequestMethod.POST,headers = "Content-Type=application/json",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Book> getRETURNBook(@RequestBody Book book){

        System.out.println(book.toString());

        return new ResponseEntity<Book>( book,HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST,headers = "Content-Type=application/json",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //@ResponseBody
    public @ResponseBody Book updateBook(@RequestBody Book book){

         book.setAuthorName(" NEW author name");
         book.setName("NEW name ");

         return book;
    }

    @RequestMapping(value = "/str", method = RequestMethod.POST)
   // @ResponseBody
    public String getStr( @RequestBody String str){

        return str + " UP ";
    }

}
