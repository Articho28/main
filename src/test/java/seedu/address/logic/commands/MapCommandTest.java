package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import guitests.guihandles.BrowserPanelHandle;
import org.junit.Before;
import org.junit.Test;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.UndoRedoStack;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.ui.BrowserPanel;


public class MapCommandTest {

    public MapCommand mapCommand;
    private Model model;
    private Model expectedModel;
    public BrowserPanel browserPanel;
    public BrowserPanelHandle browserPanelHandle;

    @Before
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());

        mapCommand = new MapCommand();
        mapCommand.setData(model, new CommandHistory(), new UndoRedoStack());
        
    }

    @Test
    public void executes_mapCommandRecognized() {
        assertCommandSuccess(mapCommand, model, MapCommand.MESSAGE_SUCCESS, expectedModel);
    }


}
