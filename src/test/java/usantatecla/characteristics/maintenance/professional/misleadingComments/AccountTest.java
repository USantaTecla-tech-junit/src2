package usantatecla.characteristics.maintenance.professional.misleadingComments;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AccountTest {

	@Test
	public void pastDueDateDebtFlagsAccountNotInGoodStanding() {
		// create a basic account
		Customer customer = new Customer();
		DeliquencyPlan deliquencyPlan = DeliquencyPlan.MONTHLY;
		Account account = new CorporateAccount(customer, deliquencyPlan);
		
		// register a debt that has a due date in the future
		Money amount = new Money("EUR", 1000);
		account.add(new Liability(customer, amount, Time.fromNow(1, Time.DAYS)));
		
		// account should still be in good standing
		assertTrue(account.inGoodStanding());
		
		// fast-forward past the due date
		Time.moveForward(1, Time.DAYS);
		
		// account shouldn't be in good standing anymore
		assertFalse(account.inGoodStanding());
	}
}
