package com.wcmei.datastructure;

/**
 * @author wcmei
 * @date 2020-01-09
 * @description
 */
//稀疏数组
public class SparseArray {
    public static void main(String[] args) {
        //原数组
        int[][] ints = new int[11][11];
        ints[1][2] = 1;
        ints[2][3] = 2;
        //稀疏数组
        int[][] sparse = new int[getHasValueCount(ints) + 1][3];
        //行
        sparse[0][0] = ints.length;
        //列
        sparse[0][1] = ints[0].length;
        //总有效数
        sparse[0][2] = getHasValueCount(ints);
        int row = 1;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                if (ints[i][j] != 0) {
                    sparse[row][0] = i;
                    sparse[row][1] = j;
                    sparse[row][2] = ints[i][j];
                    row++;
                }
            }
        }
        for (int[] a : sparse) {
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println();
        }
    }

    //数组当中有效数据的个数
    public static int getHasValueCount(int[][] ints) {
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                if (ints[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
