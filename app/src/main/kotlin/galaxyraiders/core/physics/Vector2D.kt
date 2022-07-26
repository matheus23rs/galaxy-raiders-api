// @file:Suppress("UNUSED_PARAMETER") // <- REMOVE
package galaxyraiders.core.physics
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlin.math.*

@JsonIgnoreProperties("unit", "normal", "degree", "magnitude")
data class Vector2D(val dx: Double, val dy: Double) {
  override fun toString(): String {
    return "Vector2D(dx=$dx, dy=$dy)"
  }

  val magnitude: Double
    get() {
      return sqrt(this.dx.pow(2) + this.dy.pow(2))
    }

  val radiant: Double
    get() {
      val rad: Double = acos(this.dx / sqrt(this.dx.pow(2) + this.dy.pow(2)))
      if ((this.dx < 0 && this.dy < 0) || ((this.dx > 0 && this.dy < 0))) {
        return rad * (-1)
      }
      return rad
    }

  val degree: Double
    get() {
      val rad: Double = acos(this.dx / sqrt(this.dx.pow(2) + this.dy.pow(2)))
      val ang: Double = 180 * rad / PI
      if ((this.dx < 0 && this.dy < 0) || ((this.dx > 0 && this.dy < 0))) {
        return ang * (-1)
      }
      return ang
    }

  val unit: Vector2D
    get() {
      val mod: Double = sqrt(this.dx.pow(2) + this.dy.pow(2))
      val vector: Vector2D = Vector2D(this.dx / mod, this.dy / mod)
      return vector
    }

  val normal: Vector2D
    get() {
      val mod: Double = sqrt(this.dx.pow(2) + this.dy.pow(2))
      val vector: Vector2D = Vector2D(this.dx / mod, this.dy / mod)
      return Vector2D(vector.dy, vector.dx * (-1))
    }

  operator fun times(scalar: Double): Vector2D {
    val vector: Vector2D = Vector2D(this.dx * scalar, this.dy * scalar)
    return vector
  }

  operator fun div(scalar: Double): Vector2D {
    val vector: Vector2D = Vector2D(this.dx / scalar, this.dy / scalar)
    return vector
  }

  operator fun times(v: Vector2D): Double {
    val prod: Double = this.dx * v.dx + this.dy * v.dy
    return prod
  }

  operator fun plus(v: Vector2D): Vector2D {
    val vector: Vector2D = Vector2D(this.dx + v.dx, this.dy + v.dy)
    return vector
  }

  operator fun plus(p: Point2D): Point2D {
    val point: Point2D = Point2D(this.dx + p.x, this.dy + p.y)
    return point
  }

  operator fun unaryMinus(): Vector2D {
    val vector: Vector2D = Vector2D(this.dx * (-1), this.dy * (-1))
    return vector
  }

  operator fun minus(v: Vector2D): Vector2D {
    val vector: Vector2D = Vector2D(this.dx - v.dx, this.dy - v.dy)
    return vector
  }

  fun scalarProject(target: Vector2D): Double {
    val modTarget: Double = sqrt(target.dx.pow(2) + target.dy.pow(2))
    val prodScalar: Double = (this.dx * (target.dx / modTarget)) + (this.dy * (target.dy / modTarget))
    return prodScalar
  }

  fun vectorProject(target: Vector2D): Vector2D {
    val modTarget: Double = sqrt(target.dx.pow(2) + target.dy.pow(2))
    val prodScalar: Double = (this.dx * (target.dx / modTarget)) + (this.dy * (target.dy / modTarget))
    val vector: Vector2D = Vector2D(target.unit.dx * prodScalar, target.unit.dy * prodScalar)
    return vector
  }
}

  operator fun Double.times(v: Vector2D): Vector2D {
    val vector: Vector2D = Vector2D(this * v.dx, this * v.dy)
    return vector
  }
