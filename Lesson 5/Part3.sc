import java.io._

trait Logged {
  def log(msg: String) {}
}

trait ConsoleLogger extends Logged {
  override def log(msg: String) { println(msg) }
}

trait Buffered extends InputStream with Logged {
  val SIZE = 1024
  private var end = 0
  private val buffer = new Array[Byte](SIZE)
  private var pos = 0

  override def read() = {
    if (pos == end) {
      end = super.read(buffer, 0, SIZE)
      pos = 0
      log(s"Buffering Current Position ${pos}, Current End ${end}")
    }
    if (pos == end) -1 else {
      pos += 1
      log(s"Reading Current Position ${pos}, Current End ${end}")
      buffer(pos - 1)
    }
  }
}

val words = new FileInputStream("/usr/share/dict/words") with Buffered  with ConsoleLogger
words.read()
words.read()
words.read()
words.read()



