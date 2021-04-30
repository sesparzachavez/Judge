public class Judge {
    public static void main(String[] args){
    Judge judge = new Judge();

    int test0[][] = {{1, 2}};
    int test1[][] = {{1, 3}, {2, 3}};
    int test2[][] = {{1, 3}, {2, 3}, {3, 1}};
    int test3[][] = {{1, 2}, {2, 3}};
    int test4[][] = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};

    System.out.println("Test 0: "+judge.findJudge(2,test0));
    System.out.println("Test 1: "+judge.findJudge(3,test1));
    System.out.println("Test 2: "+judge.findJudge(3,test2));
    System.out.println("Test 3: "+judge.findJudge(3,test3));
    System.out.println("test 4: "+judge.findJudge(4,test4));

    }

    public int findJudge(int N,int [][] trust){

        //create two arrays
        //one for the people that trust the judge
        //one for possuble judge
        int[] trusted = new int[N+1];
        int[] trusts = new int[N+1];

        //traverse through town
        //keeping track of who trusts who 
        for (int i = 0; i < trust.length; i++) {
            trusted[trust[i][1]]++;
            trusts[trust[i][0]]++;
        }

        //in the end, the people will be be connected to judge
        //if the judge exists in the group he will have all people trusted to him
        //and he will have 0 people he trusts
        for (int i = 1; i <= N; i++) {
            if (trusted[i] == N - 1 && trusts[i] == 0) {
                return i;
            }
        }
        //if there is no judge in the group then return -1
        return -1;
    }
}
