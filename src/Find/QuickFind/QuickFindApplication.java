package Find.QuickFind;

/**
 * Created by jackstrom on 2016/5/5.
 */
public class QuickFindApplication {
    public static void main(String[] args){
        QF qf = new QF(10);
        qf.union(1,2);
        qf.union(3,4);
        qf.union(4,5);
        qf.union(5,6);
        qf.union(8,9);

        System.out.println("Find/QuickFind");
        qf.print();
        System.out.println();
        System.out.println(qf.connected(6,4));//true

        System.out.println("QuickUnion");
        QuickUnion qu = new QuickUnion(10);
        qu.union(1,2);
        qu.union(3,4);
        qu.union(4,5);
        qu.union(5,7);
        qu.union(2,7);
        qu.print();
        System.out.println();
        System.out.println(qu.connected(3,7));//true

        System.out.println("WeightedQuickUnion");
        WeightedQuickUnion wqu = new WeightedQuickUnion(10);
        wqu.union(3,4);
        wqu.union(3,8);
        wqu.union(6,5);
        wqu.union(9,4);
        wqu.union(2,1);
        wqu.union(5,0);
        wqu.union(7,2);
        wqu.union(6,1);
        wqu.union(7,3);
        wqu.print();
        System.out.println();
        wqu.printsz();
        //here has question,
        System.out.println();
        System.out.println(wqu.connected(3,7));

    }
}
