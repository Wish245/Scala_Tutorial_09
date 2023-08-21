class Account(initialBalance: Double) {
  private var balance: Double = initialBalance
  
  def getBalance: Double = balance
  
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $amount. New balance: $balance")
    } else {
      println("Invalid deposit amount.")
    }
  }
  
  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $amount. New balance: $balance")
    } else {
      println("Invalid withdrawal amount or insufficient balance.")
    }
  }
  
  def transfer(amount: Double, targetAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      targetAccount.deposit(amount)
      println(s"Transferred $amount to target account. New balance: $balance")
    } else {
      println("Invalid transfer amount or insufficient balance.")
    }
  }
}

object AccountTest {
  def main(args: Array[String]): Unit = {
    val account1 = new Account(1000.0)
    val account2 = new Account(500.0)
    
    println(s"Initial balance of account1: ${account1.getBalance}")
    println(s"Initial balance of account2: ${account2.getBalance}")
    
    account1.deposit(200.0)
    account1.withdraw(100.0)
    
    account2.deposit(300.0)
    
    account1.transfer(150.0, account2)
    
    println(s"Final balance of account1: ${account1.getBalance}")
    println(s"Final balance of account2: ${account2.getBalance}")
  }
}
