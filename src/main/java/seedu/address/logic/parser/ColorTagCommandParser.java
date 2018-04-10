package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COLOR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.ParserUtil.isValidColor;
import static seedu.address.logic.parser.ParserUtil.parseTags;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.ColorTagCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.Tag;

public class ColorTagCommandParser implements Parser<ColorTagCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ColorCommand
     * and returns an RemoveTagCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */

    public ColorTagCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_COLOR, PREFIX_TAG);
        if (!argMultimap.getValue(PREFIX_COLOR).isPresent()) {
            throw new ParseException("Please include a color with the prefix c/ \n"
                    + "EXAMPLE: colortag c/red t/friends");
        }
        String color;
        Set<Tag> tagsToColor;
        color = argMultimap.getAllValues(PREFIX_COLOR).get(0);
        if (!isValidColor(color)) throw new ParseException("Please choose among the supported colors.");
        try {
            tagsToColor = parseTags(argMultimap.getAllValues(PREFIX_TAG));
        } catch (IllegalValueException ive) {
            throw new ParseException(ive.getMessage(), ive);
        }
        return new ColorTagCommand(color, tagsToColor);
    }

    private Optional<Set<Tag>> parseTagsForColor(Collection<String> tags) throws IllegalValueException {
        assert tags != null;

        if (tags.isEmpty()) {
            return Optional.empty();
        }
        Collection<String> tagSet = tags.size() == 1 && tags.contains("") ? Collections.emptySet() : tags;
        return Optional.of(parseTags(tagSet));
    }
}
