package recfun
import common._

object Main {
  def main(args: Array[String]) = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c > r) 0
    else if (r == 0 || c == 0 || r == c) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    import scala.annotation.tailrec

    @tailrec
    def isBalanced(chars: List[Char], scanned_lparens_cnt: Int): Boolean = {
      if (chars.isEmpty && scanned_lparens_cnt == 0) true
      else if (scanned_lparens_cnt < 0) false
      else {
        val head_lparens_cnt = if (chars.head == '(') 1 else -1
        isBalanced(chars.tail, scanned_lparens_cnt + head_lparens_cnt)
      }
    }

    isBalanced(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    3
  }
}
