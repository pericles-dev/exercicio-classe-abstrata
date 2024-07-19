package entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;

	public Individual() {
		super();
	}

	public Individual(String name, Double annualIncome, Double healthExpenditures) {
		super(name, annualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double calculateTax() {
		Double tax = 0.0;
		if (getAnnualIncome() < 20000.00) {
			tax = getAnnualIncome() - (getAnnualIncome() - 0.15);
		} else if (getAnnualIncome() > 20000.00 && getHealthExpenditures() == 0) {
			tax = getAnnualIncome() - getAnnualIncome() - 0.25;
		} else if (getHealthExpenditures() > 0.00) {
			tax = getAnnualIncome() * 0.25 - getHealthExpenditures() * 0.5;
		}
		return tax;
	}
}
