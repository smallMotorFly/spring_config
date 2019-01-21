package com.zhangbin.jpa.controller;

import com.zhangbin.jpa.entity.UserEntity;
import com.zhangbin.jpa.jpa.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

;import java.util.Optional;

/**
 * mark
 *
 * @Author: zhangbin
 * @Date: 2019-01-20 21:27
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private UserJpa userJ;

    @RequestMapping(value = "/login")
    public String login(UserEntity user, HttpServletRequest request) {

        String result = "登录成功";
        boolean flag = true;
        Optional<UserEntity> userEntity = userJ.findOne(new Specification<UserEntity>() {

            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"), user.getName()));
                return null;
            }
        });

        if (userEntity == null) {
            flag = false;
            result = "用户不存在，登录失败";
        } else if (!userEntity.get().getPassword().equals(user.getPassword())) {
            flag = false;
            result = "用户密码错误，登录失败";
        }

        if (flag) {
            //将用户写入session
            request.getSession().setAttribute("_session_user",userEntity);
        }

        return result;
    }


}
