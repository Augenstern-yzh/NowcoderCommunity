package com.nowcoder.comunity.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AlphaDaoMybatis implements AlphaDao{

    @Override
    public String select() {
        return "Mybatis";
    }
}
