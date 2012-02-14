import java.awt._
import java.awt.image._
import javax.imageio._

object StageMaker {

  def main(args: Array[String]): Unit = {
    var width = 70
    var height = 16
    var waku_color = new Color(0, 0, 0)
    var board_color = new Color(255, 255, 255)
    var font_color = new Color(0, 0, 0)
    var fsize = 12
    var offset = 2

    args.toList match {
      case list if list.length < 2 =>
        println("usage: program string output-filename")
        println("option: fontsize=12, waku=0x000000, board=0xffffff")
	println("fontcolor=0x000000, width=70, height=16, offset=2")
        return ()
      case a :: b :: rest =>
        rest.foreach{ args =>
	  if( args.startsWith("fontsize=") ) {
	    fsize = args.substring(9).toInt
	  }
	  if( args.startsWith("fontcolor=") ) {
	    font_color = new Color(Integer.decode(args.substring(10)).intValue)
	  }
	  if( args.startsWith("waku=") ) {
	    waku_color = new Color(Integer.decode(args.substring(5)).intValue)
	  }
	  if( args.startsWith("board=") ) {
            board_color = new Color(Integer.decode(args.substring(6)).intValue)
	  }
	  if( args.startsWith("width=") ) {
	    width = args.substring(6).toInt
	  }
	  if( args.startsWith("height=") ) {
	    height = args.substring(7).toInt
	  }
	  if( args.startsWith("offset=") ) {
            offset = args.substring(7).toInt
	  }
	}
      case _ =>
    }

    val img = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR)
    val g = img.getGraphics.asInstanceOf[Graphics2D]

    g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
                       RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    val font = new Font("ＭＳ Ｐゴシック", Font.PLAIN, fsize)

    g.setColor(board_color)
    g.fillRect(0, 0, width, height)
    g.setColor(waku_color)
    g.drawRect(0, 0, width-1, height-1)
    
    g.setFont(font)
    val x = (width - g.getFontMetrics.stringWidth(args(0)))/2
    val y = (height - fsize)/2 + fsize - offset

    g.setColor(font_color)
    g.drawString(args(0), x, y)

    g.dispose

    ImageIO.write(img, "PNG", new java.io.File(args(1)))
    
  }
}

