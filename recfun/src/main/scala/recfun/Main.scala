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
    def isBalanced(chars: List[Char], open_lparens_cnt: Int): Boolean = {
      if (chars.isEmpty && open_lparens_cnt == 0) true
      else if (open_lparens_cnt < 0) false
      else {
        val head_lparens_cnt = {
          if (chars.head == '(') 1 
          else if (chars.head == ')') -1 
          else 0
        }
        isBalanced(chars.tail, open_lparens_cnt + head_lparens_cnt)
      }
    }

    isBalanced(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money > 0 && !coins.isEmpty) {
      val max_head_coin_cnt = money / coins.head
      var ways = 0
      for (i <- 0 to max_head_coin_cnt) {
        ways += countChange(money - coins.head * i, coins.tail)
      }
      ways
    }
    else
      0
  }
}
