
import java.awt._
import java.awt.image._
import javax.imageio._

object PlayedFieldMaker {

  def main(args: Array[String]): Unit = {

    if(args.length < 3) {
      println("usage: program [fieldimage] [overrideimage]" + 
              "[outputimage]")
      println("overrideimage is [0-9]_[0-9][0-9].png format.")
      return ()
    }
    val img = ImageIO.read(new java.io.File(args(0)))
    val g = img.getGraphics
    val dot = args(1).lastIndexOf(".")
    val xx = args(1).substring(dot-4, dot-3).toInt
    val yy = args(1).substring(dot-2, dot).toInt

    val action = ImageIO.read(new java.io.File(args(1)))

    (xx, yy) match {
      case (x, y) if x < 2 =>
        g.drawImage(action, 2+74*x, 3+20*y, null) 
      case (x, y) if x == 2 && y < 4 =>
        g.drawImage(action, 150, 3+20*y, null)
      case (x, y) if x == 2 =>
        g.drawImage(action, 150, 91+20*(y-4), null)
      case (x, y) if x == 3 && y < 2 =>
        g.drawImage(action, 224, 3+20*y, null)
      case (x, y) if x == 3 && y < 4 =>
        g.drawImage(action, 224, 51+20*(y-2), null)
      case (x, y) if x == 3 && y < 6 =>
        g.drawImage(action, 224, 103+20*(y-4), null)
      case (x, y) if x == 3 =>
        g.drawImage(action, 224, 149, null)
      case _ => println("illegal x,y format")
    }

    g.dispose
    ImageIO.write(img, "PNG", new java.io.File(args(2)))
  }

}

