class Account(var balance: Double) {
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
    } else {
      println("Invalid deposit amount.")
    }
  }
  
  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
    } else {
      println("Invalid withdrawal amount or insufficient balance.")
    }
  }

  override def toString: String = s"Account balance: $balance"
}

class Bank(var accounts: List[Account]) {
  def accountsWithNegativeBalances: List[Account] = {
    accounts.filter(account => account.balance < 0)
  }
  
  def calculateTotalBalance: Double = {
    accounts.map(_.balance).sum
  }
  
  def applyInterest(): Unit = {
    accounts.foreach(account => {
      if (account.balance > 0) {
        account.deposit(account.balance * 0.05)
      } else {
        account.withdraw(account.balance * -0.1)
      }
    })
  }

  override def toString: String = s"Bank with ${accounts.length} accounts."
}

object BankTest {
  def main(args: Array[String]): Unit = {
    val account1 = new Account(1000.0)
    val account2 = new Account(-500.0)
    val account3 = new Account(200.0)
    
    val bank = new Bank(List(account1, account2, account3))
    
    println("Accounts with negative balances:")
    bank.accountsWithNegativeBalances.foreach(account => println(account))
    
    val totalBalance = bank.calculateTotalBalance
    println(s"Total balance of all accounts: $totalBalance")
    
    bank.applyInterest()
    println("Balances after applying interest:")
    bank.accounts.foreach(account => println(account))
  }
}
