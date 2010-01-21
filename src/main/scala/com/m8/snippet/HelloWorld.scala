package com.m8.snippet

import _root_.scala.xml.{NodeSeq, Text}
import _root_.net.liftweb.util._
import _root_.net.liftweb.common._
import _root_.java.util.Date
import com.m8.lib._
import Helpers._

import com.m8.model._

class HelloWorld {
  lazy val date: Box[Date] = DependencyFactory.inject[Date] // inject the date

  def howdy(in: NodeSeq): NodeSeq =
  Helpers.bind("b", in, "time" -> date.map(d => Text(d.toString)))
  
  /****************   This code will be executed 2 times when refresh the browser ??? ****************/
	  val users = User.getUsers()
	  println("-------------- Users:   " + users)
	
	
	  /** ################## Begining of ... Works ################## */
	  // Hot.findAll()
	  println("-------------- Hots:   " + Hot.getHots())
	  /** ################## End of ... Works ################## */
	  
	  
	  /** ################## Begining of ... Doesn't Work ################## */
	  // use this code: DB.runQuery(...)
	  //println("-------------- Hots2:   " + Hot.getHots2(0))
	  
	  // use this code: DB.use(bootstrap.liftweb.TwoDB) 
	  println("-------------- Hots3:   " + Hot.getHots3(0))
	  /** ################## End of ... Doesn't Work ##################*/
  
   /****************   This code will be executed 2 times when refresh the browser ??? ****************/


  /*
   lazy val date: Date = DependencyFactory.time.vend // create the date via factory

   def howdy(in: NodeSeq): NodeSeq = Helpers.bind("b", in, "time" -> date.toString)
   */
}


