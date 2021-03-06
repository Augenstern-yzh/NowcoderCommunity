package com.nowcoder.comunity.service;

import com.nowcoder.comunity.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.ws.ServiceMode;

@Service
//@Scope("prototype")
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;
    AlphaService(){
        System.out.println("construct alpha service");
    }

    @PostConstruct
    public void init(){
        System.out.println("init alpha service");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("destroy alpha service");
    }
    public  String find(){
        return alphaDao.select();
    }
}
