class WalletProcessor implements PaymentProcessor { public String providerName(){ return "WALLET"; } public String pay(Payment p){ return "Wallet debit: " + p.amount; } }
