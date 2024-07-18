import java.util.ArrayList;
import java.util.List;

class Test{

    static int maxLen = 0;
    public static void helper(int col, int currLen, List<Integer> ds, List<List<Integer>> matrix){
        maxLen = Math.max(currLen,maxLen);
        if (col == matrix.get(0).size()){
            return;
        }

        for (int i=0; i<matrix.size(); i++){
            if (ds.size()==0 || matrix.get(i).get(col)>=ds.get(ds.size()-1)){
                ds.add(matrix.get(i).get(col));
                helper(col+1, currLen+1, ds, matrix);
                ds.remove(ds.size()-1);
                helper(col+1, currLen, ds, matrix);
            }else{
                helper(col+1, currLen, ds, matrix);
            }
        }
    }
    
    public static int solution(List<List<Integer>> matrix){
        List<Integer> ds = new ArrayList<>();
        helper(0, 0, ds, matrix);
        return maxLen;
    }


}
