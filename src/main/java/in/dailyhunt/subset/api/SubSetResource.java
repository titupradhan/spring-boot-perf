package in.dailyhunt.subset.api;


import in.dailyhunt.subset.api.response.SubSetArray;
import in.dailyhunt.subset.api.resquest.ArraysNumber;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("/sperf")
public class SubSetResource {

    @PostMapping
    @Timed(value = "spsubarray",percentiles = {0.50,0.75,0.95,0.99},histogram = true)
    public Mono<SubSetArray> getSubArray(@RequestBody ArraysNumber arraysNumber) {

        int[][] subsets = getSubsets(arraysNumber.getNumbers());
        SubSetArray subSetArray = new SubSetArray();
        subSetArray.setArrays(subsets);
        return Mono.just(subSetArray);
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
