package control;

import bean.Person;
import bean.Result;
import bean.Score;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 野 on 2016/6/6.
 */
@Controller
@RequestMapping("/operatePerson")
public class PersonControl {

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result<Person> register(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name, @RequestParam(value = "pwd") String pwd) {
        Result<Person> result = new Result<>();
        Person p = new Person();
        p.setId(id);
        p.setName(name);
        p.setPwd(pwd);

        System.out.println("register - name: " + name);

        result.setResult(p);
        result.setRetCode("0000000");
        result.setRetInfo("成功");
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/queryPersons", method = RequestMethod.GET)
    public Result<List<Person>> queryPersons() {
        Result<List<Person>> result = new Result<>();
        List<Person> lists = new ArrayList<>();
        lists.add(new Person(10012001, "张三", ""));
        lists.add(new Person(10012002, "李四", ""));
        lists.add(new Person(10012003, "王二", ""));
        lists.add(new Person(10013001, "赵武", ""));
        lists.add(new Person(10013002, "二炮手", ""));
        lists.add(new Person(10013003, "魔兽", ""));
        lists.add(new Person(10013004, "征途", ""));
        lists.add(new Person(10013005, "大话西游", ""));
        lists.add(new Person(20011001, "梦幻西游", ""));
        lists.add(new Person(20011002, "英雄联盟", ""));
        lists.add(new Person(20015898, "英雄连", ""));
        lists.add(new Person(20012258, "钢铁连", ""));
        lists.add(new Person(20012009, "年少轻狂", ""));
        lists.add(new Person(20013005, "菜鸟的日记", ""));
        lists.add(new Person(30013245, "逃学威龙", ""));
        lists.add(new Person(30016464, "火在烧", ""));
        lists.add(new Person(30014656, "狼牙", ""));
        lists.add(new Person(30014987, "琥珀", ""));
        lists.add(new Person(30015665, "棒槌", ""));
        lists.add(new Person(40013005, "三狗子", ""));
        lists.add(new Person(50012026, "MAC王", ""));
        lists.add(new Person(60011001, "小哈尔", ""));

        result.setResult(lists);
        result.setRetCode("0000000");
        result.setRetInfo("成功");
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/queryScore/{name}", method = RequestMethod.GET)
    public Result<List<Score>> queryScore(@PathVariable("name") String name) {
        Result<List<Score>> result = new Result<>();
        List<Score> lists = new ArrayList<>();

        lists.add(new Score("英语", 89.2f));
        lists.add(new Score("日语", 82.5f));
        lists.add(new Score("法语", 98f));
        lists.add(new Score("德语", 69.5f));
        lists.add(new Score("韩语", 78f));
        lists.add(new Score("语文", 99f));
        lists.add(new Score("数学", 100f));
        lists.add(new Score("生物", 63.5f));

        result.setResult(lists);
        result.setRetCode("0000000");
        result.setRetInfo("成功");
        return result;
    }

//    @ResponseBody
//    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
//    public Result<String> uploadFile(@RequestParam(value = "upfile", required = true) MultipartFile file, HttpServletRequest request, ModelMap model) throws UnsupportedEncodingException {
//
//        Result<String> result = new Result<>();
//
//        String path = request.getSession().getServletContext().getInitParameter("file-upload");
//        String fileName = file.getOriginalFilename();
//        String name = request.getParameter("name");
//        System.out.println("uploadFile");
//        File targetFile = new File(path, fileName);
//        if (!targetFile.exists()) {
//            targetFile.mkdirs();
//        }
//
//        //保存
//        try {
//            file.transferTo(targetFile);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        result.setResult(name + "上传图片成功");
//        //    result.setResult("上传图片成功");
//        result.setRetCode("0000000");
//        result.setRetInfo("成功");
//        return result;
//    }

    @ResponseBody
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public Result<String> uploadFile(HttpServletRequest request) throws UnsupportedEncodingException {

        Result<String> result = new Result<>();

        String path = request.getSession().getServletContext().getInitParameter("file-upload");
        String name = request.getParameter("name");

        CommonsMultipartResolver commonsMultipartResolver = new  CommonsMultipartResolver(request.getSession().getServletContext());
        commonsMultipartResolver.setDefaultEncoding("utf-8");
        commonsMultipartResolver.getFileUpload().getFileItemFactory();
        MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart(request);
        Iterator<String> names = multipartRequest.getFileNames();
        System.out.println("uploadAnyFiles");
        while (names.hasNext()) {

            String nameFile = names.next();
            System.out.println("name:" +  nameFile);
            MultipartFile file = multipartRequest.getFile(name);

            File targetFile = new File(path, nameFile);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }

            //保存
            try {
                file.transferTo(targetFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        result.setResult(name + "上传图片成功");
        //    result.setResult("上传图片成功");
        result.setRetCode("0000000");
        result.setRetInfo("成功");
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/uploadAnyFiles", method = RequestMethod.POST)
    public Result<String> uploadAnyFiles(HttpServletRequest request,
                                     ModelMap model) throws UnsupportedEncodingException {
        Result<String> result = new Result<>();

        String path = request.getSession().getServletContext().getInitParameter("file-upload");
        String name = request.getParameter("name");

        CommonsMultipartResolver commonsMultipartResolver = new  CommonsMultipartResolver(request.getSession().getServletContext());
        commonsMultipartResolver.setDefaultEncoding("utf-8");
        commonsMultipartResolver.getFileUpload().getFileItemFactory();
        MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart(request);
        Iterator<String> names = multipartRequest.getFileNames();
        System.out.println("uploadAnyFiles");
        while (names.hasNext()) {

            String nameFile = names.next();
            System.out.println("name:" +  nameFile);
            MultipartFile file = multipartRequest.getFile(name);

            File targetFile = new File(path, nameFile);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }

            //保存
            try {
                file.transferTo(targetFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        result.setResult(name + "上传图片成功");
        //    result.setResult("上传图片成功");
        result.setRetCode("0000000");
        result.setRetInfo("成功");
        return result;
    }

    /**
     * 保存文件
     * @param path 文件路径
     * @param fileName 文件名称
     */
    private void saveFile(String path, String fileName, MultipartFile file) {
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}