package com.sdn.controller;

import com.sdn.biz.bookBiz;
import com.sdn.entity.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/book")
public class bookController {
    @Autowired
    bookBiz biz;
    @RequestMapping("/getpaing")
    public String getBookpaing(Model model, HttpServletRequest req){
        int pagesize = 4;
        double total = biz.total();
        int pages = (int)Math.ceil(total/pagesize);
        int pageno = 1;
        String pageno_ = req.getParameter("pageno");
        if(pageno_!=null){
            pageno = Integer.parseInt(pageno_);
            if(pageno<1){
                pageno=1;
            }else if(pageno>pages){
                pageno=pages;
            }
        }
        model.addAttribute("ping",biz.getbookpaing((pagesize*pageno)-pagesize,pagesize));
        model.addAttribute("pageno",pageno);
        model.addAttribute("pages",pages);
        return "books/bookPaing";
    }

    @RequestMapping(value = "/addBooks",method = RequestMethod.POST)
    public String addBooks(@ModelAttribute("book")book books, MultipartFile myimg , HttpServletRequest req) {
            if (myimg != null) {
                String uploadPath = "/public/image/bookimage";
                String realPath = req.getRealPath(uploadPath);
                String filename = myimg.getOriginalFilename();
                try {
                    myimg.transferTo(new File(realPath + filename));
                    books.setBookimg(uploadPath + "/" + filename);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            biz.add(books);
        return "redirect:/book/getpaing";
    }

    @RequestMapping(value = "/updatabyid/{id}",method = RequestMethod.POST)
    public String updatabyid(@PathVariable("id")int id,@ModelAttribute("book")book books,MultipartFile myimg, HttpServletRequest req){

        if(myimg==null){
            biz.updates(books);
            return "redirect:/book/getpaing";
        }else {
            String deleteimg = req.getRealPath(books.getBookimg());
            File file = new File(deleteimg);
            file.delete();
                String uploadPath = "/public/image/bookimage";
                String realPath = req.getRealPath(uploadPath);
                String filename = myimg.getOriginalFilename();
                try {
                    myimg.transferTo(new File(realPath + filename));
                    books.setBookimg(uploadPath + "/" + filename);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            biz.updates(books);
            return "redirect:/book/getpaing";
        }

    }

    @RequestMapping("/fm/{id}")
    public String jump(@PathVariable("id")int id,@ModelAttribute("book")book bo , Model model){
        if(id==-1){
            model.addAttribute("onlybook",bo);
            return "books/addBooks";
        }else {
            model.addAttribute("onlybook",biz.getByid(id));
            return "books/addBooks";
        }
    }


    @RequestMapping("/deletee/{id}")
    public String deletebook(@PathVariable("id")int id){
        biz.deletes(id);
        return "redirect:/book/getpaing";
    }
    @RequestMapping("/update/{id}")
    public String updatas(){
        return null;
    }
}
