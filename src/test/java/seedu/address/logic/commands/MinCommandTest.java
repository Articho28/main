package seedu.address.logic.commands;

import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.Before;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

/**
 * Tests the output of the MinCommand
 */

public class MinCommandTest {

    private Model model;

    @Before
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    /*public Index getIndexOfPersonWithLowestBalance(AddressBook addressBook) {
        List<Person> persons = addressBook.getPersonList();
        int index;
        //double lowestBalance = persons.
        for (Person p : persons) {

        }

    } */



}
