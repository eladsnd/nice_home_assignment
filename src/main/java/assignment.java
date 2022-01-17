import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class assignment {
    /**
     * Get a random integer in range
     * @param min - the min number in the range
     * @param max - the max number in the range
     * @return - a random integer number between min and max (inclusive)
     * */
public static int randomInRange(int min, int max)
{
    return ThreadLocalRandom.current().nextInt(min,max+1);
}

public static void getRandNumRange1(int min,int max) {
    int rand, range = Math.abs(max - min);
    int[] array = new int[range + 1];
    Arrays.setAll(array, i -> min + i );
    for (int i = 0; i < range; i++) {
        rand = randomInRange(0, range - i);
        swap(array, rand, range - i);
    }
    System.out.println(Arrays.toString(array));


//    space(O(n)) Time(O(n))
}

public static void getRandNumRange2(int min,int max) {
    int rand, range = max - min,token = min - 1,out=0;
    int[] array = new int[range + 1];
    Arrays.setAll(array, i -> min + i );
    System.out.print("[");
    for (int i = 0; i < range+1; i++) {
        rand = randomInRange(0, range);
        if (array[rand] < min)
        {
            for (int j = 0; j < range; j++) {
                rand = j;
                if (array[rand]>min)
                    break;
            }
        }
        out = array[rand];
        array[rand] = token;
        if ((i+1)<=range)
            System.out.print(out + ", ");
    }
    System.out.print(out+"]");

    // cons , less random , takes more time O(n^2) , space O(n)
}


private static void swap(int[] array, int rand, int i) {
        int temp = array[i];
        array[i] = array[rand];
        array[rand] = temp;
  }

    public static void main(String[] args)
    {
        getRandNumRange1(3,55);
        getRandNumRange2(3,55);
    }
}
/**
 * BAD OPTION
 *      while we didn't print  , search for it
 * */