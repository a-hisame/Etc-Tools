import java.awt._
import java.awt.image._
import javax.imageio._

object PlayerResourceWriter {

  def splitArgument(arg:String): Option[(String, Int)] = {
    val eqIndex = arg.indexOf("=") 
    eqIndex match {
      case -1 => None
      case _ => 
        Some((arg.substring(0, eqIndex), arg.substring(eqIndex+1).toInt))
    }
  }

  def main(args: Array[String]): Unit = {
    if(args.length < 2) {
      println("usage: program [input-image] [output-image] [params=num]*")
      println("default num is 0 (print:00)")
      println("params are wo(木), cl(レ), st(石), re(葦), gr(麦), ve(野)" +
              "sh(羊), sw(猪), be(牛), fo(食料)") 
    }
    val in = (2 until args.length).flatMap{ n => splitArgument(args(n)) }

    val img = ImageIO.read(new java.io.File(args(0)))
    val g = img.getGraphics.asInstanceOf[Graphics2D]

    def param(str: String): Int = {
      in.find{ case (p, _) => p == str } match {
        case Some((_, n)) => n
        case _ => 0
      }
    }

    val wo = param("wo")
    val cl = param("cl")
    val st = param("st")
    val re = param("re")
    val gr = param("gr")
    val ve = param("ve")
    val sh = param("sh")
    val sw = param("sw")
    val be = param("be")
    val fo = param("fo")

    g.setFont(new Font("ＭＳ Ｐゴシック", Font.PLAIN, 10))
    g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
                       RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

    g.setColor(Color.WHITE)
    g.drawString("木%2d".format(wo), 5, 68)
    g.setColor(Color.WHITE)
    g.drawString("レ%2d".format(cl), 34, 68)
    g.setColor(Color.WHITE)
    g.drawString("石%2d".format(st), 60, 68)
    g.setColor(Color.BLACK)
    g.drawString("葦%2d".format(re), 87, 68)
    g.setColor(Color.BLACK)
    g.drawString("食%2d".format(fo), 114, 68)
    g.setColor(Color.BLACK)
    g.drawString("野%2d".format(ve), 141, 68)

    g.setColor(Color.BLACK)
    g.drawString("羊%2d".format(sh), 141, 13)
    g.setColor(Color.WHITE)
    g.drawString("猪%2d".format(sw), 141, 27)
    g.setColor(Color.WHITE)
    g.drawString("牛%2d".format(be), 141, 41)
    g.setColor(Color.BLACK)
    g.drawString("麦%2d".format(gr), 141, 55)

    g.dispose
    ImageIO.write(img, "PNG", new java.io.File(args(1)))
  }

}

