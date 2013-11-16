package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class Comment(id: Long, comment: String)

object Comment {

  def all(): List[Comment] = DB.withConnection { implicit c =>
    SQL("select * from comment").as(comment *)
  }

  def insertDB(comment: String) {
    DB.withConnection { implicit c =>
      SQL("""
          insert into comment (comment)
          values ({comment})
          """
      ).on(
        'comment -> comment
      ).executeUpdate()
    }
  }

  val comment = {
    get[Long]("id") ~
    get[String]("comment") map {
      case id ~ comment => Comment(id, comment)
    }
  }
}