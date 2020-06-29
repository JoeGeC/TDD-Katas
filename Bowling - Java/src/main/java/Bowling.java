public class Bowling {
    private int turnNumber = 0;
    private String rolls;

    public Bowling(String rolls) { this.rolls = rolls.replaceAll("\\s+", ""); }

    public int totalScore() {
        int result = 0;
        for(int rollIndex = 0; rollIndex < rolls.length(); rollIndex++){
            if(notMissed(rollIndex) && turnNumber < 20) result += currentRollScore(rollIndex);
            turnNumber += currentTurnValue(rollIndex);
        }
        return result;
    }
    
    private boolean notMissed(int rollIndex) { return rolls.charAt(rollIndex) != '-'; }

    private int currentRollScore(int rollIndex) {
        if(isSpare(rollIndex)) { return currentSpareScore(rollIndex) + rollScore(rollIndex + 1); }
        if(isStrike(rollIndex)) { return 10 + nextTwoRollScores(rollIndex); }
        return Character.getNumericValue(rolls.charAt(rollIndex));
    }

    private boolean isSpare(int rollIndex) { return rolls.charAt(rollIndex) == '/'; }

    private int currentSpareScore(int rollIndex) { return 10 - Character.getNumericValue(rolls.charAt(rollIndex - 1)); }

    private int rollScore(int rollIndex) {
        if(rolls.charAt(rollIndex) == 'X') return 10;
        return Character.getNumericValue(rolls.charAt(rollIndex));
    }

    private boolean isStrike(int rollIndex) { return rolls.charAt(rollIndex) == 'X'; }

    private int nextTwoRollScores(int rollIndex) { return rollScore(rollIndex + 1) + rollScore(rollIndex + 2); }

    private int currentTurnValue(int rollIndex) {
        if (isStrike(rollIndex)) return 2;
        return 1;
    }
}
