package backAlgo;

/**
 * Created by Rain on 2019/6/5.
 */
public class _01Bag {
    static int maxWeight = Integer.MIN_VALUE;//存储背包中，物品总重量的最大值
    static int itemsNum=5;//物品数量
    static int[] items={2,2,4,6,3};//物品的重量
    static int canWeight=10;//背包能装的最大重量

    /**
     * 回溯算法解决01背包问题
     * @param index
     * @param hasWeight
     */
    private static void solve(int index,int hasWeight){
        if (index==itemsNum || canWeight==hasWeight){
            if (hasWeight>maxWeight) maxWeight=hasWeight;
            return;
        }
        //不将物品装进背包
        solve(index+1,hasWeight);
        // 将物品装进背包
        if (hasWeight+items[index]<=canWeight){
            solve(index+1,hasWeight+items[index]);
        }
    }

    /**
     * 用回溯算法处理01背包问题
     *
     * @param containWeight  背包中已容纳的重量
     * @param index          当前考察到的物品index
     * @param items          物品的集合
     * @param itemsNum       物品的总数量
     * @param capacityWeight 背包可容纳的最大重量
     */
    private static void func(int containWeight, int index, int[] items, int itemsNum, int capacityWeight) {
        if (index == itemsNum || containWeight == capacityWeight) {
            maxWeight = Math.max(containWeight, maxWeight);
            return;
        }
        // 当前物品不装进背包
        func(containWeight, index + 1, items, itemsNum, capacityWeight);
        if (containWeight + items[index] <= capacityWeight) {
            // 当前物品装进背包
            func(containWeight + items[index], index + 1, items, itemsNum, capacityWeight);
        }
    }

    public static void getMaxWeight(int[] items,int itemsNum,int capacityWeight){
        maxWeight=0;
        func(0,0,items,itemsNum,capacityWeight);
    }

    public static void main(String[] args){
//        int[] items={2,7,5,3,6,10};
//        getMaxWeight(items,items.length,30);
//        System.out.println(maxWeight);
        solve(0,0);
        System.out.println(maxWeight);
    }

}
