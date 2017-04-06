import java.awt._

val r = new Rectangle(5,10,20,30)
r.translate(10,20)
r

val e = new geom.Ellipse2D.Double(5,10,20,30)

//e.translate(10,20); Didn't work

trait RectangleLike {

  def setFrame(x: Double, y:Double, w:Double, h:Double) :Unit
  def getX:Double
  def getY:Double
  def getWidth:Double
  def getHeight:Double
  def translate(dx:Double, dy:Double) { setFrame(getX + dx,getY + dy, getWidth, getHeight) }
  override def toString = f"${getX}, ${getY}"
}

val e1 = new geom.Ellipse2D.Double(5,10,20,30) with RectangleLike
e1.translate(10,20)
e1





