package com.n8ify.spooky.dao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.support.JdbcDaoSupport
import javax.annotation.PostConstruct
import javax.sql.DataSource

abstract class BaseAbstractDao : JdbcDaoSupport() {

    @Autowired
    lateinit var spotDataSource : DataSource

    @PostConstruct
    fun doOnPostConstruct(){
        setDataSource(spotDataSource)
    }

}