package com.n8ify.spooky.controller.rest._base

import com.n8ify.spooky.model.RESPONSE_FAILED
import com.n8ify.spooky.model.RESPONSE_FORCED_SUCCESS
import com.n8ify.spooky.model.RESPONSE_SUCCESS
import com.n8ify.spooky.model.ResponseStatus
import java.lang.Exception

abstract class BaseAbstractController {

    fun getSuccessResponseStatus(message : String = "-") : ResponseStatus {
        return ResponseStatus(RESPONSE_SUCCESS, message)
    }

    fun getFailedResponseStatus(message : String = "Error!", e: Exception? = null) : ResponseStatus {
        return if(e != null){
            ResponseStatus(RESPONSE_FAILED, "$message (Caused by ${e.message})")
        } else {
            ResponseStatus(RESPONSE_FAILED, message)
        }
    }

    fun getForcedSuccessResponseStatus(message : String = "Force Success") : ResponseStatus {
        return ResponseStatus(RESPONSE_FORCED_SUCCESS, message)
    }
}