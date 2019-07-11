7. 重建二叉树
```java
public class Main {
	
	public TreeNode rebuild (int [] preorder, int [] inorder) {
		int len = preorder.length;
		
		if (len == 0) {
			return null;
		}
		
		return rebuild(preorder, 0, len-1, inorder, 0, len-1);
	}
	
	public TreeNode rebuild (int [] preorder, int pl, int pr, int [] inorder, int ol, int or) {
		
		if (pl > pr) {
			return null;
		}

		if (pl == pr) {
			return new TreeNode(preorder[pl]); 
		}
		
		int split = 0;
		for (int i = ol; i<=or; i++) {
			if (inorder[i] == preorder[pl]) {
				split = i;
				break;
			}
		}
		
		TreeNode node = new TreeNode(preorder[pl]);
		
		node.left = rebuild(preorder, pl+1, pl+(split-ol), inorder, ol, split-1);
		node.right = rebuild(preorder, pl+(split-ol) + 1, pr, inorder, split+1, or);

		return node;
	}
}
```

9. 用两个栈实现队列
```java
public class Main {

	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();

	public void push(int e) {
		stack1.push();
	}

	public int pop() {
		
		if (!stack2.isEmpty()) {
			return stack2.pop();
		}

		if (stack1.isEmpty()) {
			return -1;
		}
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}	
		return stack2.pop();
	}
}

```

11. 旋转数组的最小数字

14. 剪绳子

15. 二进制中1的个数
```java
// (n-1) & n: 可以把最右边的1变成0
public class Main {

	public int count1Bits (int n) {

		int count = 0;

		while (n != 0) {
			count++;
			n = n & (n-1);
		}
		return count;
	}

}
```

16. 数值的整数次方
```java

```

17. 打印从1到最大的n位数\
*字符串模拟/全排列*

18. 删除链表节点 
    1.  O(1)时间复杂度删除给定节点
    2.  删除重复节点
19. 正则表达式匹配
20. 表示数值的字符串
21. 调整数组顺序使奇数位于偶数前面
    1. 不考虑稳定性: 双指针
	2. 考虑稳定性
22. 链表中倒数第k个结点: 双指针解法
23. 链表中环的入口节点
24. 反转链表(递归)
25. 合并两个排序的链表(递归/迭代)
26. 树的子结构
27. 二叉树的镜像(递归/循环)
28. 对称二叉树
29. 顺时针打印矩阵
30. 包含min函数的栈
31. 栈的压入、弹出序列