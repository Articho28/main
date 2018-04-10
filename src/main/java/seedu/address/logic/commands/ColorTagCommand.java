package seedu.address.logic.commands;

import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.List;
import java.util.Set;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

public class ColorTagCommand extends UndoableCommand {

    public static final String COMMAND_WORD = "colortag";
    public static final String COMMAND_WORD_SHORTCUT = "ct";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Changes the color of the specific tags identified "
            + "COLOR (must be one of the following: RED, YELLOW, ORANGE, WHITE, BLUE, GREEN, PINK, BLACK, GREY"
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD
            + "red"
            + PREFIX_TAG + "owesMoney "
            + PREFIX_TAG + "friends";

    public static final String MESSAGE_COLOR_TAG_SUCCESS = "Color Tags for Person: %1$s";
    public static final String MESSAGE_TAG_NOT_EXIST = "Your Input Contains Non-existent Tag(s)!";

    private final String color;
    private final Set<Tag> tagsToColor;

    private Person toEdit;
    private boolean changed = false;

    private static final String[] TAG_COLOR =
            {"red", "yellow", "orange", "white", "blue", "green", "pink", "black", "grey"};

    /**
     * This returns a ColorTagCommand that is ready to be executed.
     *
     * @param color to display the new tags in
     * @param tags  that need to be colored
     */
    public ColorTagCommand(String color, Set<Tag> tags) {
        this.color = color;
        this.tagsToColor = tags;
    }
    //Method attempts to change the color of all tags to a specified color.
    @Override
    public CommandResult executeUndoableCommand() throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();
        for (Person person : lastShownList) {
           for (Tag tag : person.getTags()) {
               if (tagsToColor.contains(tag)) {
                   changed = true;
               }
           }
        }
        if (changed) {
            return new CommandResult("Tags Changed.");
        } else {
            changed = false;
            return new CommandResult("No tags found");
        }
    }

    public String getTagColor(String tagName) {
        return TAG_COLOR[Math.abs(tagName.hashCode()) % TAG_COLOR.length];
    }

}






