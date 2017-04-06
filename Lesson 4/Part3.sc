import math._
class Time (h: Int, m: Int = 0) {

  private var minutesSinceMidnight = h * 60 + m

  def hours = minutesSinceMidnight / 60

  def minutes = minutesSinceMidnight % 60

  if (h<0 || h>23 || m<0 || m>59 ){
    throw new IllegalArgumentException
  }
    def minutes_=(newVal : Int) {
    if (newVal < 0 && newVal > 60)
      minutesSinceMidnight= minutesSinceMidnight/60 + newVal
    else
      throw new IllegalArgumentException
  }

  def <(t: Time) =  minutesSinceMidnight < t.minutesSinceMidnight

  def -(t: Time) =  abs(minutesSinceMidnight - t.minutesSinceMidnight)

  override def toString: String = f"${hours}:${minutes}%02d"
}

object Time {
  def apply(h: Int, m: Int = 0) = new Time(h,m)
}

val t = Time(5,33)
val t1 = new Time(15,32)
val t2 = new Time(5,11)


t < t1
t1 < t2
t2 < t

t - t1

t2 - t

val t3 = new Time(5)
val t4 = new Time(-55,11)

