package smp.components.staff.sequences;

import java.util.ArrayList;

/**
 * A line of notes on the staff. This can include
 * notes, bookmarks, etc.
 * @author RehdBlob
 *
 */
public class StaffNoteLine {

    /**
     * The line number of this StaffNoteLine. For a standard 96-measure 4/4
     * song, this number is between 0 and 383.
     */
    private int lineNum;

    /**
     * This ArrayList holds staff notes inside it.
     */
    private ArrayList<StaffNote> notes;

    /**
     * This ArrayList holds staff events in it.
     */
    private ArrayList<StaffEvent> marks;

    /**
     * Creates a new staff note line.
     */
    public StaffNoteLine() {
        notes = new ArrayList<StaffNote>();
        marks = new ArrayList<StaffEvent>();
    }

    /**
     * Creates a new staff note line with the specified
     * line number.
     * @param num The line number identifier of this staff note line.
     */
    public StaffNoteLine(int num) {
        lineNum = num;
        notes = new ArrayList<StaffNote>();
        marks = new ArrayList<StaffEvent>();
    }

    /**
     * Adds a note to the staff note line.
     * @param n The note to add to this StaffNoteLine.
     */
    public void add(StaffNote n) {
        notes.add(n);
    }

    /**
     * Adds an event to this staff note line.
     * @param e The event that we are trying to add.
     */
    public void addEvent(StaffEvent e) {
        marks.add(e);
    }

    /**
     * Deletes a note from the staff.
     * @param n The note to delete.
     * @return True if we successfully removed the note.
     */
    public boolean delete(StaffNote n) {
        return notes.remove(n);
    }

    /**
     * Deletes an event from this staff note line.
     * @param e The event that we are trying to remove.
     * @return True if we successfully removed the event.
     */
    public boolean deleteEvent(StaffEvent e) {
        return marks.remove(e);
    }

    /**
     * @return The line number that this staff event is located at
     */
    public int getLineNum() {
        return lineNum;
    }

    /**
     * Sets the line number to whatever we feed this method.
     * @param num The line number that we want this staff note line to
     * occur at.
     */
    public void setLineNum(int num) {
        lineNum = num;
    }

}