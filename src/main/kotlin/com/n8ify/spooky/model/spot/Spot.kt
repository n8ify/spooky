package com.n8ify.spooky.model.spot

import com.google.gson.annotations.Expose
import java.sql.Timestamp

data class Spot(val id : Int, val tale : String, val description : String?, val remark : String?, val status : Int, val latitude : Float, val longitude : Float, @Expose(deserialize = true, serialize = false) val createTimestamp: Timestamp?)