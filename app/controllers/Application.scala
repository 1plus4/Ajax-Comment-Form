package controllers

import play.api._
import play.api.mvc._
import models.Comment

object Application extends Controller {

  def index = Action {
    Ok(views.html.index(Comment.all()))
  }

  def postComment(comment: String) = Action { implicit request =>
    Comment.insertDB(comment)
    Ok
  }

  def javascriptRoutes = Action { implicit request =>
    import routes.javascript._
    Ok(
       Routes.javascriptRouter("jsRoutes")(routes.javascript.Application.postComment)
    ).as("text/javascript")
  }

}