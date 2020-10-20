package com.sodo.logics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Matrix_Code {
    static int allunique=2;
    static int allsame=3;
    static int twocolsame=1;
    public static void main(String arg[]) {
        try {

            String[] inputColors = {"grey","grey","grey", "blue","blue","blue","orange","orange","orange"};
            String[] inputValues = {"*","*","*", "c","c","c","s","s","s"};


            System.out.println(" Input colours order ");
            for (int i=0;i<9;i++) {
                if (i<3) {
                    System.out.print(inputColors[i] + " ");
                }
                if(i==3) {
                    System.out.println(" ");
                }
                if(i>2 && i<6) {
                    System.out.print(inputColors[i] + " ");
                }
                if(i==6) {
                    System.out.println(" ");
                }
                if(i>5 && i<9) {
                    System.out.print(inputColors[i] + " ");
                }
            }
            System.out.println("");
            System.out.println(" Input Value order ");
            for (int i=0;i<9;i++) {
                if (i<3) {
                    System.out.print(inputValues[i] + " ");

                }
                if(i==3) {
                    System.out.println(" ");
                }
                if(i>2 && i<6) {
                    System.out.print(inputValues[i] + " ");
                }
                if(i==6) {
                    System.out.println(" ");
                }
                if(i>5 && i<9) {
                    System.out.print(inputValues[i] + " ");
                }
            }
            System.out.println(" ");

            Map<String, Integer> map=new HashMap<>();

            int[][] posibleIndexOrderList= {{0,1,2},{0,3,6},{0,4,8},{1,4,7},{2,4,6},{2,5,8},{3,4,5},{6,7,8}};

            List<Integer> combinationofValids= getValidateNo(getCombinationResult(posibleIndexOrderList,map,inputValues,inputColors));


            // Results
            double finalResult=1l;
            int sumResult=0;
            int noofValids=combinationofValids.size();
            System.out.print("no of Valids : "+noofValids);
            noofValids=noofValids-1;
            System.out.print("\n");
            System.out.print("valid results : (");
            for (int i=0;i<=noofValids;i++ ) {
                if (i ==noofValids) {
                    System.out.print(combinationofValids.get(i));
                } else {
                    System.out.print(combinationofValids.get(i) + " + ");
                }
                sumResult=sumResult+combinationofValids.get(i);

            }
            System.out.print(") ="+ sumResult);
            System.out.println();

            for (int i=0;i<noofValids;i++ ) {
                finalResult=finalResult*Double.valueOf(sumResult);
            }
            if (sumResult !=0) {
                System.out.println("("+sumResult+")*"+(noofValids-1)+" = "+ finalResult);
            } else {
                System.out.println("No Valid Results : ");
            }


        } catch (Exception e) {

        }

    }

    public static Map<String, Integer> getCombinationResult(int[][] posibleIndexOrderList, Map<String, Integer> map, String[] inputValues, String[] inputColors ) {
        String[] allcolors={"grey","blue","orange"};
        for (int[] indexOrder: posibleIndexOrderList) {
            String possition=""+indexOrder[0]+indexOrder[1]+indexOrder[2];
            System.out.println("possition : "+possition);
            String[] colorOrder=new String[3];
            if (inputValues[indexOrder[0]].equals("*")) {
                for (int j=0;j<3;j++) {
                    colorOrder[0] =allcolors[j];
                    if (inputValues[indexOrder[1]].equals("*")) {
                        for (int k=0;k<3;k++) {
                            colorOrder[1] =allcolors[k];
                            if (inputValues[indexOrder[2]].equals("*")) {
                                for (int l=0;l<3;l++) {
                                    colorOrder[2] =allcolors[l];
                                    String[][] valueOrderList = {{"m","c","s"},{"s","c","m"}};
                                    for (String[] valueOrder: valueOrderList) {
                                        map = getValidPossition(map,possition,valueOrder,colorOrder);
                                    }
                                }
                            } else if(inputValues[indexOrder[2]].equals("s")) {
                                colorOrder[2] =inputColors[indexOrder[2]];
                                String[] valueOrder= {"m","c","s"};
                                map = getValidPossition(map,possition,valueOrder,colorOrder);
                            } else if(inputValues[indexOrder[2]].equals("m")) {
                                colorOrder[2] =inputColors[indexOrder[2]];
                                String[] valueOrder= {"s","c","m"};
                                map = getValidPossition(map,possition,valueOrder,colorOrder);
                            } else {
                                continue;
                            }
                        }
                    } else if(inputValues[indexOrder[1]].equals("c")) {
                        colorOrder[1] =inputColors[indexOrder[1]];
                        if (inputValues[indexOrder[2]].equals("*")) {
                            for (int l=0;l<3;l++) {
                                colorOrder[2] =allcolors[l];
                                String[][] valueOrderList = {{"m","c","s"},{"s","c","m"}};
                                for (String[] valueOrder: valueOrderList) {
                                    map = getValidPossition(map,possition,valueOrder,colorOrder);
                                }
                            }
                        } else if(inputValues[indexOrder[2]].equals("s")) {
                            colorOrder[2] =inputColors[indexOrder[2]];
                            String[] valueOrder= {"m","c","s"};
                            map = getValidPossition(map,possition,valueOrder,colorOrder);
                        } else if(inputValues[indexOrder[2]].equals("m")) {
                            String[] valueOrder= {"s","c","m"};
                            colorOrder[2] =inputColors[indexOrder[2]];
                            map = getValidPossition(map,possition,valueOrder,colorOrder);
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            } else if (inputValues[indexOrder[0]].equals("m")) {
                colorOrder[0] =inputColors[indexOrder[0]];
                if (inputValues[indexOrder[1]].equals("*")) {
                    for (int k=0;k<3;k++) {
                        colorOrder[1] =allcolors[k];
                        if (inputValues[indexOrder[2]].equals("*")) {
                            for (int l=0;l<3;l++) {
                                colorOrder[2] =allcolors[l];
                                String[] valueOrder= {"m","c","s"};
                                map = getValidPossition(map,possition,valueOrder,colorOrder);
                            }
                        } else if(inputValues[indexOrder[2]].equals("s")) {
                            colorOrder[2] =inputColors[indexOrder[2]];
                            String[] valueOrder= {"m","c","s"};
                            map = getValidPossition(map,possition,valueOrder,colorOrder);
                        } else {
                            continue;
                        }
                    }
                } else if(inputValues[indexOrder[1]].equals("c")) {
                    colorOrder[1] =inputColors[indexOrder[1]];
                    if (inputValues[indexOrder[2]].equals("*")) {
                        for (int l=0;l<3;l++) {
                            colorOrder[2] =allcolors[l];
                            String[] valueOrder= {"m","c","s"};
                            map = getValidPossition(map,possition,valueOrder,colorOrder);
                        }
                    } else if(inputValues[indexOrder[2]].equals("s")) {
                        colorOrder[2] =inputColors[indexOrder[2]];
                        String[] valueOrder= {"m","c","s"};
                        map = getValidPossition(map,possition,valueOrder,colorOrder);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            } else if (inputValues[indexOrder[0]].equals("s")) {
                if (inputValues[indexOrder[1]].equals("*")) {
                    for (int k=0;k<3;k++) {
                        colorOrder[1] =allcolors[k];
                        if (inputValues[indexOrder[2]].equals("*")) {
                            for (int l=0;l<3;l++) {
                                colorOrder[2] =allcolors[l];
                                String[] valueOrder= {"s","c","m"};
                                map = getValidPossition(map,possition,valueOrder,colorOrder);
                            }
                        } else if(inputValues[indexOrder[2]].equals("m")) {
                            colorOrder[2] =inputColors[indexOrder[2]];
                            String[] valueOrder= {"s","c","m"};
                            map = getValidPossition(map,possition,valueOrder,colorOrder);
                        } else {
                            continue;
                        }
                    }
                } else if(inputValues[indexOrder[1]].equals("c")) {
                    colorOrder[1] =inputColors[indexOrder[1]];
                    if (inputValues[indexOrder[2]].equals("*")) {
                        for (int l=0;l<3;l++) {
                            colorOrder[2] =allcolors[l];
                            String[] valueOrder = {"s","c","m"};
                            map = getValidPossition(map,possition,valueOrder,colorOrder);
                        }
                    } else if(inputValues[indexOrder[2]].equals("m")) {
                        String[] valueOrder= {"s","c","m"};
                        colorOrder[2] =inputColors[indexOrder[2]];
                        map = getValidPossition(map,possition,valueOrder,colorOrder);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return map;
    }

    public static List<Integer> getValidateNo(Map<String, Integer> map) {
        List<Integer> list=new ArrayList<>();
        for (Map.Entry<String,Integer> entry: map.entrySet()){
            list.add(entry.getValue());
        }
        return list;

    }

    public static  Map<String, Integer> getValidPossition(Map<String, Integer> map,String possition, String[] valueOrder, String[] colorOrder) {
        String validKey="";
        validKey=possition+"_"+colorOrder[0]+colorOrder[1]+colorOrder[2]+"_"+valueOrder[0]+valueOrder[1]+valueOrder[2];
        System.out.println("validKey : "+validKey);
        if (colorOrder[0].equals(colorOrder[1]) && colorOrder[1].equals(colorOrder[2])) {
            map.put(validKey, allsame);
        } else if (colorOrder[0].equals(colorOrder[1]) || colorOrder[1].equals(colorOrder[2]) || colorOrder[0].equals(colorOrder[2])) {
            map.put(validKey, twocolsame);
        } else {
            map.put(validKey, allunique);
        }

        return map;
    }

}
