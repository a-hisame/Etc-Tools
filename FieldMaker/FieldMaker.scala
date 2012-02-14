import java.awt._
import java.awt.image._
import javax.imageio._

object FieldMaker {

  def write(g: Graphics, x: Int, y: Int,
            sp: Int, dir: String, files: Seq[String]): Unit = 
  {
    var count = 0
    files.foreach{ file => 
      val img = ImageIO.read(new java.io.File(dir + "\\" + file))
      g.drawImage(img, x, y+sp*count, null)
      println("wrote: %d, %d(%s)".format(x, y+sp*count, dir+"\\"+file))
      count += 1
    }
  }

  def main(args: Array[String]): Unit = {

    if(args.length < 2) {
      println("usage: program [directory] [templete]")
      println("directory needs to have x_xx.png format files")
      return ()
    }
    val img = ImageIO.read(new java.io.File(args(1)))
    val g = img.getGraphics

    // left 2 elements
    write(g, 2, 3, 20, args(0), (0 to 7).map{n => "%d_%02d.png".format(0, n)})
    write(g, 76, 3, 20, args(0), (0 to 7).map{n => "%d_%02d.png".format(1, n)})

    // stage1, 2
    write(g, 150, 3, 20, args(0),
      (0 to 3).map{n => "%d_%02d.png".format(2, n)})
    write(g, 150, 91, 20, args(0), 
      (4 to 6).map{n => "%d_%02d.png".format(2, n)})

    // stage3, 4, 5, 6
    write(g, 224, 3, 20, args(0), 
      (0 to 1).map{n => "%d_%02d.png".format(3, n)})
    write(g, 224, 51, 20, args(0),
      (2 to 3).map{n => "%d_%02d.png".format(3, n)})
    write(g, 224, 103, 20, args(0),
      (4 to 5).map{n => "%d_%02d.png".format(3, n)})
    write(g, 224, 149, 20, args(0),
      (6 to 6).map{n => "%d_%02d.png".format(3, n)})

    g.dispose
    ImageIO.write(img, "PNG", new java.io.File("fieldresult.png"))
  }
}

