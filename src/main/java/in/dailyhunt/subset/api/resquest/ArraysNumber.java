package in.dailyhunt.subset.api.resquest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArraysNumber {

    private int[] numbers;

    @JsonProperty
    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}
