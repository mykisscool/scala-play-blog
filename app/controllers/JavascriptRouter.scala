package controllers

import javax.inject.Inject
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Action}
import play.api.routing.JavaScriptReverseRouter

/** A router resource can be generated by creating an action that invokes the router generator
  *
  * @param cc Simply meant to bundle together components typically used in a controller
  */
class JavascriptRouter @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /** Application's JavaScript/Ajax routes
    *
    * @return JavaScript Reverse Router
    */
  def jsRoutes: Action[AnyContent] = Action { implicit request =>
    Ok(JavaScriptReverseRouter("jsRoutes")(
      controllers.routes.javascript.BlogPostController.addComment
    )).as("text/javascript")
  }
}