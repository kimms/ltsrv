package com.patin.srv.api.common.base;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * BaseDao.java
 * 2018. 8. 12.
 * @author KIM, MinSeob
 */
public class BaseDao extends SqlSessionDaoSupport{
	@Override
    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

}
