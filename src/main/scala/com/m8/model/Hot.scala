package com.m8.model

import _root_.net.liftweb.mapper._
import _root_.net.liftweb.common._
import _root_.net.liftweb.util._ 

/**
 * The singleton that has methods for accessing the database
 */
object Hot extends Hot with LongKeyedMetaMapper[Hot] { 
  override def dbTableName = "hots" // define the DB table name
  
  /* Define the default connection identifier */
  override def dbDefaultConnectionIdentifier = bootstrap.liftweb.TwoDB
  
  override def fieldOrder = List(id, title)
}


/**
 * An O-R mapped "Hot" class that includes: id, title
 */
class Hot extends LongKeyedMapper[Hot] with IdPK { 
  def getSingleton = Hot
  
  object title extends MappedPoliteString(this, 100)

  def getHots() = Hot.findAll()
  
  def getHots2(id : Long) = {
    DB.runQuery("SELECT * FROM "+
	             "hots "+
	             "WHERE id>? ", List(id))
  }
  
  def getHots3(id : Long) = {
    DB.use(bootstrap.liftweb.TwoDB) {
      conn => 
				DB.prepareStatement("SELECT * FROM hots WHERE id>?", conn) {
					stmt =>
						stmt.setLong(1, id)
						stmt.executeUpdate()
				}
    }
  }

  
}
