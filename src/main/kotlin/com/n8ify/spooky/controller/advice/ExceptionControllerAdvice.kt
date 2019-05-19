package com.n8ify.spooky.controller.advice

import com.n8ify.spooky.controller.rest._base.BaseAbstractController
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import com.n8ify.spooky.model.ResponseStatus
import org.springframework.web.bind.annotation.ResponseBody

@ControllerAdvice
class ExceptionControllerAdvice : BaseAbstractController() {

    @ExceptionHandler(Exception::class)
    @org.springframework.web.bind.annotation.ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun handlerGlobalException(e :  Exception) : ResponseStatus {
        return getFailedResponseStatus(e = e)
    }
}