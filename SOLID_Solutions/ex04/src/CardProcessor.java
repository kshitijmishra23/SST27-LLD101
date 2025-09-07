class CardProcessor implements PaymentProcessor { public String providerName(){ return "CARD"; } public String pay(Payment p){ return "Charged card: " + p.amount; } }
