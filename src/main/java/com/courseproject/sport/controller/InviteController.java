package com.courseproject.sport.controller;

import com.courseproject.sport.entity.InviteTable;
import com.courseproject.sport.entity.User;
import com.courseproject.sport.service.InviteTableService;
import com.courseproject.sport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/ddy")
public class InviteController {
    private InviteTableService inviteTableService;
    private UserService userService;

    @Autowired
    public InviteController(InviteTableService inviteTableService, UserService userService) {
        this.inviteTableService = inviteTableService;
        this.userService = userService;
    }

    /**
     * 创建表的同时将表加入到创建者的发布记录表
     *
     * @param inviteTable，邀请表对象
     * @param errors，错误对象
     * @return
     */
    @RequestMapping(value = "/createInvite", method = RequestMethod.POST)
    public String createNewInvite(@RequestBody @Valid InviteTable inviteTable, Errors errors) {
        if (errors.hasErrors())
            return "param error";
        inviteTableService.save(inviteTable);
        return "success";
    }

    /**
     * @return 返回有效的邀请表
     */
    @RequestMapping(value = "/allinvite", method = RequestMethod.GET)
    public List<InviteTable> getAll(@RequestBody Map<String, Integer> param) {
        return inviteTableService.findAll(param.get("start"), param.get("end"));
    }


    public InviteTable findById(Integer vid) {
        return inviteTableService.findById(vid);
    }

    /**
     * @return 返回按发布日期有效的邀请表
     */
    @RequestMapping(value = "/inviteSortByAnnounceDate", method = RequestMethod.GET)
    public List<InviteTable> getAllByAnnounceDate(@RequestBody Map<String, Object> param) {
        List<InviteTable> inviteTableList = getAllByType((String) param.get("type"), (Integer) param.get("start"), (Integer) param.get("end"));

        Collections.sort(inviteTableList, Comparator.comparing(InviteTable::getAnnounceDate));
        return inviteTableList;
    }

    /**
     * @return 返回按评分排序的有效邀请表
     */
    @RequestMapping(value = "/inviteSortByScore")
    public List<InviteTable> getAllByScore(@RequestBody Map<String, Object> param) {
        List<InviteTable> inviteTableList = getAllByType((String) param.get("type"), (Integer) param.get("start"), (Integer) param.get("end"));
        Map<Double, InviteTable> map = new HashMap<>();

        for (InviteTable inviteTable : inviteTableList) {
            User user = userService.findUser(inviteTable.getInviterId());
            map.put(user.getScore(), inviteTable);
        }

        Object[] key = map.keySet().toArray();
        List<InviteTable> sortList = new ArrayList<>();
        Arrays.sort(key);

        for (int i = key.length - 1; i >= 0; i--) {
            sortList.add(map.get(key[i]));
        }
        return sortList;
    }

    /**
     * @return 返回按邀请人数排序的有效邀请表
     */
    @RequestMapping(value = "/inviteSortByNumber", method = RequestMethod.GET)
    public List<InviteTable> getAllByNumber(@RequestBody Map<String, Object> param) {
        List<InviteTable> inviteTableList = getAllByType((String) param.get("type"), (Integer) param.get("start"), (Integer) param.get("end"));
        Collections.sort(inviteTableList, Comparator.comparing(InviteTable::getNumber));
        return inviteTableList;
    }

    public List<InviteTable> getAllByType(String type, int start, int end) {
        List<InviteTable> inviteTableList = inviteTableService.findAllByType(type, start, end);
        for(InviteTable inviteTable:inviteTableList){
            inviteTable.setUser(userService.findUser(inviteTable.getInviterId()));
        }
        return inviteTableList;
    }

    /**
     * 接受邀请的同时将表加入到参与者的接受记录表
     *
     * @param inviteTable，邀请表对象
     * @param errors，
     * @return
     */
    @RequestMapping("/acceptinvite")
    public String acceptInvite(@RequestBody @Valid InviteTable inviteTable, Errors errors) {
        if (errors.hasErrors())
            return "param error";
        if (inviteTableService.findById(inviteTable.getId()) != null) {
            inviteTable.setIs_evaluate(1);
            inviteTableService.save(inviteTable);
        } else
            return "无效表";
        return "success";
    }

    /**
     * 给邀请表发起者评分
     *
     * @param param 分数
     * @return
     */
    @RequestMapping("/score")
    public String score(@RequestBody Map<String, String> param) {
        InviteTable inviteTable = findById(Integer.valueOf(param.get("vid")));
        if (inviteTable != null) {
            if (inviteTable.getIs_evaluate() == 0) {
                User user = userService.findUser(inviteTable.getInviterId());
                if (user != null) {
                    double newScore = Double.parseDouble(param.get("score"));
                    user.setScore((user.getScore() + newScore) / 2);
                    userService.save(user);
                    inviteTable.setIs_evaluate(1);
                    return "success";
                } else
                    return "用户不存在！";
            } else
                return "已评价";
        } else
            return "无效的表";
    }
}