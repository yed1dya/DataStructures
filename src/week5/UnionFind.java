package week5;
class UFNode{
	int parent;
	int rank; //rank[k]>=height of tree number k
	public UFNode(int p, int r){
		parent = p;
		rank = r;
	}
	public String toString(){
		return "[p:"+parent + ", r:"+rank + "]";
	}
}
public class UnionFind {

	UFNode[] nodes;
	public UnionFind(int max){
		nodes = new UFNode[max];
	}
	// Makes a set containing only a given element (a singleton). 
	public void makeSet(int k){
		nodes[k] = new UFNode(k, 0);
	}	
	// Determine which subset a particular element is in. 
	// Find typically returns an item from this set that serves as its "representative". 
	// Also, by comparing the result of two Find operations, one can determine whether 
	// two elements are in the same subset.
	// (Using path compression)
	public int find(int v) {
		int p = nodes[v].parent;
		if (v == p) {
			return v;
		}
		return nodes[v].parent = find(nodes[p].parent);
	}
	//Join two subsets into a single subset.
	public void union(int u, int v) {
		int root1 = find(u);
		int root2 = find(v);
		if (root2 == root1) return;
		if (nodes[root1].rank > nodes[root2].rank){
			nodes[root2].parent = root1;
		}
		else if (nodes[root2].rank > nodes[root1].rank){
			nodes[root1].parent = root2;
		}
		else {//rank[root2] == rank[root1]
			nodes[root2].parent = root1;
			nodes[root1].rank++;
		}
	}
	public String toString(){
		String ans = "";
		for (int i = 0; i < nodes.length/2; i++) {
			ans = ans + "n" + i + ":" + nodes[i] + "; ";
		}
		ans = ans + "\n";
		for (int i = nodes.length/2; i < nodes.length; i++) {
			ans = ans + "n" + i + ":" + nodes[i] + "; ";
		}
		return ans;
	}	
	public static void test1(){
		int numSets = 5;
		UnionFind uf = new UnionFind(numSets);
		for (int i = 0; i < numSets; i++) {
			uf.makeSet(i);
		}
		System.out.println(uf);
		uf.union(1,2);
		System.out.println("union 1 2");
		System.out.println("find 1 "+uf.find(1) + ", find 2 " + uf.find(2));
		System.out.println(uf);
		uf.union(3,4);
		System.out.println("union 3 4");
		System.out.println(uf);
		uf.union(1,3);
		System.out.println("union 1 3");
		System.out.println(uf);
		uf.union(0,4);
		System.out.println("union 1 4");
		System.out.println(uf);
	}
	public static void test2(){
		int numSets = 11;
		UnionFind uf = new UnionFind(numSets);
		for (int i = 0; i < numSets; i++) {
			uf.makeSet(i);
		}
		uf.union(7, 8);
		uf.union(3, 6);                                                         
		uf.union(2, 5);
		uf.union(7, 10);
		uf.union(1, 4);
		uf.union(3, 7);
		uf.union(2, 7);
		uf.union(1, 9);
		System.out.println("union: \n"+uf);
		uf.union(uf.find(7), uf.find(9));
		System.out.println("union(uf.find(7), uf.find(9): \n"+uf);
		uf.find(9);
		System.out.println("find(9): \n"+uf);

	}
	public static void test3(){
		int numSets = 9;
		UnionFind uf = new UnionFind(numSets);
		for (int i = 0; i < numSets; i++) {
			uf.makeSet(i);
		}
		uf.union(1,8);
		uf.union(6,7);
		uf.union(4,5);
		uf.union(5,1);
		uf.union(2,4);
		uf.union(3,8);
		System.out.println("union: \n"+uf);
	}
	public static void test4(){
		int numSets = 10;
		UnionFind uf = new UnionFind(numSets);
		for (int i = 0; i < numSets; i++) {
			uf.makeSet(i);
		}
		uf.union(3,4);
		System.out.println("union: \n"+uf);
		uf.union(3,8);
		System.out.println("union: \n"+uf);
		uf.union(6,5);
		System.out.println("union: \n"+uf);
		uf.union(9,4);
		System.out.println("union: \n"+uf);
		uf.union(2,1);
		System.out.println("union: \n"+uf);
		uf.union(8,9);
		System.out.println("union: \n"+uf);
		uf.union(2,7);
		System.out.println("union: \n"+uf);
		uf.union(5,0);
		System.out.println("union: \n"+uf);
		uf.union(6,1);
		System.out.println("union: \n"+uf);
		uf.union(7,3);
		System.out.println("union: \n"+uf);
	}
	public static void main(String[] args) {
		test4();
	}

}
