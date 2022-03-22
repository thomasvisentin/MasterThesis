import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.util.*;

public class Combinations {
  static ArrayList < ArrayList < String >> all_subset = new ArrayList < > ();

  static ArrayList < Map < String, String >> generated_string;

  static void generateString() {
    ArrayList < Map < String, String >> all_generated_string = new ArrayList < Map < String, String >> ();
    String[] FlattenDispatch = {
      "switch",
      "indirect"
    };
    String[] FlattenConditionalKinds = {
      "*"
    };
    String[] FlattenOpaqueStructs = {
      "list"
    };
    String[] Booleans = {
      "true",
      "false"
    };
    HashMap < String, String > flatten = new HashMap < > ();
    String command_Flatten =
      //"tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n" +
      "   --Transform=InitEntropy --Functions=main \\\n" +
      "   --Transform=InitImplicitFlow --Functions=main \\\n" +
      "      --InitImplicitFlowHandlerCount=1 \\\n" +
      "   --Transform=Flatten \\\n" +
      "      --FlattenDumpBlocks=%s \\\n" +
      "      --FlattenSplitBasicBlocks=%s \\\n" +
      "      --FlattenRandomizeBlocks=%s \\\n" +
      "      --FlattenDispatch=%s \\\n" +
      "      --FlattenObfuscateNext=%s \\\n" +
      "      --FlattenOpaqueStructs=%s \\\n" +
      "      --FlattenImplicitFlowNext=%s \\\n" +
      "      --FlattenConditionalKinds=%s \\\n" +
      "      --Functions=quicksort,stampa_array,insert_array \\\n";
    //"      --out=quicksort_%s.c quicksort.c\n";
    for (int flattenDumpBlocks = 0; flattenDumpBlocks < Booleans.length; flattenDumpBlocks++) {
      for (int flattenSplitBasicBlocks = 0; flattenSplitBasicBlocks < Booleans.length; flattenSplitBasicBlocks++) {
        for (int flattenRandomizeBlocks = 0; flattenRandomizeBlocks < Booleans.length; flattenRandomizeBlocks++) {
          for (int flattenDispatch = 0; flattenDispatch < FlattenDispatch.length; flattenDispatch++) {
            for (int flattenObfuscateNext = 0; flattenObfuscateNext < Booleans.length; flattenObfuscateNext++) {
              for (int flattenOpaqueStructs = 0; flattenOpaqueStructs < FlattenOpaqueStructs.length; flattenOpaqueStructs++) {
                for (int flattenImplicitFlowNext = 0; flattenImplicitFlowNext < Booleans.length; flattenImplicitFlowNext++) {
                  for (int flattenConditionalKinds = 0; flattenConditionalKinds < FlattenConditionalKinds.length; flattenConditionalKinds++) {
                    String output = String.format(command_Flatten, Booleans[flattenDumpBlocks], Booleans[flattenSplitBasicBlocks], Booleans[flattenRandomizeBlocks], FlattenDispatch[flattenDispatch], Booleans[flattenObfuscateNext], FlattenOpaqueStructs[flattenOpaqueStructs], Booleans[flattenImplicitFlowNext], FlattenConditionalKinds[flattenConditionalKinds]);
                    String nome_trasformazione = "Flatten" + "FlattenDumpBlocks" + Booleans[flattenDumpBlocks] + "FlattenSplitBasicBlocks" + Booleans[flattenSplitBasicBlocks] + "FlattenRandomizeBlocks" + Booleans[flattenRandomizeBlocks] + "FlattenDispatch" + FlattenDispatch[flattenDispatch] + "FlattenObfuscateNext" + Booleans[flattenObfuscateNext] + "FlattenOpaqueStructs" + FlattenOpaqueStructs[flattenOpaqueStructs] + "FlattenImplicitFlowNext" + Booleans[flattenImplicitFlowNext] + "FlattenConditionalKinds" + FlattenConditionalKinds[flattenConditionalKinds];

                    flatten.put(nome_trasformazione, output);
                  }
                }
              }
            }
          }
        }
      }
    }
    all_generated_string.add(flatten);

    //System.out.println(command_Flatten);
    HashMap < String, String > split = new HashMap < > ();
    String[] SplitKinds = {
      "deep",
      "recursive",
      "inside"
    };
    String command_Split =
      //"tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n" +
      "   --Transform=Split \\\n" +
      "      --SplitKinds=%s \\\n" +
      "      --SplitCount=100 \\\n" +
      "      --SplitName=split \\\n" +
      "      --SplitLevel=10 \\\n" +
      "      --Functions=quicksort \\\n";

    for (int splitKinds = 0; splitKinds < SplitKinds.length; splitKinds++) {
      String output = String.format(command_Split, SplitKinds[splitKinds]);
      String nome_trasformazione = "Split" + "SplitKinds" + SplitKinds[splitKinds];
      split.put(nome_trasformazione, output);
    }
    all_generated_string.add(split);

    HashMap < String, String > merge = new HashMap < > ();
    String[] MergeConditionalKinds = {
      "branch",
      "compute"
    };
    String[] MergeFlattenDispatch = {
      "switch",
      "goto"
    };
    String[] MergeOpaqueStructs = {
      "list",
      "array"
    };
    String command_Merge =
      //"tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n" +
      "   --Transform=Merge \\\n" +
      "      --MergeName=merged \\\n" +
      "      --MergeObfuscateSelect=%s \\\n" +
      "      --MergeOpaqueStructs=%s \\\n" +
      "      --MergeFlatten=%s \\\n" +
      "      --MergeFlattenDispatch=%s \\\n" +
      "      --MergeSplitBasicBlocks=%s \\\n" +
      "      --MergeRandomizeBlocks=%s \\\n" +
      "      --MergeConditionalKinds=%s \\\n" +
      "      --Functions=quicksort,insert_array \\\n";
    String command_Merge_2 =
      //"tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n" +
      "   --Transform=Merge \\\n" +
      "      --MergeName=merged \\\n" +
      "      --MergeObfuscateSelect=%s \\\n" +
      "      --MergeOpaqueStructs=%s \\\n" +
      "      --MergeFlatten=%s \\\n" +
      "      --MergeSplitBasicBlocks=%s \\\n" +
      "      --MergeRandomizeBlocks=%s \\\n" +
      "      --MergeConditionalKinds=%s \\\n" +
      "      --Functions=quicksort,insert_array \\\n";
    for (int mergeObfuscateSelect = 0; mergeObfuscateSelect < Booleans.length; mergeObfuscateSelect++) {
      for (int mergeOpaqueStructs = 0; mergeOpaqueStructs < MergeOpaqueStructs.length; mergeOpaqueStructs++) {
        for (int mergeFlatten = 0; mergeFlatten < Booleans.length; mergeFlatten++) {
          for (int mergeFlattenDispatch = 0; mergeFlattenDispatch < MergeFlattenDispatch.length; mergeFlattenDispatch++) {
            for (int mergeSplitBasicBlocks = 0; mergeSplitBasicBlocks < Booleans.length; mergeSplitBasicBlocks++) {
              for (int mergeRandomizeBlocks = 0; mergeRandomizeBlocks < Booleans.length; mergeRandomizeBlocks++) {
                for (int mergeConditionalKinds = 0; mergeConditionalKinds < MergeConditionalKinds.length; mergeConditionalKinds++) {
                  String output;
                  if (mergeFlatten == 1) {
                    output = String.format(command_Merge, Booleans[mergeObfuscateSelect], MergeOpaqueStructs[mergeOpaqueStructs], Booleans[mergeFlatten], MergeFlattenDispatch[mergeFlattenDispatch], Booleans[mergeSplitBasicBlocks], Booleans[mergeRandomizeBlocks], MergeConditionalKinds[mergeConditionalKinds]);
                    String nome_trasformazione = "Merge" + "mergeObfuscateSelect" + Booleans[mergeObfuscateSelect] + "mergeOpaqueStructs" + MergeOpaqueStructs[mergeOpaqueStructs] + "mergeFlatten" + Booleans[mergeFlatten] + "mergeFlattenDispatch" + MergeFlattenDispatch[mergeFlattenDispatch] + "mergeSplitBasicBlocks" + Booleans[mergeSplitBasicBlocks] + "mergeRandomizeBlocks" + Booleans[mergeRandomizeBlocks] + "mergeConditionalKinds" + MergeConditionalKinds[mergeConditionalKinds];
                    merge.put(nome_trasformazione, output);
                  } else {
                    output = String.format(command_Merge_2, Booleans[mergeObfuscateSelect], MergeOpaqueStructs[mergeOpaqueStructs], Booleans[mergeFlatten], Booleans[mergeSplitBasicBlocks], Booleans[mergeRandomizeBlocks], MergeConditionalKinds[mergeConditionalKinds]);
                    String nome_trasformazione = "Merge" + "mergeObfuscateSelect" + Booleans[mergeObfuscateSelect] + "mergeOpaqueStructs" + MergeOpaqueStructs[mergeOpaqueStructs] + "mergeFlatten" + Booleans[mergeFlatten] + "mergeSplitBasicBlocks" + Booleans[mergeSplitBasicBlocks] + "mergeRandomizeBlocks" + Booleans[mergeRandomizeBlocks] + "mergeConditionalKinds" + MergeConditionalKinds[mergeConditionalKinds];
                    merge.put(nome_trasformazione, output);
                  }
                }
              }
            }
          }
        }
      }
    }
    all_generated_string.add(merge);
    HashMap < String, String > AddOpaque = new HashMap < > ();
    String[] AddOpaqueCount = {
      "2",
      "4"
    };
    String[] AddOpaqueSplitKinds = {
      "top",
      "recursive",
      "level"
    };
    String[] AddOpaqueStructs = {
      "list",
      "array"
    };
    String command_AddOpaque =
      //"tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n" +
      "   --Transform=AddOpaque \\\n" +
      "      --AddOpaqueKinds=* \\\n" +
      "      --AddOpaqueObfuscate=%s \\\n" +
      "      --AddOpaqueSplitKinds=%s \\\n" +
      "      --AddOpaqueSplitLevel=%s \\\n" +
      "      --AddOpaqueStructs=%s \\\n" +
      "      --Functions=main \\\n";

    for (int addOpaqueObfuscate = 0; addOpaqueObfuscate < Booleans.length; addOpaqueObfuscate++) {
      for (int addOpaqueSplitKinds = 0; addOpaqueSplitKinds < AddOpaqueSplitKinds.length; addOpaqueSplitKinds++) {
        for (int addOpaqueSplitLevel = 0; addOpaqueSplitLevel < AddOpaqueCount.length; addOpaqueSplitLevel++) {
          for (int addOpaqueStructs = 0; addOpaqueStructs < AddOpaqueStructs.length; addOpaqueStructs++) {
            String output = String.format(command_AddOpaque, Booleans[addOpaqueObfuscate], AddOpaqueSplitKinds[addOpaqueSplitKinds], AddOpaqueCount[addOpaqueSplitLevel], AddOpaqueStructs[addOpaqueStructs]);
            String nome_trasformazione = "AddOpequeSplit" + "addOpaqueObfuscate" + Booleans[addOpaqueObfuscate] + "addOpaqueSplitKinds" + AddOpaqueSplitKinds[addOpaqueSplitKinds] + "addOpaqueSplitLevel" + AddOpaqueCount[addOpaqueSplitLevel] + "addOpaqueStructs" + AddOpaqueStructs[addOpaqueStructs];
            AddOpaque.put(nome_trasformazione, output);
          }
        }
      }
    }
    all_generated_string.add(AddOpaque);
    String[] EncodeLiteralsKinds = {
      "integer",
      "string",
      "*"
    };
    String command_EncodeLiterals =
      //"tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n" +
      "   --Transform=EncodeLiterals \\\n" +
      "      --Functions=quicksort,stampa_array,insert_array,main \\\n" +
      "      --EncodeLiteralsKinds=%s \\\n" +
      "      --out=quicksort_%s.c quicksort.c \n";

    for (int encodeLiteralsKinds = 0; encodeLiteralsKinds < EncodeLiteralsKinds.length; encodeLiteralsKinds++) {
      String output = String.format(command_EncodeLiterals, EncodeLiteralsKinds[encodeLiteralsKinds], "fisso");
      //System.out.println(output);
    }

    String[] EncodeDataCodecs = {
      "poly1",
      "xor",
      "add",
      "*"
    };
    String command_EncodeDataCodecs =
      //"tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n" +
      "   --Transform=EncodeData \\\n" +
      "      --LocalVariables='main:n;quicksort:i,j,pivot,temp;stampa_array:i' \\\n" +
      "      --EncodeDataCodecs=%s \\\n" +
      "      --out=quicksort_%s.c quicksort.c \n";
    for (int encodeDataCodecs = 0; encodeDataCodecs < EncodeDataCodecs.length; encodeDataCodecs++) {
      String output = String.format(command_EncodeDataCodecs, EncodeDataCodecs[encodeDataCodecs], "fisso");
      //System.out.println(output);
    }

    String command_EncodeArithmetic =
      //"tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n" +
      "   --Transform=EncodeArithmetic \\\n" +
      "      --EncodeArithmeticKinds=integer \\\n" +
      "      --Functions=quicksort,stampa_array,insert_array,main \\\n" +
      "      --out=quicksort_EncodeArithmetic.c quicksort.c \n";

    //System.out.println(command_EncodeArithmetic);

    String[] AntiBranchAnalysisKinds = {
      "branchFuns",
      "goto2call",
      "goto2push",
      "goto2nopSled",
      "*"
    };
    String[] AntiBranchAnalysisOpaqueStructs = {
      "list",
      "array",
      "list,array"
    };
    String command_AntiBranchAnalysis =
      //"tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n" +
      "   --Transform=InitBranchFuns \\\n" +
      "      --InitBranchFunsCount=2 \\\n" +
      "   --Transform=AntiBranchAnalysis \\\n" +
      "      --AntiBranchAnalysisKinds=%s \\\n" +
      "      --AntiBranchAnalysisOpaqueStructs=%s \\\n" +
      "      --AntiBranchAnalysisObfuscateBranchFunCall=%s \\\n" +
      "      --AntiBranchAnalysisBranchFunFlatten=%s \\\n" +
      "      --AntiBranchAnalysisBranchFunAddressOffset=8 \\\n" +
      "      --Functions=quicksort,stampa_array \\\n" +
      "      --out=quicksort_%s.c quicksort.c \n";

    for (int antiBranchAnalysisKinds = 0; antiBranchAnalysisKinds < AntiBranchAnalysisKinds.length; antiBranchAnalysisKinds++) {
      for (int antiBranchAnalysisOpaqueStructs = 0; antiBranchAnalysisOpaqueStructs < AntiBranchAnalysisOpaqueStructs.length; antiBranchAnalysisOpaqueStructs++) {
        for (int antiBranchAnalysisObfuscateBranchFunCall = 0; antiBranchAnalysisObfuscateBranchFunCall < Booleans.length; antiBranchAnalysisObfuscateBranchFunCall++) {
          for (int antiBranchAnalysisBranchFunFlatten = 0; antiBranchAnalysisBranchFunFlatten < Booleans.length; antiBranchAnalysisBranchFunFlatten++) {
            String output = String.format(command_AntiBranchAnalysis, AntiBranchAnalysisKinds[antiBranchAnalysisKinds], AntiBranchAnalysisOpaqueStructs[antiBranchAnalysisOpaqueStructs], Booleans[antiBranchAnalysisObfuscateBranchFunCall], Booleans[antiBranchAnalysisBranchFunFlatten], "fisso");
            //System.out.println(output);
          }
        }
      }
    }

    String command_AntiAliasAnalysis =
      //"tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n" +
      "   --Transform=InitEntropy --Functions=main \\\n" +
      "   --Transform=InitOpaque \\\n" +
      "      --InitOpaqueStructs=list,array,env,input \\\n" +
      "      --Functions=quicksort,stampa_array \\\n" +
      "   --Transform=AntiAliasAnalysis \\\n" +
      "      --AntiAliasAnalysisObfuscateIndex=%s \\\n" +
      "      --AntiAliasAnalysisBogusEntries=%s \\\n" +
      "      --Functions=quicksort,stampa_array \\\n" +
      "      --out=quicksort_%s.c quicksort.c \n";

    for (int antiAliasAnalysisObfuscateIndex = 0; antiAliasAnalysisObfuscateIndex < Booleans.length; antiAliasAnalysisObfuscateIndex++) {
      for (int antiAliasAnalysisBogusEntries = 0; antiAliasAnalysisBogusEntries < Booleans.length; antiAliasAnalysisBogusEntries++) {
        String output = String.format(command_AntiAliasAnalysis, Booleans[antiAliasAnalysisObfuscateIndex], Booleans[antiAliasAnalysisBogusEntries], "fisso");
        //System.out.println(output);
      }
    }

    String[] AntiTaintAnalysisKinds = {
      "argv",
      "sysCalls",
      "*"
    };
    String[] AntiTaintAnalysisSysCalls = {
      "getpid",
      "scanf",
      "*"
    };
    String[] AntiTaintAnalysisImplicitFlow = {
      "single",
      "compose",
      "select",
      "majority",
      "repeat",
      "until"
    };
    String command_AntiTaintAnalysis =
      //"tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n" +
      "   --Transform=AntiTaintAnalysis \\\n" +
      "      --AntiTaintAnalysisKinds=%s \\\n" +
      "      --AntiTaintAnalysisSysCalls=%s \\\n" +
      "      --AntiTaintAnalysisImplicitFlow=%s \\\n" +
      "      --out=quicksort_%s.c quicksort.c \n";

    for (int antiTaintAnalysisKinds = 0; antiTaintAnalysisKinds < AntiTaintAnalysisKinds.length; antiTaintAnalysisKinds++) {
      for (int antiTaintAnalysisSysCalls = 0; antiTaintAnalysisSysCalls < AntiTaintAnalysisSysCalls.length; antiTaintAnalysisSysCalls++) {
        for (int antiTaintAnalysisImplicitFlow = 0; antiTaintAnalysisImplicitFlow < AntiTaintAnalysisImplicitFlow.length; antiTaintAnalysisImplicitFlow++) {
          String output = String.format(command_AntiTaintAnalysis, AntiTaintAnalysisKinds[antiTaintAnalysisKinds], AntiTaintAnalysisSysCalls[antiTaintAnalysisSysCalls], AntiTaintAnalysisImplicitFlow[antiTaintAnalysisImplicitFlow], "fisso");
          //System.out.println(output);
        }
      }
    }

    String[] RndArgsBogusNo = {
      "2",
      "4",
      "6",
      "8"
    };
    String command_RndArgs =
      //"tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n" +
      "   --Transform=RndArgs \\\n" +
      "      --RndArgsBogusNo=%s \\\n" +
      "      --Functions=quicksort,stampa_array\\\n" +
      "      --out=quicksort_%s.c quicksort.c \n";

    for (int rndArgsBogusNo = 0; rndArgsBogusNo < RndArgsBogusNo.length; rndArgsBogusNo++) {
      String output = String.format(command_RndArgs, RndArgsBogusNo[rndArgsBogusNo], "fisso");
      //System.out.println(output);
    }
    generated_string = all_generated_string;
  }

  static void combinationUtil(String arr[], int n, int r,
    int index, String data[], int i) {
    // Current combination is ready to be printed,
    // print it
    if (index == r) {
      ArrayList < String > appo = new ArrayList < > ();
      for (int j = 0; j < r; j++) {
        System.out.print(data[j] + " ");
        appo.add(data[j]);
      }
      all_subset.add(appo);
      System.out.println("");
      return;
    }

    // When no more elements are there to put in data[]
    if (i >= n)
      return;

    // current is included, put next at next
    // location
    data[index] = arr[i];
    combinationUtil(arr, n, r, index + 1,
      data, i + 1);

    // current is excluded, replace it with
    // next (Note that i+1 is passed, but
    // index is not changed)
    combinationUtil(arr, n, r, index, data, i + 1);
  }

  // The main function that prints all combinations
  // of size r in arr[] of size n. This function
  // mainly uses combinationUtil()
  static void printCombination(String arr[], int n, int r) {
    // A temporary array to store all combination
    // one by one
    String data[] = new String[r];

    // Print all combination using temporary
    // array 'data[]'
    combinationUtil(arr, n, r, 0, data, 0);
  }

  /* Driver function to check for above function */

  public static List < List < String >> listPermutations(List < String > list) {

    if (list.size() == 0) {
      List < List < String >> result = new ArrayList < List < String >> ();
      result.add(new ArrayList < String > ());
      return result;
    }

    List < List < String >> returnMe = new ArrayList < List < String >> ();

    String firstElement = list.remove(0);

    List < List < String >> recursiveReturn = listPermutations(list);
    for (List < String > li: recursiveReturn) {

      for (int index = 0; index <= li.size(); index++) {
        List < String > temp = new ArrayList < String > (li);
        temp.add(index, firstElement);
        returnMe.add(temp);
      }

    }
    return returnMe;
  }

  public static Map < String, String > getCorrectMap(String trasformation) {
    switch (trasformation) {
    case "Flatten":
      return generated_string.get(0);
    case "Split":
      return generated_string.get(1);
    case "Merge":
      return generated_string.get(2);
    case "AddOpaque":
      return generated_string.get(3);
    default:
      return new HashMap < > ();
    }

  }

  public static void main(String[] args) {
    ArrayList < ArrayList < String >> array_result = new ArrayList < > ();
    generateString();
    //String arr[] = { "Flatten", "Split", "Merge", "AddOpaque", "EncodeLiteral", "EncodeData", "EncodeArithmetic", "AntiAlias", "AntiBranchAnalysis", "RndArgs", "AntiTaintAnalysis" };
    String arr[] = {
      "Flatten",
      "Split",
      "Merge",
      "AddOpaque"
    };
    boolean prova = true;
    for (int i = 1; i <= arr.length; i++) {
      all_subset.clear();
      printCombination(arr, arr.length, i);
      // in the arraylist all_subset there are now all the combinations composed of r elements of the arr array
      // now for each different combination we get all the possible permutations
      for (int j = 0; j < all_subset.size(); j++) {
        List < List < String >> current_permutations = listPermutations(all_subset.get(j));
        for (int k = 0; k < current_permutations.size(); k++) {
          List < String > current_permutation = current_permutations.get(k);
          String command = "tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n";
          switch (current_permutation.size()) {
            /*case 1:
                            for (Map.Entry<String, String> set : getCorrectMap(current_permutation.get(0)).entrySet()) {
				try{
                                command = "tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n";
                                command += "   --Transform=InitOpaque \\\n" +
                                        "      --InitOpaqueStructs=list,array \\\n" +
                                        "      --Functions=quicksort \\\n";
                                command += set.getValue();
                                if (! current_permutation.contains("Merge"))
                                {
                                    command += String.format("   --Transform=SoftwareMetrics \\\n" +
                                            "      --Functions=quicksort \\\n" +
                                            "      --SoftwareMetricsFileName=%s/mc-%s.txt \\\n" +
                                            "      --SoftwareMetricsKind=mccabe \\\n", set.getKey(),set.getKey());
                                }
                                else {
                                    command += String.format("   --Transform=SoftwareMetrics \\\n" +
                                            "      --Functions=merged \\\n" +
                                            "      --SoftwareMetricsFileName=%s/mc-%s.txt \\\n" +
                                            "      --SoftwareMetricsKind=mccabe \\\n", set.getKey(),set.getKey());
                                }
				command += String.format("   --out=%s/quicksort_%s.c quicksort.c \n",set.getKey(),set.getKey());

				//if(prova){
				//if(current_permutation.contains("AddOpaque"))				
				System.out.println(command);
				Process directory = Runtime.getRuntime().exec(String.format("mkdir %s", set.getKey()));
				Process proc = Runtime.getRuntime().exec(command);

				BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
      				FileWriter myWriter = new FileWriter("file.txt");
      				String line = "";
      				while ((line = reader.readLine()) != null) {
        				myWriter.write(line + "\n");
      				}
      				myWriter.close();
      				proc.waitFor();
				//}
				
				}
				catch(Exception e)	
				{ 
					e.printStackTrace();
				}
				prova = false;
                            };
                            break;
                        case 2:
                            for (Map.Entry<String, String> set : getCorrectMap(current_permutation.get(0)).entrySet()) {
                                for (Map.Entry<String, String> set1 : getCorrectMap(current_permutation.get(1)).entrySet()) {
				    try{
                                    command = "tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n";
                                    command += "   --Transform=InitOpaque \\\n" +
                                            "      --InitOpaqueStructs=list,array \\\n" +
                                            "      --Functions=quicksort \\\n";
                                    command += set.getValue();
                                    command += set1.getValue();
                                if (! current_permutation.contains("Merge"))
                                {
                                    command += String.format("   --Transform=SoftwareMetrics \\\n" +
                                            "      --Functions=quicksort \\\n" +
                                            "      --SoftwareMetricsFileName=%s/mc-%s.txt \\\n" +
                                            "      --SoftwareMetricsKind=mccabe \\\n", set.getKey()+ set1.getKey(),set.getKey()+set1.getKey());
                                }
                                else {
                                    command += String.format("   --Transform=SoftwareMetrics \\\n" +
                                            "      --Functions=merged \\\n" +
                                            "      --SoftwareMetricsFileName=%s/mc-%s.txt \\\n" +
                                            "      --SoftwareMetricsKind=mccabe \\\n", set.getKey() + set1.getKey() ,set.getKey() + set1.getKey());
                                }
				command += String.format("   --out=%s/quicksort_%s.c quicksort.c",set.getKey() + set1.getKey(),set.getKey() + set1.getKey());

				Process directory = Runtime.getRuntime().exec(String.format("mkdir %s", set.getKey() + set1.getKey()));
				
				
				System.out.println(command);
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				Process proc = Runtime.getRuntime().exec(command);
				BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
      				FileWriter myWriter = new FileWriter("file.txt");
      				String line = "";
      				while ((line = reader.readLine()) != null) {
        				myWriter.write(line + "\n");
      				}
      				myWriter.close();
      				proc.waitFor();
				
				}
				catch(Exception e)	
				{ 
					e.printStackTrace();
				}
				prova = false;
				};
			 break;
        case 3:
          for (Map.Entry < String, String > set: getCorrectMap(current_permutation.get(0)).entrySet()) {
            for (Map.Entry < String, String > set1: getCorrectMap(current_permutation.get(1)).entrySet()) {
              for (Map.Entry < String, String > set2: getCorrectMap(current_permutation.get(2)).entrySet()) {
                try {
		  String abbrev = ((set.getKey() + set1.getKey() + set2.getKey()).replace("Flatten","F")).replace("Split","S").replace("Merge", "M").replace("Obfuscate","O").replace("RandomizeBlocks","R").replace("OpaqueStructs","OS").replace("ConditionalKinds","C").replace("BasicBlocks","B").replace("list","L");
                  command = "tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n";
                  command += "   --Transform=InitOpaque \\\n" +
                    "      --InitOpaqueStructs=list,array \\\n" +
                    "      --Functions=quicksort \\\n";
                  command += set.getValue();
                  command += set1.getValue();
                  command += set2.getValue();
                  if (!current_permutation.contains("Merge")) {
                    command += String.format("   --Transform=SoftwareMetrics \\\n" +
                      "      --Functions=quicksort \\\n" +
                      "      --SoftwareMetricsFileName=%s/mc-%s.txt \\\n" +
                      "      --SoftwareMetricsKind=mccabe \\\n", abbrev, abbrev);
                    command += String.format("   --Transform=SoftwareMetrics \\\n" +
                      "      --Functions=quicksort \\\n" +
                      "      --SoftwareMetricsFileName=%s/h-%s.txt \\\n" +
                      "      --SoftwareMetricsKind=halstead \\\n", abbrev, abbrev);
                  } else {
                    command += String.format("   --Transform=SoftwareMetrics \\\n" +
                      "      --Functions=merged \\\n" +
                      "      --SoftwareMetricsFileName=%s/mc-%s.txt \\\n" +
                      "      --SoftwareMetricsKind=mccabe \\\n", abbrev, abbrev);
                    command += String.format("   --Transform=SoftwareMetrics \\\n" +
                      "      --Functions=merged \\\n" +
                      "      --SoftwareMetricsFileName=%s/h-%s.txt \\\n" +
                      "      --SoftwareMetricsKind=halstead \\\n", abbrev, abbrev);
                  }
                  //command += String.format("   --out=quicksort_%s.c quicksort.c \n", set.getKey() + set1.getKey() + set2.getKey());
		  command += String.format("   --out=%s/quicksort_%s.c quicksort.c",abbrev,abbrev);


                  Process directory = Runtime.getRuntime().exec(String.format("mkdir %s", abbrev));

                  System.out.println(command);
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  Process proc = Runtime.getRuntime().exec(command);
                  BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                  FileWriter myWriter = new FileWriter("file.txt");
                  String line = "";
                  while ((line = reader.readLine()) != null) {
                    myWriter.write(line + "\n");
                  }
                  myWriter.close();
                  proc.waitFor();

                } catch (Exception e) {
                  e.printStackTrace();
                }
                prova = false;
              }
            }
          };

          break;
          */
          case 4:
            for (Map.Entry < String, String > set: getCorrectMap(current_permutation.get(0)).entrySet()) {
              for (Map.Entry < String, String > set1: getCorrectMap(current_permutation.get(1)).entrySet()) {
                for (Map.Entry < String, String > set2: getCorrectMap(current_permutation.get(2)).entrySet()) {
                  for (Map.Entry < String, String > set3: getCorrectMap(current_permutation.get(3)).entrySet()) {
                    try {
                      String abbrev = ((set.getKey() + set1.getKey() + set2.getKey() + set3.getKey()).replace("Flatten", "F")).replace("Split", "S").replace("Merge", "M").replace("Obfuscate", "O").replace("RandomizeBlocks", "R").replace("OpaqueStructs", "OS").replace("ConditionalKinds", "C").replace("BasicBlocks", "B").replace("list", "L").replace("merge", "M").replace("AddOpaque", "AO");
                      command = "tigress --Environment=x86_64:Linux:Gcc:4.6 --Seed=0 \\\n";
                      command += "   --Transform=InitOpaque \\\n" +
                        "      --InitOpaqueStructs=list,array \\\n" +
                        "      --Functions=quicksort,stampa_array,insert_array \\\n";
                      command += set.getValue();
                      command += set1.getValue();
                      command += set2.getValue();
                      command += set3.getValue();
                      if (!current_permutation.contains("Merge")) {
                        command += String.format("   --Transform=SoftwareMetrics \\\n" +
                          "      --Functions=quicksort \\\n" +
                          "      --SoftwareMetricsFileName=%s/mc-%s.txt \\\n" +
                          "      --SoftwareMetricsKind=mccabe \\\n", abbrev, abbrev);
                        command += String.format("   --Transform=SoftwareMetrics \\\n" +
                          "      --Functions=quicksort \\\n" +
                          "      --SoftwareMetricsFileName=%s/h-%s.txt \\\n" +
                          "      --SoftwareMetricsKind=halstead \\\n", abbrev, abbrev);
                      } else {

                        command += String.format("   --Transform=SoftwareMetrics \\\n" +
                          "      --Functions=merged \\\n" +
                          "      --SoftwareMetricsFileName=%s/mc-%s.txt \\\n" +
                          "      --SoftwareMetricsKind=mccabe \\\n", abbrev, abbrev);
                        command += String.format("   --Transform=SoftwareMetrics \\\n" +
                          "      --Functions=merged \\\n" +
                          "      --SoftwareMetricsFileName=%s/h-%s.txt \\\n" +
                          "      --SoftwareMetricsKind=halstead \\\n", abbrev, abbrev);
                      }
                      command += String.format("   --out=%s/quicksort_%s.c quicksort.c \n", abbrev, abbrev);
                      Process directory = Runtime.getRuntime().exec(String.format("mkdir %s", abbrev));

                      System.out.println(command);
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      Process proc = Runtime.getRuntime().exec(command);
                      BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                      FileWriter myWriter = new FileWriter("file.txt");
                      String line = "";
                      while ((line = reader.readLine()) != null) {
                        myWriter.write(line + "\n");
                      }
                      myWriter.close();
                      proc.waitFor();
                    } catch (Exception e) {
                      e.printStackTrace();
                    }
                    prova = false;

                  }
                }
              }
            }
            break;

          }

        }
      }
    }

  }
