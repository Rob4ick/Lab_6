package common;

import java.io.Serializable;

public class Response implements Serializable {

    private String answer = null;

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return getAnswer();
    }
}