// @file:Suppress("UNUSED_PARAMETER") // <- REMOVE
package galaxyraiders.core.physics
import kotlin.math.*

data class Point2D(val x: Double, val y: Double) {
  operator fun plus(p: Point2D): Point2D {
    val point: Point2D = Point2D(x = this.x + p.x, y = this.y + p.y)
    return point
  }

  operator fun plus(v: Vector2D): Point2D {
    val point: Point2D = Point2D(x = this.x + v.dx, y = this.y + v.dy)
    return point
  }

  override fun toString(): String {
    return "Point2D(x=$x, y=$y)"
  }

  fun toVector(): Vector2D {
    val vector: Vector2D = Vector2D(dx = this.x, dy = this.y)
    return vector
  }

  fun impactVector(p: Point2D): Vector2D {
    val vector: Vector2D = Vector2D(dx = p.x - this.x, dy = p.y - this.y)
    return vector
  }

  fun impactDirection(p: Point2D): Vector2D {
    val vector: Vector2D = Vector2D(dx = p.x - this.x, dy = p.y - this.y)
    return vector
  }

  fun contactVector(p: Point2D): Vector2D {
    val vector: Vector2D = Vector2D(dx = p.x - this.x, dy = p.y - this.y)
    return vector.normal
  }

  fun contactDirection(p: Point2D): Vector2D {
    val vector: Vector2D = Vector2D(dx = p.x - this.x, dy = p.y - this.y)
    return vector.normal
  }

  fun distance(p: Point2D): Double {
    val dis: Double = sqrt((this.x - p.x).pow(2) + (this.y - p.y).pow(2))
    return dis
  }
}
