import java.util.ArrayList;
import java.util.List;

public class HackerRank {

    public int getPairOfSocks(int[] socks){
        int pairs=0;
        List<Integer> sockColors=new ArrayList<>();
        for(int i=0;i<socks.length;i++){
            if(sockColors.contains(socks[i])){
                sockColors.remove((Integer)socks[i]);
                pairs++;
            }else{
                sockColors.add(socks[i]);
            }
        }
        return pairs;
    }
}
