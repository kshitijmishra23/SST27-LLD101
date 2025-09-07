class UpiProcessor implements PaymentProcessor { public String providerName(){ return "UPI"; } public String pay(Payment p){ return "Paid via UPI: " + p.amount; } }
