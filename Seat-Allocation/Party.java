
public class Party implements Comparable<Party> {
    
    private int id;
    private int votes;
    private int seats;

    public Party(int votes, int id) {
        
        this.id = id;
        this.votes = votes;
        this.seats = 0;
    }

    public int getSeats() {
        return seats;
    }

    public int getVotes() {
        return votes;
    }

    public void addSeat() {
        seats++;
    }

    public int getId() {
        return id;
    }

    

    public int compareTo(Party other) {

        double quotientCalc1 = (double) this.votes / (this.seats + 1);
        double quotientCalc2 = (double) other.votes / (other.seats + 1);

        if (quotientCalc1 > quotientCalc2) {
            return -1;
        }
        else if (quotientCalc1 < quotientCalc2) {
            return 1;
        }
        else {
            return 0;
        }

    }
}

