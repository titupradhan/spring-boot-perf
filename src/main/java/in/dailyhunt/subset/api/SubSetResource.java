package in.dailyhunt.subset.api;


import in.dailyhunt.subset.api.response.SubSetArray;
import in.dailyhunt.subset.api.resquest.ArraysNumber;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/subsets")
public class SubSetResource {

    @PostMapping
    public SubSetArray getSubArray(@RequestBody ArraysNumber arraysNumber) {
        SubSetArray subSetArray = new SubSetArray();
        int[][] subsets = getSubsets(arraysNumber.getNumbers());
        subSetArray.setArrays(subsets);
        return subSetArray;
    }

    private int[][] getSubsets(int numbers[]) {
        final int n = numbers.length;
        final int pow = 1 << n;
        final int[][] array1 = new int[pow][];
        for (int i = 0; i < pow; i++) {
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    a[j] = numbers[j];

                }
            }
            array1[i] = a;
        }
        return array1;
    }

}
