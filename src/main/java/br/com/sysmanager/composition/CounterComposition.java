package br.com.sysmanager.composition;

import java.util.Arrays;

public class CounterComposition {

    public CounterComposition() {
    }

    public int countNumbers(int[] arr, int lessThan){
        Arrays.sort(arr);
        int[] arrayLessThan = Arrays.stream(arr).filter(i -> i < lessThan).toArray();
        return arrayLessThan.length;
    }
}
