package com.n8ify.spooky.dao

import com.n8ify.spooky.model.spot.Spot
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.lang.StringBuilder
import java.sql.ResultSet

const val FIND_ALL_SPOT = -1

interface SpotDao {

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    fun querySpots(limit: Int? = FIND_ALL_SPOT): List<Spot>

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    fun delete(id: Int)

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    fun insert(spot: Spot)

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    fun update(spot: Spot)

}

@Repository
class SpotDaoImpl : BaseAbstractDao(), SpotDao {

    override fun querySpots(limit: Int?): List<Spot> {
        val sql = StringBuilder()
        sql.append("SELECT * FROM spot")
        if (limit != FIND_ALL_SPOT) {
            sql.append(" LIMIT = ?")
            val params = arrayOf(limit)
            return jdbcTemplate!!.query(sql.toString(), params, SpotRowMapper())
        } else {
            return jdbcTemplate!!.query(sql.toString(), SpotRowMapper())
        }
    }

    override fun delete(id: Int) {
        val sql = StringBuilder()
        sql.append("DELETE FROM spot WHERE id = ?")

        val params = arrayListOf(id)

        jdbcTemplate!!.update(sql.toString(), params.toArray())
    }

    override fun insert(spot: Spot) {
        val sql = StringBuilder()
        sql.append("INSERT INTO spot (tale, description, remark, status, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?)")

        val params = arrayListOf(spot.tale, spot.description, spot.remark, spot.status, spot.latitude, spot.longitude)

        jdbcTemplate!!.update(sql.toString(), params.toArray())
    }

    override fun update(spot: Spot) {
        val sql = StringBuilder()
        sql.append("UPDATE spot SET tale = ?, description = ?, remark = ?, status = ?, latitude = ?, longitude = ? WHERE id = ?")

//        val params = ArrayList<Any?>()
//        params.add(spot.tale)
//        params.add(spot.description)
//        params.add(spot.remark)
//        params.add(spot.status)
//        params.add(spot.latitude)
//        params.add(spot.longitude)
//        params.add(spot.id)

        jdbcTemplate!!.update(sql.toString(), spot.tale, spot.description, spot.remark, spot.status, spot.latitude, spot.longitude, spot.id)}
}

class SpotRowMapper : RowMapper<Spot> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Spot? {
        val id = rs.getInt("id")
        val tale = rs.getString("tale")
        val description = rs.getString("description")
        val remark = rs.getString("remark")
        val status = rs.getInt("status")
        val latitude = rs.getFloat("latitude")
        val longitude = rs.getFloat("longitude")
        val createTimeStamp = rs.getTimestamp("create_timestamp")
        return Spot(id, tale, description, remark, status, latitude, longitude, createTimeStamp)
    }
}