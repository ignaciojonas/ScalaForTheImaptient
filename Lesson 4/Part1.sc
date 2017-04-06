class Time (val h: Int, val m: Int = 0) {
  if (h<0 || h>23 || m<0 || m>59 ){
    throw new IllegalArgumentException
  }

  def before(t: Time) : Boolean = {
    (t.h < this.h) ||  (t.h == this.h && t.m < this.m)
  }

  override def toString: String = f"${h}:${m}%02d"
}


val t = new Time(5,12)
val t1 = new Time(5,11)
val t2 = new Time(5,11)

t.before(t1)
t1.before(t2)
t2.before(t)

val t3 = new Time(5)
val t4 = new Time(-55,11)

