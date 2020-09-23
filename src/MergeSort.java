import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSort {

    public List<Integer> sort(List<Integer> xs) {
        int n = xs.size() / 2;
        if (n == 0) return xs;
        else {
            List<Integer> fst = xs.subList(0, n);
            List<Integer> snd = xs.subList(n, xs.size());
            return merge(sort(fst), sort(snd));
        }
    }

    private List<Integer> merge(List<Integer> xs, List<Integer> ys) {
        if(xs.isEmpty()) return ys;
        else if(ys.isEmpty()) return xs;
        else if(xs.get(0)<ys.get(0)) return Stream.concat(Stream.of(xs.get(0)),merge(xs.subList(1,xs.size()),ys).stream()).collect(Collectors.toList());
        else return Stream.concat(Stream.of(ys.get(0)),merge(xs,ys.subList(1,ys.size())).stream()).collect(Collectors.toList());
    }
}
