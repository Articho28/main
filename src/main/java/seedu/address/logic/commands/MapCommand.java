package seedu.address.logic.commands;

import seedu.address.commons.core.EventsCenter;
import seedu.address.commons.events.ui.JumpToListRequestEvent;
import seedu.address.commons.events.ui.ShowMapRequestEvent;
import seedu.address.ui.BrowserPanel;

/**
 * Shows a map and searchs for the nearest ATM.
 */

public class MapCommand extends Command {

    public static final String COMMAND_WORD = "map";
    public static final String COMMAND_SHORTCUT = "mp";
    public static final String MESSAGE_SUCCESS = "Map Shown";

    @Override
    public CommandResult execute() {
        EventsCenter.getInstance().post(new ShowMapRequestEvent());
        return new CommandResult(MESSAGE_SUCCESS);
    }


}
