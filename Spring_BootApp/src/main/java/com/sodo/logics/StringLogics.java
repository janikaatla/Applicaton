package com.sodo.logics;

public class StringLogics {
    public static void main(String[] arg) {
        StringLogics stringLogics = new StringLogics();
        /*String input="Janaiah Janaiah";
        String res=stringLogics.getSeconddiffchar(input);
        if (!res.isEmpty()) {
            System.out.println("Restult : "+res);
        } else
            System.err.println("No Second diff value in the string : ");*/
        int[] inputArray={1,3,2,5,4};
        int[] ascres = stringLogics.ascOrdertheArray(inputArray);
        int[] descres = stringLogics.descOrdertheArray(inputArray);
        System.out.print("Result ASC order : ");
        for (int i=0;i<ascres.length;i++)
            System.out.print(ascres[i]+"\t");
        System.out.println("");
        System.out.print("Result Desc order : ");
        for (int i=0;i<descres.length;i++)
            System.out.print(descres[i]+"\t");
    }

    public String getSeconddiffchar(String str) {
        String res = "";
        String difValue = "";
        String duplicateValue = "";
        if (str != null) {
            String val;
            for (int i = 0; i < str.length(); i++) {
                 val = ""+str.charAt(i);
                int lastIndex = str.lastIndexOf(val);
                if (lastIndex == i) {
                    if (!duplicateValue.contains(val)) {
                        difValue = difValue+val;
                    }
                } else {
                    duplicateValue = duplicateValue +val;
                }
            }
            if (difValue.length()>1) {
                res = ""+difValue.charAt(1);
            }
        }
        return res;
    }

    public int[] ascOrdertheArray(int[] intArra) {
        int[] res=new int[intArra.length];
        for (int i=0;i<intArra.length;i++) {
            res[i]=intArra[i];
        }
        int swap;
        for (int i=0;i<res.length-1;i++) {
            for (int j=i+1;j<res.length;j++) {
                if (res[i]>res[j]) {
                    res[i]=res[i]+res[j];
                    res[j]=res[i] - res[j];
                    res[i] = res[i] - res[j];
                    //swap(res[j], res[i]);
                    /*swap = res[i];
                    res[i]=res[j];
                    res[j]=swap;*/
                }
            }
        }
        return res;
    }

    public int[] descOrdertheArray(int[] intArra) {
        int[] res=new int[intArra.length];
        for (int i=0;i<intArra.length;i++) {
            res[i]=intArra[i];
        }
        int swap;
        for (int i=0;i<res.length-1;i++) {
            for (int j=i+1;j<res.length;j++) {
                if (res[j]>res[i]) {
                    //swap(res[j], res[i]);
                    res[i]=res[i]+res[j];
                    res[j]=res[i] - res[j];
                    res[i] = res[i] - res[j];
                    /*swap = res[i];
                    res[i]=res[j];
                    res[j]=swap;*/
                }
            }
        }
        return res;
    }

    public byte[] getReverseString(String input) {
        byte[] strAsByteArray = input.getBytes();

        byte[] result = new byte[strAsByteArray.length];

        // Store result in reverse order into the
        // result byte[]
        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];

        System.out.println(new String(result));
        return result;
    }

    public void febonacciseries(int[] input){
        // 1,1,2,3,5,8,13
    }



    public void swap(int xp, int yp)
    {
        if (xp == yp) // Check if the two addresses are same
            return;
        xp = xp + yp;
        yp = xp - yp;
        xp = xp - yp;
    }
}
