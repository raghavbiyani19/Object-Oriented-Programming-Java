package score;
import java.io.Serializable;
class CricketScore implements Serializable {
    private static final long serialVersionUID = 3239862181466615111L;
    int score, wickets;
    double overs;
    CricketScore() {
        score = 0;
        wickets = 0;
        overs = 0;
    }

    CricketScore(int sc, int w, double o) {
        score = sc;
        wickets = w;
        overs = o;
    }

    int getScore() {
        return score;
    }

    int getWickets() {
        return wickets;
    }
    double getOvers() {
        return overs;
    }
}

