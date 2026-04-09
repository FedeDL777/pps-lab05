package it.unibo.pps.polyglot.a01b

import it.unibo.pps.polyglot.OptionToOptional
import it.unibo.pps.polyglot.a01b.Logics
import it.unibo.pps.util.Optionals.Optional as ScalaOptional



/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01b/sol2/ */
trait Logic:
  def hit(x: Int, y:Int): ScalaOptional[Int]
  def won : Boolean

class LogicsImpl(private val size: Int, private val mines: Int) extends Logic:
  def hit(x: Int, y: Int): java.util.Optional[Integer] =
    OptionToOptional(ScalaOptional.Empty()) // Option => Optional converter

  def won = false
