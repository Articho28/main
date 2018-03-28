package seedu.address.commons.events.ui;

import seedu.address.commons.events.BaseEvent;

public class ShowMapRequestEvent extends BaseEvent {

    public String toString() {
        return this.getClass().getSimpleName();
    }
}
