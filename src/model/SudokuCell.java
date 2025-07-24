package model;

import java.util.HashSet;
import java.util.Set;

public class SudokuCell {
  private Integer fixedValue = null;
  private Integer playerValue = null;
  private Set<Integer> drafts = new HashSet<>();

  public boolean isEditable() {
    return fixedValue == null;
  }

  public Integer getFixedValue() {
    return fixedValue;
  }

  public Integer getPlayerValue() {
    return playerValue;
  }

  public Set<Integer> getDrafts() {
    return drafts;
  }

  public void setFixedValue(int value) {
    this.fixedValue = value;
  }

  public boolean setPlayerValue(int value) {
    if (isEditable()) {
      this.playerValue = value;
      return true;
    }
    return false;
  }

  public boolean removePlayerValue() {
    if (isEditable()) {
      this.playerValue = null;
      return true;
    }
    return false;
  }

  public void addDraft(int value) {
    if (isEditable()) {
      drafts.add(value);
    }
  }

  public void clearDrafts() {
    drafts.clear();
  }
}
