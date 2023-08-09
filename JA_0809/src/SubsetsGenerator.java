import java.util.ArrayList;
import java.util.List;

public class SubsetsGenerator {
    public static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void generateSubsets(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> subsets) {
        if (index == nums.length) {
            subsets.add(new ArrayList<>(currentSubset));
            return;
        }

        // Exclude the current element
        generateSubsets(nums, index + 1, currentSubset, subsets);

        // Include the current element
        currentSubset.add(nums[index]);
        generateSubsets(nums, index + 1, currentSubset, subsets);
        currentSubset.remove(currentSubset.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> allSubsets = generateSubsets(nums);

        for (List<Integer> subset : allSubsets) {
            System.out.println(subset);
        }
    }
}
